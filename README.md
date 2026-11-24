# Character Manager

Buka folder `C:\CharacterManager3` sebagai workspace VS Code agar `src` dikenali sebagai source root dan package `com.unpri.charactermanager` dapat di-resolve.

## TP10 — Theming, Properti Komponen & Analisis MVC

Tema warna, font, dan border antarmuka didefinisikan di `AppTheme` pada package `view`. Model `Character` menyimpan data karakter, bukan aturan bagaimana data itu ditampilkan. Dengan demikian, perubahan tema tidak mengubah logika model dan tampilan lain dapat menyajikan karakter yang sama dengan gaya berbeda. Pemetaan role ke warna juga terpusat sehingga konsisten dan mudah dirawat.

### Properti tambahan

- **Tooltip detail HP/ATK/Mana:** detail statistik tersedia saat kartu diarahkan mouse tanpa membuat daftar terlihat sesak.
- **Border kartu mengikuti role:** garis tepi menggunakan warna role agar kategorinya tetap mudah dikenali dan konsisten dengan warna latar kartu.

### Screenshot

Tambahkan hasil tangkapan layar aplikasi v0.3 dan v0.4 di `docs/screenshots/`, lalu sesuaikan nama berkas di bawah. Pastikan gambar v0.3 benar-benar diambil dari versi sebelum perubahan tema, dan gambar v0.4 dari aplikasi yang sudah berjalan.

| Sebelum — v0.3 | Sesudah — v0.4 |
|---|---|
| ![Character Manager v0.3](docs/screenshots/character-manager-v03.png) | ![Character Manager v0.4](docs/screenshots/character-manager-v04.png) |

### Analisis Bagian D

Tulis analisis minimal 500 kata dengan kata-kata sendiri di Google Docs. Bahas JavaBeans getter/setter, `setBackground` dan `setOpaque`, `setSize`/`setPreferredSize`/`pack`, alasan menghindari null layout dan `setBounds`, pemisahan Model-View, serta logical fonts dan `deriveFont`. Sebelum submit, ganti placeholder ini dengan tautan Google Docs Anda: **[Tautan Google Docs TP10 — tambahkan di sini]**.

### AP13 — Dokumentasi Pembaruan GUI & Manajemen Tema

## 1. Rasionalisasi Pemisahan Data Warna (AppTheme vs Character)
Penyimpanan data warna dikelola secara terpusat di dalam kelas `AppTheme` (atau `AppThema`) dan bukan di dalam kelas `Character` demi menjaga prinsip *Separation of Concerns* (Pemisahan Tanggung Jawab) pada arsitektur MVC. Kelas `Character` murni bertindak sebagai *Model* yang hanya bertanggung jawab atas logika data dan status internal karakter seperti nama, level, atau poin kesehatan. Jika warna dimasukkan ke dalam kelas `Character`, hal tersebut akan merusak enkapsulasi karena memaksa komponen *Model* untuk memahami elemen visual grafis yang merupakan ranah penuh dari komponen *View*. Dengan pendekatan ini, perubahan tema visual seluruh aplikasi di masa mendatang dapat dilakukan dengan cepat hanya melalui satu file konfigurasi saja tanpa berisiko merusak logika bisnis inti.

## 2. Daftar Properti Tambahan Visual dan Alasan Pemilihan
Untuk meningkatkan kualitas antarmuka dan pengalaman pengguna (UX), berikut adalah dua properti tambahan yang disematkan ke dalam kartu komponen GUI:

* **Restriksi Akses Karakter Pemula (`setEnabled(false)`)**
  * *Alasan:* Properti ini dipilih untuk memberikan indikasi visual yang kuat terhadap status kesiapan karakter. Karakter berlevel 1 dianggap sebagai entitas pemula (*trainee*) yang belum memiliki kapabilitas bertarung, sehingga komponen visualnya sengaja dinonaktifkan untuk menyimulasikan pembatasan akses interaksi dalam sistem permainan.
* **Mekanisme Informasi Melayang (`Dynamic HTML Tooltip`)**
  * *Alasan:* Properti ini diimplementasikan untuk mempertahankan estetika jendela aplikasi agar tetap bersih, minimalis, dan ringkas. Rincian status sekunder yang padat seperti daya tahan (`hitPoints`) dan daya serang (`attackPower`) dipindahkan ke dalam *hover tooltip* berformat HTML sehingga pengguna tetap dapat meninjau statistik mendalam tanpa membuat tata letak utama menjadi penuh sesak.

  ## srenshot output
  ![bukti Screnshot AP 13 ](<Screenshot (4).png>)