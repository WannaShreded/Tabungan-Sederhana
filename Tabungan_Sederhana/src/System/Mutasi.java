package System;

import java.util.Date;

public class Mutasi {
    private int id;
    private int userId;
    private Date tanggalMutasi;
    private String jenisMutasi;
    private double jumlah;
    private double saldo;

    public Mutasi(int id, int userId, Date tanggalMutasi, String jenisMutasi, double jumlah, double saldo) {
        this.id = id;
        this.userId = userId;
        this.tanggalMutasi = tanggalMutasi;
        this.jenisMutasi = jenisMutasi;
        this.jumlah = jumlah;
        this.saldo = saldo;
    }

    // Getter dan Setter
    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public Date getTanggalMutasi() {
        return tanggalMutasi;
    }

    public String getJenisMutasi() {
        return jenisMutasi;
    }

    public double getJumlah() {
        return jumlah;
    }

    public double getSaldo() {
        return saldo;
    }
}
