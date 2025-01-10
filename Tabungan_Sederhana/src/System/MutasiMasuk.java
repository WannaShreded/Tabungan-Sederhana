package System;

import java.util.Date;

public class MutasiMasuk extends Transaksi {

    public MutasiMasuk(int id, int userId, Date tanggal, double jumlah) {
        super(id, userId, tanggal, jumlah);
    }

    @Override
    public void simpan() {
        // Implementasi khusus untuk menyimpan mutasi masuk
        System.out.println("Menyimpan mutasi masuk: " + getJumlah());
    }
}
