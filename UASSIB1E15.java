import java.util.Scanner;

public class UASSIB1E15 {

    static String[][] tabelSkor15 = new String[100][4];
    static int jumlahData15 = 0; 
    static Scanner input15= new Scanner(System.in);

    public static void main(String[] args) {
        boolean lanjut15 = true; 
        while (lanjut15) {
            System.out.println("\n===== MENU UTAMA =====");
            System.out.println("1. Input Data Skor TIm ");
            System.out.println("2. Tampilkan Tabel Skor ");
            System.out.println("3. Tentukan Juara ");
            System.out.println("4. Keluar ");
            System.out.print("Pilih Menu (1-4): ");
            int menu15 = input15.nextInt();
            input15.nextLine();

            switch (menu15) {
                case 1:
                    inputData15();
                    break;
                case 2:
                    tampilkanTabelSkor15();
                    break;
                case 3:
                    tentukanJuara15();
                    break;
                case 4:
                    System.out.println("Terima Kasih! ");
                    lanjut15 = false;
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid, Silahkan Mencoba Kembali!");
                    break;
            }
        }
    }

    public static void inputData15() {
        System.out.print("Masukkan jumlah tim: ");
        int jumlahTim15 = input15.nextInt();
        input15.nextLine(); 

        for (int i15 = 0; i15 < jumlahTim15; i15++) {
            System.out.println("\nMasukkan Data TIm Ke-" + (i15 + 1));
            System.out.print("Nama Tim: ");
            String namaTim15 = input15.nextLine();

            int skorLevel115 = inputSkor15("Level 1");
            int skorLevel215 = inputSkor15("Level 2");

            tabelSkor15[jumlahData15][0] = namaTim15;
            tabelSkor15[jumlahData15][1] = String.valueOf(skorLevel115);
            tabelSkor15[jumlahData15][2] = String.valueOf(skorLevel215);
            tabelSkor15[jumlahData15][3] = String.valueOf(skorLevel115 + skorLevel215);

            jumlahData15++;
        }
    }

    public static int inputSkor15(String level15) {
        int skor15;
        while (true) {
            System.out.print("Masukkan skor untuk " + level15 + ": ");
            skor15 = input15.nextInt();
            input15.nextLine(); 
            if (skor15 >= 0) {
                break;
            } else {
                System.out.println("Skor tidak boleh negatif. Coba lagi.");
            }
        }
        return skor15;
    }

    public static void tampilkanTabelSkor15() {
        if (jumlahData15 == 0) {
            System.out.println("Data belum diinput. Silahkan Menginputkan Data terlenbih dahalu.");
            return;
        }

        System.out.println("\n=== TABEL SKOR TURNAMEN ===");
        System.out.printf("%-15s %-10s %-10s %-10s\n", "Nama Tim", "Level 1", "Level 2", "Total Skor");
        for (int i15 = 0; i15 < jumlahData15; i15++) {
            System.out.printf("%-15s %-10s %-10s %-10s\n", tabelSkor15[i15][0], tabelSkor15[i15][1], tabelSkor15[i15][2], tabelSkor15[i15][3]);
        }
    }

    public static void tentukanJuara15() {
        if (jumlahData15 == 0) {
            System.out.println("Data belum diinput. Silahkan Menginputkan Data terlenbih dahalu.");
            return;
        }

        int skorTertinggi15 = Integer.parseInt(tabelSkor15[0][3]);
        String juara15 = tabelSkor15[0][0];

        for (int i15 = 1; i15 < jumlahData15; i15++) {
            int totalSkor15 = Integer.parseInt(tabelSkor15[i15][3]);
            if (totalSkor15 > skorTertinggi15) {
                skorTertinggi15 = totalSkor15;
                juara15 = tabelSkor15[i15][0];
            }
        }

        System.out.println("\nSelamat kepada tim " + juara15 + " yang telah memenangkan kompetisi dengan skor " + skorTertinggi15 + "!");
    }
}