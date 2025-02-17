package System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// TransaksiService.java
public class TransaksiService {
    public double getSaldoTerakhir(int userId) {
        try (Connection conn = DatabaseConnection.connect()) {
            if (conn != null) {
                String query = "SELECT saldo FROM tabungan WHERE user_id = ? ORDER BY id DESC LIMIT 1";
                try (PreparedStatement ps = conn.prepareStatement(query)) {
                    ps.setInt(1, userId);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        return rs.getDouble("saldo");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0; // Jika tidak ada transaksi sebelumnya
    }

    private double hitungSaldoBaru(double saldoTerakhir, double jumlah, String jenisMutasi) {
        if ("masuk".equals(jenisMutasi)) {
            return saldoTerakhir + jumlah;
        } else if ("keluar".equals(jenisMutasi)) {
            return saldoTerakhir - jumlah;
        }
        return saldoTerakhir;
    }
}