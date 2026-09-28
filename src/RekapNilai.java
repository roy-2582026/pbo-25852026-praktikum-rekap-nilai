import java.util.Scanner;

public class RekapNilai {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int nilai;
        char grade;

        System.out.println("=== REKAP NILAI ===");
        System.out.print("Masukkan nilai: ");
        nilai = input.nextInt();

        // Menentukan grade
        if (nilai >= 80) {
            grade = 'A';
        } else if (nilai >= 70) {
            grade = 'B';
        } else if (nilai >= 60) {
            grade = 'C';
        } else if (nilai >= 50) {
            grade = 'D';
        } else {
            grade = 'E';
        }

        // Menampilkan hasil
        System.out.println();
        System.out.println("===== HASIL =====");
        System.out.println("Nilai : " + nilai);
        System.out.println("Grade : " + grade);

        if (grade == 'A') {
            System.out.println("Keterangan : Sangat Baik");
        } else if (grade == 'B') {
            System.out.println("Keterangan : Baik");
        } else if (grade == 'C') {
            System.out.println("Keterangan : Cukup");
        } else if (grade == 'D') {
            System.out.println("Keterangan : Kurang");
        } else {
            System.out.println("Keterangan : Tidak Lulus");
        }

        input.close();
    }
}