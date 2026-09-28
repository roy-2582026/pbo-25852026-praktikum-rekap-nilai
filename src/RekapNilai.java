import java.util.Scanner;

public class RekapNilai {

    // Ketentuan 1: Sentinel disimpan sebagai konstanta static final int SELESAI = -1
    public static final int SELESAI = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double total = 0; // Ketentuan 5: Akumulator double total
        int jumlahNilaiSah = 0; // Pencacah nilai yang valid
        int nomorInput = 1; // Menandai nomor urut input nilai (misal: Nilai ke-1)

        System.out.println("===== REKAP NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.");

        /*
         * Komentar Ketentuan 1:
         * do-while lebih pas digunakan daripada while biasa karena program harus
         * melakukan pembacaan input nilai minimal satu kali terlebih dahulu
         * sebelum mengecek apakah nilai tersebut adalah sentinel (-1) untuk menghentikan loop.
         */
        int nilai = 0; // Inisialisasi awal nilai = 0 untuk menghindari error uninitialized variable
        do {
            System.out.print("Nilai ke-" + nomorInput + " : ");

            // Membaca nilai dari input pengguna
            if (scanner.hasNextInt()) {
                nilai = scanner.nextInt();
            } else {
                scanner.next(); // Abaikan input jika bukan angka
                continue;
            }

            // Cek jika sentinel diketik untuk menghentikan program
            if (nilai == SELESAI) {
                break;
            }

            // Ketentuan 2: Validasi nilai di luar 0-100 ditolak dengan continue,
            // dan pencacahnya tidak boleh ikut naik (nomorInput tetap sama)
            if (nilai < 0 || nilai > 100) {
                System.out.println("ditolak - nilai harus 0..100");
                continue; // Melompat ke iterasi berikutnya tanpa menaikkan nomorInput & jumlahNilaiSah
            }

            // Ketentuan 3: Menentukan grade menggunakan ladder if / else if
            char grade;
            if (nilai >= 90) {
                grade = 'A';
            } else if (nilai >= 80) {
                grade = 'B';
            } else if (nilai >= 70) {
                grade = 'C';
            } else if (nilai >= 60) {
                grade = 'D';
            } else {
                grade = 'E';
            }

            /*
             * Catatan Eksperimen Ketentuan 3 (jika urutan dibalik `nilai >= 60` paling atas):
             * Jika `nilai >= 60` ditaruh paling atas, maka nilai seperti 85 akan langsung masuk
             * ke kondisi `>= 60` dan mendapatkan grade 'D', padahal seharusnya mendapatkan grade 'B'.
             * Oleh karena itu, pengecekan harus dimulai dari nilai yang paling tinggi.
             */

            // Ketentuan 4: Keterangan grade menggunakan switch expression / lambda (Java 14+)
            String keterangan = switch (grade) {
                case 'A' -> "Sangat Baik";
                case 'B' -> "Baik";
                case 'C' -> "Cukup";
                case 'D' -> "Kurang";
                default -> "Tidak Lulus";
            };

            // Menampilkan hasil per nilai
            System.out.println("Grade " + grade + " - " + keterangan);

            // Ketentuan 5: Tambahkan nilai ke total akumulator memakai augmented assignment (+=)
            total += nilai;

            jumlahNilaiSah++;
            nomorInput++;

        } while (nilai != SELESAI);

        System.out.println();

        // Ketentuan 7: Jaga kasus tidak ada nilai sah sama sekali (misal langsung ketik -1)
        if (jumlahNilaiSah == 0) {
            System.out.println("Nilai sah   : 0");
            System.out.println("Rata-rata   : 0,00");
            System.out.println("Status      : TIDAK LULUS");
        } else {
            double rataRata = total / jumlahNilaiSah;

            // Ketentuan 6: Status kelas ditentukan dengan ternary operator
            String status = (rataRata >= 60) ? "LULUS" : "TIDAK LULUS";

            System.out.println("Nilai sah   : " + jumlahNilaiSah);
            // Ketentuan 5: Tampilkan dua angka di belakang koma dengan String.format("%.2f", rata)
            System.out.println("Rata-rata   : " + String.format("%.2f", rataRata));
            System.out.println("Status      : " + status);
        }

        scanner.close();
    }
}