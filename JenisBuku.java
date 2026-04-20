import java.util.*;

public class JenisBuku {
    private String kodeJenis;
    private String namaJenis;

    private static final String FILE = "jenis_buku.txt";
    static Scanner sc = new Scanner(System.in);

    public JenisBuku() {
    }

    public JenisBuku(String kodeJenis, String namaJenis) {
        this.kodeJenis = kodeJenis;
        this.namaJenis = namaJenis;
    }

    public String getKodeJenis() {
        return kodeJenis;
    }

    public String getNamaJenis() {
        return namaJenis;
    }

    // Baca semua data dari file
    public static List<JenisBuku> lihat() {
        List<JenisBuku> list = new ArrayList<>();
        for (String b : FileHandler.baca(FILE)) {
            String[] p = b.split("\\|");
            if (p.length == 2)
                list.add(new JenisBuku(p[0], p[1]));
        }
        return list;
    }

    // Simpan ulang semua data ke file
    private static void simpanSemua(List<JenisBuku> list) {
        FileHandler.hapusData(FILE);
        for (JenisBuku j : list)
            FileHandler.tulis(FILE, j.kodeJenis + "|" + j.namaJenis);
    }

    public static void tambah() {
        System.out.print("Kode Jenis : ");
        String kode = sc.nextLine();
        for (JenisBuku j : lihat()) {
            if (j.kodeJenis.equals(kode)) {
                System.out.println("Kode sudah ada!");
                return;
            }
        }
        System.out.print("Nama Jenis : ");
        String nama = sc.nextLine();
        FileHandler.tulis(FILE, kode + "|" + nama);
        System.out.println("Jenis buku ditambahkan.");
    }

    public static void edit() {
        System.out.print("Kode yang diedit: ");
        String kode = sc.nextLine();
        List<JenisBuku> list = lihat();
        for (JenisBuku j : list) {
            if (j.kodeJenis.equals(kode)) {
                System.out.print("Nama baru [" + j.namaJenis + "]: ");
                String nama = sc.nextLine();
                if (!nama.isEmpty())
                    j.namaJenis = nama;
                simpanSemua(list);
                System.out.println("Data diperbarui.");
                return;
            }
        }
        System.out.println("Kode tidak ditemukan.");
    }

    public static void tampil() {
        List<JenisBuku> list = lihat();
        System.out.println("\n- Data Jenis Buku ");
        System.out.printf("%-10s %-20s%n", "Kode", "Nama Jenis");
        System.out.println("-".repeat(30));
        if (list.isEmpty())
            System.out.println("Belum ada data.");
        for (JenisBuku j : list)
            System.out.printf("%-10s %-20s%n", j.kodeJenis, j.namaJenis);
    }

    public static JenisBuku cari(String kode) {
        for (JenisBuku j : lihat())
            if (j.kodeJenis.equals(kode))
                return j;
        return null;
    }
}
