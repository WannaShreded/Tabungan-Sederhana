package System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import System.DatabaseConnection;

public class MutasiDAO {
    public List<Transaksi> getMutasiByUserId(int userId) {
        List<Transaksi> mutasiList = new ArrayList<>();
        try (Connection conn = DatabaseConnection.connect()) {
            if (conn != null) {
                String query = "SELECT id, user_id, tanggal_mutasi, jenis_mutasi, jumlah_mutasi FROM tabungan WHERE user_id = ?";
                try (PreparedStatement ps = conn.prepareStatement(query)) {
                    ps.setInt(1, userId);
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        String jenisMutasi = rs.getString("jenis_mutasi");
                        Transaksi transaksi;

                        if ("masuk".equals(jenisMutasi)) {
                            transaksi = new MutasiMasuk(
                                rs.getInt("id"),
                                rs.getInt("user_id"),
                                rs.getDate("tanggal_mutasi"),
                                rs.getDouble("jumlah_mutasi")
                            );
                        } else {
                            transaksi = new MutasiKeluar(
                                rs.getInt("id"),
                                rs.getInt("user_id"),
                                rs.getDate("tanggal_mutasi"),
                                rs.getDouble("jumlah_mutasi")
                            );
                        }

                        mutasiList.add(transaksi);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mutasiList;
    }

//    public void saveTransaksi(Transaksi transaksi) {
//        try (Connection conn = DatabaseConnection.connect()) {
//            if (conn != null) {
//                String query = "INSERT INTO tabungan (user_id, tanggal_mutasi, jenis_mutasi, jumlah_mutasi) VALUES (?, ?, ?, ?)";
//                try (PreparedStatement ps = conn.prepareStatement(query)) {
//                    ps.setInt(1, transaksi.getUserId());
//                    ps.setDate(2, new java.sql.Date(transaksi.getTanggal().getTime()));
//                    ps.setString(3, transaksi instanceof MutasiMasuk ? "masuk" : "keluar");
//                    ps.setDouble(4, transaksi.getJumlah());
//                    ps.executeUpdate();
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}

