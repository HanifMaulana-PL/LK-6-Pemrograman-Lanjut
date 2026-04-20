# LK-6-Pemrograman-Lanjut


Class BUKU.java :
Class ini untuk menyimpan data buku pada sistem perpustakaan, berfungsi untuk menyimpan atribut buku, sekaligus pengoperasian data untuk mengedit data buku, juga untuk mencari data buku yang disimpan dalam file.

Class JenisBuku.java :
Class ini untuk merepresentasikan jenis buku dalam sistem perpustakaan, class ini menyimpan data kode jenis juga nama jenis dari buku, serta memiliki fungsi  untuk mengedit class melalui class Auth.java.

Class Siswa.java
Class siswa digunakan untuk menyimpan data siswa dalam sistem perpustakaan, menyimpan data nama, NIM, alamat, dan juga memiliki fungsi untuk mengedit file nya melalui class Auth.java.

Class Auth.java :
Class ini berfungsi untuk menangani proses autentikasi dari siswa atau pengguna dalam sistem perpustakaan. Class ini juga memferivikasi nama pengguna dan password nya, juga memiliki fitur login dan logout untuk pengguna.

Class FileHandler.java :
Class ini adalah class untuk menginput  data dan memberikan output dari data yang dimasukan pada sistem perpustakaan. Berfungsi membaca data dari file-file sebelumnya, dan memiliki akses untuk edit data dari file-file sebelumnya.

Class Pegawai.java :
Class ini adalah clas untuk menyimpan data pegawai seperti NIP, nama, tanggal lahir, dan password. Class ini juga memiliki sistem login dan logout melalui class Auth.java

Class Peminjaman.java :
Untuk class Peminjaman, class ini berfungsi untuk mengelola peminjaman buku pada sistem perpustakaan, mencatat data peminjaman buku, data pengembalian buku, juga data transaksi, serta mengecek dan mencatat keterlambatan pemngembalian buku sesuai tanggal maksimal peminjaman.

Class Laporan.java
Class ini digunakan untuk menampilkan laporan tentang data peminjaman buku, menampilkan data buku yang belum dikembalikan, yang terlambat mengembalikan, dan seluruh riwayat peminjaman buku.

Class Main.java :
Class main berfungsi untuk menjalankan seluruh class yang ada, memanggil dan mengirimkan data yang ada di seluruh sistem perpustakaan sesuai dengan fungsi dari tiap-tiap class yang ada.


Alur Program : 
Pilih Pegawai -> Login (Username, password) -> pilih topik -> fungsi (edit data)
