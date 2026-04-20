import java.util.*;

public class Buku {
    private String kodeBuku;
    private String judul;
    private JenisBuku jenisBuku;
    private int stok;

    private static final String FILE = "buku.txt";
    static Scanner sc = new Scanner(System.in);

    public Buku() {
    }

    public Buku(String kodeBuku, String judul, JenisBuku jenisBuku, int stok) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.jenisBuku = jenisBuku;
        this.stok = stok;
    }

    public String getKodeBuku() {
        return kodeBuku;
    }

    public String getJudul() {
        return judul;
    }

    public JenisBuku getJenisBuku() {
        return jenisBuku;
    }

    public int getStok() {
        return stok;
    }

    public static List<Buku> lihat() {
        List<Buku> list = new ArrayList<>();
        for (String b : FileHandler.baca(FILE)) {
            String[] p = b.split("\\|");
            if (p.length == 4) {
                JenisBuku jenis = JenisBuku.cari(p[2]);
                if (jenis == null)
                    jenis = new JenisBuku(p[2], "?");
                int stok = 0;
                try {
                    stok = Integer.parseInt(p[3]);
                } catch (NumberFormatException e) {
                }
                list.add(new Buku(p[0], p[1], jenis, stok));
            }
        }
        return list;
    }

    public static void simpanSemua(List<Buku> list) {
        FileHandler.hapusData(FILE);
        for (Buku b : list)
            FileHandler.tulis(FILE, b.kodeBuku + "|" + b.judul + "|" + b.jenisBuku.getKodeJenis() + "|" + b.stok);
    }

    public static void tambah() {
        System.out.print("Kode Buku : ");
        String kode = sc.nextLine();
        for (Buku b : lihat()) {
            if (b.kodeBuku.equals(kode)) {
                System.out.println("Kode sudah ada!");
                return;
            }
        }
        System.out.print("Judul     : ");
        String judul = sc.nextLine();

        JenisBuku.tampil();
        System.out.print("Kode Jenis: ");
        String kodeJenis = sc.nextLine();
        if (JenisBuku.cari(kodeJenis) == null) {
            System.out.println("Kode jenis tidak ada!");
            return;
        }

        System.out.print("Stok: ");
        int stok = 0;
        try {
            stok = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Stok harus angka!");
            return;
        }

        FileHandler.tulis(FILE, kode + "|" + judul + "|" + kodeJenis + "|" + stok);
        System.out.println("Buku ditambahkan.");
    }

    public static void edit() {
        System.out.print("Kode yang diedit: ");
        String kode = sc.nextLine();
        List<Buku> list = lihat();
        for (Buku b : list) {
            if (b.kodeBuku.equals(kode)) {
                System.out.print("Judul baru [" + b.judul + "]: ");
                String judul = sc.nextLine();
                if (!judul.isEmpty())
                    b.judul = judul;
                System.out.print("Stok baru [" + b.stok + "]: ");
                String stokStr = sc.nextLine();
                if (!stokStr.isEmpty()) {
                    try {
                        b.stok = Integer.parseInt(stokStr);
                    } catch (NumberFormatException e) {
                        System.out.println("Stok tidak valid.");
                    }
                }
                simpanSemua(list);
                System.out.println("Data diperbarui.");
                return;
            }
        }
        System.out.println("Kode tidak ditemukan.");
    }

    public static void hapus() {
        System.out.print("Kode yang dihapus: ");
        String kode = sc.nextLine();
        List<Buku> list = lihat();
        if (list.removeIf(b -> b.kodeBuku.equals(kode))) {
            simpanSemua(list);
            System.out.println("Data dihapus.");
        } else {
            System.out.println("Kode tidak ditemukan.");
        }
    }

    public static void tampil() {
        List<Buku> list = lihat();
        System.out.println("\n- Data Buku ");
        System.out.printf("%-8s %-25s %-12s %-5s%n", "Kode", "Judul", "Jenis", "Stok");
        System.out.println("-".repeat(52));
        if (list.isEmpty())
            System.out.println("Belum ada data.");
        for (Buku b : list)
            System.out.printf("%-8s %-25s %-12s %-5d%n",
                    b.kodeBuku, b.judul, b.jenisBuku.getNamaJenis(), b.stok);
    }

    public static Buku cari(String kode) {
        for (Buku b : lihat())
            if (b.kodeBuku.equals(kode))
                return b;
        return null;
    }
}
