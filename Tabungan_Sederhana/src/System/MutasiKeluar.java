package System;

import java.util.Date;

public class MutasiKeluar extends Transaksi {

    public MutasiKeluar(int id, int userId, Date tanggal, double jumlah) {
        super(id, userId, tanggal, jumlah);
    }

    @Override
    public void simpan() {
        // Implementasi khusus untuk menyimpan mutasi keluar
        System.out.println("Menyimpan mutasi keluar: " + getJumlah());
    }
}
