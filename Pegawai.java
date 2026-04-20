package LK6;

import java.util.Date;

public class Pegawai {
    private String NIP;
    private String nama;
    private Date tanggalLahir;
    private String password;

    private Auth auth = new Auth();

    public Pegawai(String NIP, String nama, Date tanggalLahir, String password) {
        this.NIP = NIP;
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.password = password;
    }

    public boolean login(String username, String password) {
        return auth.authenticate(username, password);
    }

    public void logout() {
        auth.logout();
        System.out.println("Logout berhasil");
    }

    public String toString() {
        return NIP + "," + nama + "," + tanggalLahir;
    }
}