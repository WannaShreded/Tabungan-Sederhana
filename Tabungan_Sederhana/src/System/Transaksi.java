package System;

import java.util.Date;

public class Transaksi {
    private int id;
    private int userId;
    private Date tanggal;
    private double jumlah;

    public Transaksi(int id, int userId, Date tanggal, double jumlah) {
        this.id = id;
        this.userId = userId;
        this.tanggal = tanggal;
        this.jumlah = jumlah;
    }

    // Getter dan Setter
    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    // Metode untuk menyimpan transaksi ke database
    public void simpan() {
        // Implementasi default (bisa di-override di subclass)
        System.out.println("Menyimpan transaksi umum");
    }
}
