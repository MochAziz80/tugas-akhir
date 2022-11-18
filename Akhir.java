// Import Config

import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Akhir {        // Nama Class
    static void kembali() {         // Function untuk melakukan looping ( true / false )
        Scanner input = new Scanner(System.in);
        System.out.println("=======================================");
        System.out.println("\tIngin Menggulang Kembali ?\nKetik True Jika Iya Dan False Jika Tidak");
        boolean ulang = input.nextBoolean();
        if (ulang == true) {
            homeMethod();
        } else {
            System.out.println("Program End");
        }
    }

    static void homeMethod() {          // Function utama yang mencakup input kode, array, hasil dan bagian end
        Scanner input = new Scanner(System.in);
        System.out.println("MASUKKAN NOMOR RESI BARANG ANDA");
        String pilihan = input.nextLine();
        String[] resi = {"0011", "0022", "0033", "0044"};
        String[] barang = {"Sabun Cuci", "Kapas", "Panci", "Baju", "Pensil"};
        String[] barang2 = {"Pulpen", "Mouse", "Baterai", "Galon", "Kabel", "Stop Kontak"};
        String[] estimasi = {"1 Hari Lagi", "3 Hari Lagi", "6 Hari Lagi", "12 Hari Lagi"};
        String[][] kelompok = {resi, barang, barang2, estimasi};    // array 2d
        int b = 0;      // b bernilai 0 sama dengan false

        for (int i = 0; i < 4; i++) {       // Looping Array 1

            for (int j = 0; j < 4; j++) {       // Looping Array 2
                if (pilihan.equalsIgnoreCase(kelompok[i][j])) {     // Percabangan Kode resi yang di inputkan
                    System.out.println("============= R E S U L T =============");
                    System.out.println("NOMER RESI\t\t: " + kelompok[0][j] + "\nDAFTAR BARANG\t\t: - " + kelompok[1][j] + "\n\t\t\t  - " + kelompok[2][j] + "\nESTIMASI DATANG DALAM\t: " + kelompok[3][j]);        // Isi dari array yang di temukan
                    waktu();        // Call function waktu
                    b = 1;  // b bernilai 1 = true
                    kembali();  // Call function looping bool
                }

            }

        }

        if (b == 0) {       // Jika var B = 0 ( FALSE ) maka akan memunculkan pesan
            System.out.println("!==================================================================!");
            System.out.println("Data Yang Anda Masukkan Tidak Ada Di Dalam Database\nMohon Memasukkan Data Yang Benar !!");
            System.out.println("====================================================================");
            homeMethod();       // Looping jika data salah
        }

    }
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");       // Format Tanggal

    static void waktu() {       // Function untuk menampilkan waktu
        Date currentDate = new Date();
        System.out.println("");
        System.out.println("Date = " + dateFormat.format(currentDate));

        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);

        c.add(Calendar.YEAR, 1);
        c.add(Calendar.MONTH, 1);
        c.add(Calendar.DATE, 1);
        c.add(Calendar.HOUR, 1);
        c.add(Calendar.MINUTE, 1);
        c.add(Calendar.SECOND, 1);
    }

    public static void main(String[] args) {
        homeMethod();       // Memanggil method utama

    }
}
