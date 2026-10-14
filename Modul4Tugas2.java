import java.util.Scanner;

public class Modul4Tugas2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //menyimpan data kereta
        String[][] kereta = {
            {"Ekonomi", "50000", "2%", "Tidak Ada", "Tidak Ada"},
            {"Bisnis", "100000", "5%", "Ada", "Tidak Ada"},
            {"Eksekutif", "200000", "7%", "Ada", "Tidak Ada"},
            {"Pariwisata", "300000", "10%", "Ada", "Ada"}
        };

        int[] pesanan = new int[100]; //menyimpan nomor kereta yang dipesan

        int jumlahPesanan = 0; //menghitung jumlah tiket yang dipesan

        //menyimpan pilihan menu
        int pilihan;

        do {
            System.out.println("\n==============================================");
            System.out.println("           PEMESANAN TIKET KERETA");
            System.out.println("==============================================");
            System.out.println("1. Melihat Daftar Kereta Api");
            System.out.println("2. Melihat Kereta Api yang Ada AC");
            System.out.println("3. Melihat Kereta Api yang Ada Colokan");
            System.out.println("4. Memesan Tiket Kereta Api");
            System.out.println("5. Melihat Pesanan Tiket");
            System.out.println("0. Keluar");
            System.out.println("----------------------------------------------");
            System.out.print("Masukkan pilihan: ");
            pilihan = input.nextInt();

            if (pilihan == 1) {
                System.out.println("\nDAFTAR KERETA API");
                System.out.println("==============================================================");

                System.out.printf("%-4s %-15s %10s %-9s %-12s %-12s%n",
                    "No", "Jenis", "Harga", "Diskon", "AC", "Colokan");

                System.out.println("--------------------------------------------------------------");

                //menampilkan data setiap kereta
                for (int i = 0; i < kereta.length; i++) {
                    System.out.printf("%-4d %-15s %10s %-9s %-12s %-12s%n",
                        (i + 1),
                        kereta[i][0],
                        kereta[i][1],
                        kereta[i][2],
                        kereta[i][3],
                        kereta[i][4]
                    );
                }

                System.out.println("==============================================================");

            } else if (pilihan == 2) {
                System.out.println("\nKERETA DENGAN FASILITAS AC");
                System.out.println("==============================================");

                System.out.printf("%-4s %-15s %10s %-9s%n",
                    "No", "Jenis", "Harga", "Diskon");

                System.out.println("----------------------------------------------");

                //memeriksa fasilitas AC pada setiap kereta
                for (int i = 0; i < kereta.length; i++) {
                    if (kereta[i][3].equals("Ada")) {
                        System.out.printf("%-4d %-15s %10s %-9s%n",
                            (i + 1),
                            kereta[i][0],
                            kereta[i][1],
                            kereta[i][2]
                        );
                    }
                }

                System.out.println("==============================================");

            } else if (pilihan == 3) {
                System.out.println("\nKERETA DENGAN FASILITAS COLOKAN");
                System.out.println("==============================================");

                System.out.printf("%-4s %-15s %10s %-9s%n",
                    "No", "Jenis", "Harga", "Diskon");

                System.out.println("----------------------------------------------");

                //memeriksa fasilitas colokan pada setiap kereta
                for (int i = 0; i < kereta.length; i++) {
                    if (kereta[i][4].equals("Ada")) {
                        System.out.printf("%-4d %-15s %10s %-9s%n",
                            (i + 1),
                            kereta[i][0],
                            kereta[i][1],
                            kereta[i][2]
                        );
                    }
                }

                System.out.println("==============================================");

            } else if (pilihan == 4) {

                //memeriksa apakah tempat penyimpanan pesanan masih tersedia
                if (jumlahPesanan < 100) {
                    System.out.println("\nPILIH KERETA");
                    System.out.println("==================================");

                    System.out.printf("%-4s %-15s %12s%n",
                        "No", "Jenis", "Harga");

                    System.out.println("----------------------------------");

                    for (int i = 0; i < kereta.length; i++) {
                        System.out.printf("%-4d %-15s %12s%n",
                            (i + 1),
                            kereta[i][0],
                            kereta[i][1]
                        );
                    }

                    System.out.println("==================================");
                    System.out.print("Masukkan nomor kereta: ");
                    int nomor = input.nextInt();

                    //memeriksa apakah nomor kereta tersedia
                    if (nomor >= 1 && nomor <= kereta.length) {
                        //menyimpan indeks kereta ke dalam array pesanan
                        pesanan[jumlahPesanan] = nomor - 1;
                        jumlahPesanan++;

                        System.out.println("Tiket berhasil dipesan.");
                    } else {
                        System.out.println("Nomor kereta tidak tersedia.");
                    }

                } else {
                    System.out.println("Pesanan sudah penuh.");
                }

            } else if (pilihan == 5) {

                //memeriksa apakah sudah ada pesanan
                if (jumlahPesanan == 0) {
                    System.out.println("Belum ada pesanan tiket.");

                } else {
                    System.out.println("\nDAFTAR PESANAN TIKET");
                    System.out.println("==============================================");

                    System.out.printf("%-4s %-15s %12s %-9s%n",
                        "No", "Jenis", "Harga", "Diskon");

                    System.out.println("----------------------------------------------");

                    //menampilkan setiap tiket yang telah dipesan
                    for (int i = 0; i < jumlahPesanan; i++) {
                        int nomorKereta = pesanan[i];

                        System.out.printf("%-4d %-15s %12s %-9s%n",
                            (i + 1),
                            kereta[nomorKereta][0],
                            kereta[nomorKereta][1],
                            kereta[nomorKereta][2]
                        );
                    }

                    System.out.println("==============================================");
                }

            } else if (pilihan != 0) {
                System.out.println("Pilihan tidak tersedia.");
            }

        } while (pilihan != 0);

        System.out.println("\nProgram selesai. Terima kasih!");

        input.close();
    }
}
