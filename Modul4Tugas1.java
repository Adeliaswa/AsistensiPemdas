
import java.util.Scanner;

public class Modul4Tugas1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] data = new int[100]; //array untuk menyimpan maksimal 100 data
        int jumlahData = 0; //menyimpan jumlah data yg diinputkan
        int pilihan; //menyimpan pilihan menu dri input pengguna

        do {
            System.out.println("\n=== MENU PENGOLAHAN DATA ===");
            System.out.println("1. Input Data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Average");
            System.out.println("4. Sum");
            System.out.println("5. Max");
            System.out.println("6. Min");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilihan = input.nextInt();

            if (pilihan == 1) { //jika pengguna memilih input data
                System.out.print("Masukkan jumlah data: ");
                jumlahData = input.nextInt();

                if (jumlahData < 1 || jumlahData > 100) { //Memeriksa apakah jumlah data sesuai kapasitas array
                    System.out.println("Jumlah data harus 1 sampai 100.");
                    jumlahData = 0;
                } else {
                    for (int i = 0; i < jumlahData; i++) { //Memasukkan data satu per satu ke dalam array
                        System.out.print("Data ke-" + (i + 1) + ": ");
                        data[i] = input.nextInt();

                        if (data[i] == 7) { //Jika data yang dimasukkan adalah 7, program dihentikan
                            pilihan = 7;
                            break;
                        }
                    }

                    if (pilihan != 7) {
                        System.out.println("Data berhasil disimpan.");
                    }
                }

            } else if (pilihan == 2) { //ika pengguna memilih menu Lihat Data
                if (jumlahData == 0) {
                    System.out.println("Belum ada data.");
                } else {
                    System.out.println("Data yang tersimpan:");

                    for (int i = 0; i < jumlahData; i++) {
                        System.out.println(data[i]);
                    }
                }

            } else if (pilihan == 3) { //Jika pengguna memilih menu Average
                if (jumlahData == 0) {
                    System.out.println("Belum ada data.");
                } else {
                    int sum = 0;

                    for (int i = 0; i < jumlahData; i++) { //Menjumlahkan seluruh data di dalam array
                        sum = sum + data[i];
                    }

                    double average = (double) sum / jumlahData; //Menghitung rata-rata dengan membagi jumlah data dengan banyaknya data
                    System.out.println("Average = " + average);
                }

            } else if (pilihan == 4) { //Jika pengguna memilih menu Sum
                if (jumlahData == 0) {
                    System.out.println("Belum ada data.");
                } else {
                    int sum = 0;

                    for (int i = 0; i < jumlahData; i++) { //Menjumlahkan seluruh elemen array
                        sum = sum + data[i];
                    }

                    System.out.println("Sum = " + sum);
                }

            } else if (pilihan == 5) { //Jika pengguna memilih menu Max
                if (jumlahData == 0) {
                    System.out.println("Belum ada data.");
                } else {
                    int max = data[0]; //Menganggap data pertama sebagai nilai terbesar sementara

                    for (int i = 1; i < jumlahData; i++) { //Membandingkan data lainnya dengan nilai terbesar sementara
                        if (data[i] > max) {
                            max = data[i];
                        }
                    }

                    System.out.println("Max = " + max);
                }

            } else if (pilihan == 6) { //Jika pengguna memilih menu Min
                if (jumlahData == 0) {
                    System.out.println("Belum ada data.");
                } else {
                    int min = data[0];

                    for (int i = 1; i < jumlahData; i++) {
                        if (data[i] < min) {
                            min = data[i];
                        }
                    }

                    System.out.println("Min = " + min);
                }

            } else if (pilihan != 0 && pilihan != 7) { //Mengulang menu selama pilihan bukan 0 atau 7
                System.out.println("Pilihan tidak tersedia.");
            }

        } while (pilihan != 0 && pilihan != 7);

        System.out.println("Program selesai.");
        input.close();
    }
}
