import java.util.*;

public class Laporan {

    //  BELUM KEMBALI
    public static void belumKembali() {
        System.out.println("\n=== Buku Belum Dikembalikan ===");

        List<String> data = Peminjaman.getData();

        for (String d : data) {
            String[] p = d.split("\\|");

            if (p[5].equals("0")) {
                System.out.println("Kode : " + p[0] +
                        " | NIS : " + p[1] +
                        " | Buku : " + p[2]);
            }
        }
    }

    //  TERLAMBAT 
    public static void terlambat() {
        System.out.println("\n=== Siswa Terlambat ===");

        List<String> data = Peminjaman.getData();

        for (String d : data) {
            String[] p = d.split("\\|");

            if (p[5].equals("0") && Peminjaman.terlambat(p[4])) {
                System.out.println("NIS " + p[1] + " terlambat!");
            }
        }
    }

    //  RIWAYAT 
    public static void semua() {
        System.out.println("\n=== Semua Data Peminjaman ===");

        List<String> data = Peminjaman.getData();

        for (String d : data) {
            System.out.println(d);
        }
    }
}
