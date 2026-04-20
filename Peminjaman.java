import java.util.*;

public class Peminjaman {
    private String kodeTrans;
    private String nis;
    private String kodeBuku;
    private String tglPinjam;
    private String tglKembali;
    private int status; // 0 = belum, 1 = sudah

    private static final String FILE = "Perpus_Database.txt";
    static Scanner sc = new Scanner(System.in);

    //  TAMBAH PEMINJAMAN 
    public static void tambah() {
        FileHandler fh = new FileHandler(FILE);

        System.out.print("Kode Transaksi : ");
        String kode = sc.nextLine();

        Siswa.tampil();
        System.out.print("Masukkan NIS   : ");
        String nis = sc.nextLine();

        if (Siswa.cari(nis) == null) {
            System.out.println("Siswa tidak ditemukan!");
            return;
        }

        String bukuDipinjam = "";

        for (int i = 0; i < 2; i++) {
            Buku.tampil();
            System.out.print("Kode Buku ke-" + (i+1) + " (enter jika selesai): ");
            String kb = sc.nextLine();

            if (kb.isEmpty()) break;

            Buku b = Buku.cari(kb);

            if (b == null) {
                System.out.println("Buku tidak ada!");
                i--;
            } else if (b.getStok() <= 0) {
                System.out.println("Stok habis!");
                i--;
            } else {
                bukuDipinjam += kb + ",";
            }
        }

        System.out.print("Tanggal Pinjam  : ");
        String tglPinjam = sc.nextLine();

        System.out.print("Tanggal Kembali : ");
        String tglKembali = sc.nextLine();

        fh.tulis(kode + "|" + nis + "|" + bukuDipinjam + "|" + tglPinjam + "|" + tglKembali + "|0");

        System.out.println("Peminjaman berhasil!");
    }

    //  KEMBALIKAN 
    public static void kembalikan() {
        FileHandler fh = new FileHandler(FILE);
        List<String> data = fh.baca();
        List<String> baru = new ArrayList<>();

        System.out.print("Kode Transaksi yang dikembalikan: ");
        String kode = sc.nextLine();

        boolean ketemu = false;

        for (String d : data) {
            String[] p = d.split("\\|");

            if (p[0].equals(kode)) {
                p[5] = "1";
                ketemu = true;
            }

            baru.add(String.join("|", p));
        }

        if (!ketemu) {
            System.out.println("Transaksi tidak ditemukan!");
            return;
        }

        fh.hapusData();

        for (String d : baru) {
            fh.tulis(d);
        }

        System.out.println("Buku berhasil dikembalikan!");
    }

    // AMBIL DATA 
    public static List<String> getData() {
        FileHandler fh = new FileHandler(FILE);
        return fh.baca();
    }

    //  CEK TERLAMBAT 
    public static boolean terlambat(String tglKembali) {
        String hariIni = "2026-04-20"; 
        return hariIni.compareTo(tglKembali) > 0;
    }
}
