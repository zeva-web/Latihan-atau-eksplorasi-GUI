# 3C - Latihan/Eksplorasi Materi Graphical User Interface pada Java

**Identitas Mahasiswa:**
* **NIM:** F1D02510079
* **Nama:** Muhamad Zeva syam
* **Kelas:** 3C

---

## Deskripsi Singkat Program
Program ini adalah **Aplikasi Konversi Suhu** berbasis *Graphical User Interface* (GUI) yang dibangun menggunakan pustaka `javax.swing` dan `java.awt`. Pengguna dapat memasukkan nilai suhu, memilih jenis satuan konversi (Celcius, Fahrenheit, dan Kelvin), menghitung hasil konversi secara instan, serta mereset form kembali ke keadaan awal.

---

## Informasi 5 Komponen Utama GUI yang Digunakan

### 1. Top-level Container Class
* **Class:** `JFrame` (`javax.swing.JFrame`)
* **Penjelasan:** Kelas utama `KonversiSuhuGUI` mewarisi (`extends`) `JFrame` sebagai jendela dasar aplikasi yang menampung seluruh panel dan komponen GUI lainnya, mengatur judul jendela (`setTitle`), ukuran (`setSize`), posisi tengah layar (`setLocationRelativeTo`), serta aksi penutupan program (`EXIT_ON_CLOSE`).

### 2. Intermediate Container Class
* **Class:** `JPanel` (`javax.swing.JPanel`)
* **Penjelasan:** Digunakan tiga buah `JPanel` sebagai wadah perantara di dalam `JFrame` untuk memisahkan bagian antarmuka secara terstruktur:
  * `panelHeader`: Menampung judul aplikasi di bagian atas.
  * `panelForm`: Menampung label, kolom input, dropdown pilihan, dan label hasil di bagian tengah.
  * `panelTombol`: Menampung tombol **Hitung Konversi** dan **Reset** di bagian bawah.

### 3. Atomic Component Class
* **Class:** `JLabel`, `JTextField`, `JComboBox`, dan `JButton`
* **Penjelasan:**
  * `JLabel`: Menampilkan judul program, keterangan input, serta hasil perhitungan konversi.
  * `JTextField`: Menerima masukan angka suhu dari pengguna.
  * `JComboBox`: Menyediakan pilihan jenis konversi suhu dalam bentuk *dropdown*.
  * `JButton`: Menyediakan tombol interaktif untuk mengeksekusi perhitungan (**Hitung Konversi**) dan membersihkan input (**Reset**).

### 4. Layout Classes (3 Layout Classes)
* **Class:** `BorderLayout`, `GridLayout`, dan `FlowLayout` (`java.awt.*`)
* **Penjelasan:**
  * `BorderLayout`: Mengatur tata letak utama pada `JFrame` dengan menempatkan `panelHeader` di posisi `NORTH`, `panelForm` di posisi `CENTER`, dan `panelTombol` di posisi `SOUTH`.
  * `GridLayout`: Menyusun komponen di dalam `panelForm` menjadi matriks rapi berukuran 3 baris dan 2 kolom.
  * `FlowLayout`: Mengatur posisi komponen di dalam `panelHeader` dan `panelTombol` agar sejajar secara horizontal di tengah.

### 5. Event Listener (Event Method Override & Event Adapter)
* **Interface & Adapter Class:** `ActionListener` dan `MouseAdapter` (`java.awt.event.*`)
* **Penjelasan:**
  * `ActionListener`: Diimplementasikan oleh kelas utama dengan meng-*override* method `actionPerformed(ActionEvent e)` untuk memproses rumus konversi saat tombol **Hitung Konversi** diklik (disertai validasi `NumberFormatException` menggunakan `JOptionPane`), serta membersihkan form saat tombol **Reset** diklik.
  * `MouseAdapter`: Menggunakan *event adapter class* dengan meng-*override* method `mouseEntered(MouseEvent e)` dan `mouseExited(MouseEvent e)` untuk memberikan efek perubahan warna latar saat kursor diarahkan ke tombol **Hitung Konversi**.

---

## Screenshot Hasil Program

![Screenshot Aplikasi Konversi Suhu](screenshot.png)
