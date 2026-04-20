package PEMLAN.LK6;

import java.util.*;

public class Siswa {
    private String NIS;
    private String nama;
    private String alamat;

    private static final String FILE = "siswa.txt";
    static Scanner sc = new Scanner(System.in);

    public Siswa() {
    }

    public Siswa(String NIS, String nama, String alamat) {
        this.NIS = NIS;
        this.nama = nama;
        this.alamat = alamat;
    }

    public String getNIS() {
        return NIS;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public static List<Siswa> lihat() {
        List<Siswa> list = new ArrayList<>();
        for (String b : FileHandler.baca(FILE)) {
            String[] p = b.split("\\|");
            if (p.length == 3)
                list.add(new Siswa(p[0], p[1], p[2]));
        }
        return list;
    }

    private static void simpanSemua(List<Siswa> list) {
        FileHandler.hapusData(FILE);
        for (Siswa s : list)
            FileHandler.tulis(FILE, s.NIS + "|" + s.nama + "|" + s.alamat);
    }

    public static void tambah() {
        System.out.print("NIS    : ");
        String nis = sc.nextLine();
        for (Siswa s : lihat()) {
            if (s.NIS.equals(nis)) {
                System.out.println("NIS sudah ada!");
                return;
            }
        }
        System.out.print("Nama   : ");
        String nama = sc.nextLine();
        System.out.print("Alamat : ");
        String alamat = sc.nextLine();
        FileHandler.tulis(FILE, nis + "|" + nama + "|" + alamat);
        System.out.println("Siswa ditambahkan.");
    }

    public static void edit() {
        System.out.print("NIS yang diedit: ");
        String nis = sc.nextLine();
        List<Siswa> list = lihat();
        for (Siswa s : list) {
            if (s.NIS.equals(nis)) {
                System.out.print("Nama baru [" + s.nama + "]: ");
                String nama = sc.nextLine();
                if (!nama.isEmpty())
                    s.nama = nama;
                System.out.print("Alamat baru [" + s.alamat + "]: ");
                String alamat = sc.nextLine();
                if (!alamat.isEmpty())
                    s.alamat = alamat;
                simpanSemua(list);
                System.out.println("Data diperbarui.");
                return;
            }
        }
        System.out.println("NIS tidak ditemukan.");
    }

    public static void hapus() {
        System.out.print("NIS yang dihapus: ");
        String nis = sc.nextLine();
        List<Siswa> list = lihat();
        if (list.removeIf(s -> s.NIS.equals(nis))) {
            simpanSemua(list);
            System.out.println("Data dihapus.");
        } else {
            System.out.println("NIS tidak ditemukan.");
        }
    }

    public static void tampil() {
        List<Siswa> list = lihat();
        System.out.println("\n- Data Siswa ");
        System.out.printf("%-10s %-20s %-25s%n", "NIS", "Nama", "Alamat");
        System.out.println("-".repeat(55));
        if (list.isEmpty())
            System.out.println("Belum ada data.");
        for (Siswa s : list)
            System.out.printf("%-10s %-20s %-25s%n", s.NIS, s.nama, s.alamat);
    }

    public static Siswa cari(String nis) {
        for (Siswa s : lihat())
            if (s.NIS.equals(nis))
                return s;
        return null;
    }
}