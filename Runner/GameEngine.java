import java.util.InputMismatchException;
import java.util.Scanner;
import Exception.*;
import Map.*;
import Plants.*;
import Player.*;


public class GameEngine {

    private static Scanner sc = new Scanner(System.in); 
    public static void main(String[] args) {
        String red = "\033[31m";   // Kode warna merah
        String green = "\033[32m"; // Kode warna hijau
        String yellow = "\u001B[33m"; // Kode warna kuning
        String bold = "\033[1m"; // Kode bold
        String reset = "\033[0m";  // Reset warna
        

        // Print Michael vs Lalapan
        System.out.println(green + "            ███╗   ███╗██╗ ██████╗██╗  ██╗ █████╗ ███████╗██╗         " + reset);
        System.out.println(green + "            ████╗ ████║██║██╔════╝██║  ██║██╔══██╗██╔════╝██║         " + reset);
        System.out.println(green + "            ██╔████╔██║██║██║     ███████║███████║█████╗  ██║         " + reset);
        System.out.println(green + "            ██║╚██╔╝██║██║██║     ██╔══██║██╔══██║██╔══╝  ██║         " + reset);
        System.out.println(green + "            ██║ ╚═╝ ██║██║╚██████╗██║  ██║██║  ██║███████╗███████╗    " + reset);
        System.out.println(green + "            ╚═╝     ╚═╝╚═╝ ╚═════╝╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝╚══════╝    " + reset);
        System.out.println(red + "                              ██╗   ██╗███████╗                         " + reset);
        System.out.println(red + "                              ██║   ██║██╔════╝                         " + reset);
        System.out.println(red + "                              ██║   ██║███████╗                         " + reset);
        System.out.println(red + "                              ╚██╗ ██╔╝╚════██║                         " + reset);
        System.out.println(red + "                               ╚████╔╝ ███████║                         " + reset);
        System.out.println(red + "                                ╚═══╝  ╚══════╝                         " + reset);
        System.out.println(green + "          ██╗      █████╗ ██╗      █████╗ ██████╗  █████╗ ███╗   ██╗    " + reset);
        System.out.println(green + "          ██║     ██╔══██╗██║     ██╔══██╗██╔══██╗██╔══██╗████╗  ██║    " + reset);
        System.out.println(green + "          ██║     ███████║██║     ███████║██████╔╝███████║██╔██╗ ██║    " + reset);
        System.out.println(green + "          ██║     ██╔══██║██║     ██╔══██║██╔═══╝ ██╔══██║██║╚██╗██║    " + reset);
        System.out.println(green + "          ███████╗██║  ██║███████╗██║  ██║██║     ██║  ██║██║ ╚████║    " + reset);
        System.out.println(green + "          ╚══════╝╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝╚═╝     ╚═╝  ╚═╝╚═╝  ╚═══╝    " + reset);
    
 
        System.out.println("                                                                     ");
        System.out.println(" ▄  ▄  ▄  ▄  ▄  ▄  ▄  ▄  ▄  ▄  ▄  ▄  ▄  ▄  ▄  ▄  ▄  ▄  ▄  ▄  ▄  ▄  ▄  ▄  ▄  ▄");
        System.out.println("▐░▌▐░▌▐░▌▐░▌▐░▌▐░▌▐░▌▐░▌▐░▌▐░▌▐░▌▐░▌▐░▌▐░▌▐░▌▐░▌▐░▌▐░▌▐░▌▐░▌▐░▌▐░▌▐░▌▐░▌▐░▌▐░▌");
        System.out.println(" ▀  ▀  ▀  ▀  ▀  ▀  ▀  ▀  ▀  ▀  ▀  ▀  ▀  ▀  ▀  ▀  ▀  ▀  ▀  ▀  ▀  ▀  ▀  ▀  ▀  ▀ ");
        System.out.println("                                                                     ");

        // Scanner sc = new Scanner(System.in); 
        boolean exitGame = false;

        while (!exitGame) {
            System.out.println(red + bold + "\r\n" + //
            "██████████████████████████████████████████████████████████████████████████████  \r\n" + reset);
            System.out.println(red + "███    ███ ███████ ███    ██ ██    ██      ██████   █████  ███    ███ ███████ " + reset);
            System.out.println(red + "████  ████ ██      ████   ██ ██    ██     ██       ██   ██ ████  ████ ██      " + reset);
            System.out.println(red + "██ ████ ██ █████   ██ ██  ██ ██    ██     ██   ███ ███████ ██ ████ ██ █████   " + reset);
            System.out.println(red + "██  ██  ██ ██      ██  ██ ██ ██    ██     ██    ██ ██   ██ ██  ██  ██ ██      " + reset);
            System.out.println(red + "██      ██ ███████ ██   ████  ██████       ██████  ██   ██ ██      ██ ███████ " + reset);
            System.out.println(" ");
            System.out.println(yellow + bold + " 1. START" + reset);
            System.out.println(yellow + bold +" 2. HELP" + reset);
            System.out.println(yellow + bold +" 3. PLANTS LIST" + reset);
            System.out.println(yellow + bold +" 4. ZOMBIES LIST" + reset);
            System.out.println(yellow + bold +" 5. EXIT" + reset);
            System.out.println(red + bold + "\r\n" + //
            "██████████████████████████████████████████████████████████████████████████████ " + reset);
            System.out.println(green + bold + "MASUKKAN NOMOR MENU YANG DIPILIH: " + reset);
            boolean validInput = false;
            while (!validInput) {
                try {
                    int choice = sc.nextInt();
                    sc.nextLine();

                    switch (choice) {
                        case 1:
                            startGame();
                            validInput = true;
                            break;
                        case 2:
                            displayHelp();
                            validInput = true;
                            break;
                        case 3:
                            displayPlantsList();
                            validInput = true;
                            break;
                        case 4:
                            displayZombiesList();
                            validInput = true;
                            break;
                        case 5:
                            System.out.println("\n================================");
                            System.out.println("   Terima Kasih Telah Bermain!   ");
                            System.out.println("================================");
                            exitGame = true;
                            validInput = true;
                            break;
                        default:
                            System.out.println(red + bold + "PILIHAN TIDAK VALID. MASUKKAN PILIHAN YANG VALID." + reset);
                            break;
                    }
                }   catch (InputMismatchException e) {
                        System.out.println(green + bold + "INPUT TIDAK VALID. MASUKKAN INTEGER!"+ reset);
                        sc.nextLine();
                        
            }
        }
    }
}

    private static void displayHelp() {
        String green = "\033[32m"; // Kode warna hijau
        String yellow = "\u001B[33m"; // Kode warna kuning
        String red = "\033[31m";   // Kode warna merah
        String bold = "\033[1m"; // Kode bold
        String reset = "\033[0m";  // Reset warna
        // Scanner sc = new Scanner(System.in); 
        System.out.println(red + bold + "\r\n" + //
        "██████████████████████████████████████████████████████████████████████████████  \r\n" + reset);
        System.out.println(red + bold +
                "██   ██ ███████ ██      ██████  \n" +
                "██   ██ ██      ██      ██   ██ \n" +
                "███████ █████   ██      ██████  \n" +
                "██   ██ ██      ██      ██      \n" +
                "██   ██ ███████ ███████ ██      " + reset);
        System.out.println(" ");
        System.out.println(yellow + bold + 
        "╔═════════════════════════════════════════════════════════════════════════════╗\n" +
        "║                             DESKRIPSI PERMAINAN                             ║\n" +
        "╠═════════════════════════════════════════════════════════════════════════════╣\n" +
        "║ Roro Jonggrang diserang oleh pasukan jin yang menjadi zombie.               ║\n" +
        "║ Bandung Bondowoso ingin menyelamatkan istri tercintanya.                    ║\n" +
        "║ Ia memiliki beberapa benih tanaman yang memiliki kemampuan khusus.          ║\n" +
        "║ Bantu Bandung Bondowoso untuk menyelamatkan Roro Jonggrang dari zombie      ║\n" +
        "║ dengan menggunakan tanaman!                                                 ║\n" +
        "╚═════════════════════════════════════════════════════════════════════════════╝" + reset);
        System.out.println(yellow + bold + 
        "╔═════════════════════════════════════════════════════════════════════════════╗\n" +
        "║                                CARA BERMAIN                                 ║\n" +
        "╠═════════════════════════════════════════════════════════════════════════════╣\n" +
        "║ 1. Pemain dapat memilih menu apa yang diinginkan pada bagian MENU GAME      ║\n" +
        "║ 2. Jika ingin memulai permainan, pemain dapat memilih START                 ║\n" +
        "║ 3. Jika ingin melihat tanaman yang ada, pemain dapat memilih PLANTS LIST    ║\n" +
        "║ 4. Jika ingin melihat zombie yang ada, pemain dapat memilih ZOMBIES LIST    ║\n" +
        "║ 5. Jika ingin keluar dari permainan, pemain dapat memilih EXIT              ║\n" +
        "╠═════════════════════════════════════════════════════════════════════════════╣\n" +
        "║ Saat memilih START, pemain akan dapat melihat tanaman yang terdapat di      ║\n" +
        "║ INVENTORY. Kemudian, pemain dapat memilih enam tanaman untuk dimasukkan ke  ║\n" +
        "║ dalam DECK. Setelahnya, pemain dapat mengubah atau menghapus isi dari DECK. ║\n" +
        "║ Permainan akan dimulai setelah DECK terisi. Pemain dapat melakukan tanam    ║\n" +
        "║ tanaman yang ada untuk melawan zombie. Permainan akan selesai dengan        ║\n" +
        "║ kemenangan tanaman jika seluruh zombie mati atau dengan kemenangan zombie   ║\n" +
        "║ jika terdapat satu zombie yang sampai pada area yang dilindungi.            ║\n" +
        "╚═════════════════════════════════════════════════════════════════════════════╝" + reset);
        System.out.println(yellow + bold + 
        "╔═════════════════════════════════════════════════════════════════════════════╗\n" +
        "║                               LIST COMMAND                                  ║\n" +
        "╠═════════════════════════════════════════════════════════════════════════════╣\n" +
        "║ 1. T = Saat pemain melakukan input ini, terdapat pilihan indeks tanaman     ║\n" +
        "║    yang ingin ditanam dan koordinat di mana tanaman ingin ditanam.          ║\n" +
        "║ 2. G = Saat pemain melakukan input ini, pemain diminta untuk melakukan      ║\n" +
        "║    input koordinat tanaman yang ingin digali.                               ║\n" +
        "║                                                                             ║\n" +
        "║ Selebihnya, GO WITH THE FLOW!                                               ║\n" +
        "╚═════════════════════════════════════════════════════════════════════════════╝" + reset);
        boolean validInput = false;
        while (!validInput) {
            System.out.println(green + bold + "APAKAH SUDAH SELESAI MEMBACA? (Y/N)" + reset);
            String choice = sc.nextLine().trim().toUpperCase();
            if (choice.equals("Y")) {
                // Return to game menu
                System.out.println(green + bold + "KEMBALI KE MENU GAME..." + reset);
                validInput = true;
            } else if (choice.equals("N")) {
                System.out.println(red + bold + "SILAKAN BACA KEMBALI!" + reset);
                displayHelp();
                validInput = true;
            } else {
                System.out.println(red + bold + "INPUT TIDAK VALID. MASUKKAN Y/N!" + reset);
            }
        }
    }

    private static void displayPlantsList() {
        String green = "\033[32m"; // Kode warna hijau
        String yellow = "\u001B[33m"; // Kode warna kuning
        String red = "\033[31m";   // Kode warna merah
        String bold = "\033[1m"; // Kode bold
        String reset = "\033[0m";  // Reset warna
        //Scanner sc = new Scanner(System.in); 
        boolean continueLoop = true;
        while(continueLoop) {
            // Print Nama Tanaman
            System.out.println(red + bold + "\r\n" + //
            "██████████████████████████████████████████████████████████████████████████████  \r\n" + reset);
            System.out.println(red + "██      ██ ███████ ████████     ████████  █████  ███    ██  █████  ███    ███  █████  ███    ██" + reset);
            System.out.println(red + "██      ██ ██         ██           ██    ██   ██ ████   ██ ██   ██ ████  ████ ██   ██ ████   ██" + reset);
            System.out.println(red + "██      ██ ███████    ██           ██    ███████ ██ ██  ██ ███████ ██ ████ ██ ███████ ██ ██  ██" + reset);
            System.out.println(red + "██      ██      ██    ██           ██    ██   ██ ██  ██ ██ ██   ██ ██  ██  ██ ██   ██ ██  ██ ██" + reset);
            System.out.println(red + "███████ ██ ███████    ██           ██    ██   ██ ██   ████ ██   ██ ██      ██ ██   ██ ██   ████" + reset);
            System.out.println(" ");
            System.out.println(yellow + bold + "1. PEASHOOTER");
            System.out.println("2. POTATO MINE");
            System.out.println("3. SUNFLOWER");
            System.out.println("4. REPEATER");
            System.out.println("5. SQUASH");
            System.out.println("6. SNOW PEA");
            System.out.println("7. TALL-NUT");
            System.out.println("8. JALAPENO");
            System.out.println("9. LILYPAD");
            System.out.println("10. WALL-NUT" + reset);
            System.out.println(red + bold + "\r\n" + //
            "██████████████████████████████████████████████████████████████████████████████  \r\n" + reset);
            System.out.println(green + bold + "MASUKKAN NOMOR TANAMAN: " + reset);
            // Print deskripsi tiap tanaman 
            boolean validInput = false;
            while (!validInput) {
                try {
                    int choice = sc.nextInt();
                    sc.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.println(
                                yellow + bold + "Name: PEASHOOTER\n" +
                                "Health: 100\n" +
                                "Attack Damage: 25\n" +
                                "Attack Speed: 4\n" + 
                                "Range: -1\n" + 
                                "Cooldown: 10" + reset);
                            validInput = true;
                            break;
                        case 2:
                            System.out.println(
                                yellow + bold + "Name: POTATO MINE\n" +
                                "Cost: 25\n" +
                                "Health: 100\n" +
                                "Attack Damage: 5000\n" +
                                "Attack Speed: 0\n" + 
                                "Range: 1\n" + 
                                "Cooldown: 20" + reset);
                            validInput = true;
                            break;
                        case 3:
                            System.out.println(
                                yellow + bold + "Name: SUNFLOWER\n" +
                                "Cost: 50\n" +
                                "Health: 100\n" +
                                "Attack Damage: 0\n" +
                                "Attack Speed: 0\n" + 
                                "Range: 0\n" + 
                                "Cooldown: 10" + reset);
                            validInput = true;
                            break;
                        case 4:
                            System.out.println(
                                yellow + bold + "Name: SUNFLOWER\n" +
                                "Cost: 50\n" +
                                "Health: 100\n" +
                                "Attack Damage: 0\n" +
                                "Attack Speed: 0\n" + 
                                "Range: 0\n" + 
                                "Cooldown: 10" + reset);
                            validInput = true;
                            break;
                        case 5:
                            System.out.println(
                                yellow + bold + "Name: SQUASH\n" +
                                "Cost: 50\n" +
                                "Health: 100\n" +
                                "Attack Damage: 5000\n" +
                                "Attack Speed: 0\n" + 
                                "Range: 1\n" + 
                                "Cooldown: 20" + reset);
                            validInput = true;
                            break;
                        case 6:
                            System.out.println(
                                yellow + bold + "Name: SNOW PEA\n" +
                                "Cost: 175\n" +
                                "Health: 100\n" +
                                "Attack Damage: 25\n" +
                                "Attack Speed: 4\n" + 
                                "Range: -1\n" + 
                                "Cooldown: 10" + reset);
                            validInput = true;
                            break;
                        case 7:
                            System.out.println(
                                yellow + bold + "Name: TALL NUT\n" +
                                "Cost: 125\n" +
                                "Health: 2000\n" +
                                "Attack Damage: 0\n" +
                                "Attack Speed: 0\n" + 
                                "Range: 0\n" + 
                                "Cooldown: 25" + reset);
                            validInput = true;
                            break;
                        case 8:
                            System.out.println(
                                yellow + bold + "Name: JALAPENO\n" +
                                "Cost: 125\n" +
                                "Health: 100\n" +
                                "Attack Damage: 5000\n" +
                                "Attack Speed: 0\n" + 
                                "Range: -1\n" + 
                                "Cooldown: 25" + reset);
                            validInput = true;
                            break;
                        case 9:
                            System.out.println(
                                yellow + bold + "Name: LILYPAD\n" +
                                "Cost: 25\n" +
                                "Health: 100\n" +
                                "Attack Damage: 0\n" +
                                "Attack Speed: 0\n" + 
                                "Range: 0\n" + 
                                "Cooldown: 10" + reset);
                            validInput = true;
                            break;
                        case 10:
                            System.out.println(
                                yellow + bold + "Name: WALL-NUT\n" +
                                "Cost: 50\n" +
                                "Health: 1000\n" +
                                "Attack Damage: 0\n" +
                                "Attack Speed: 0\n" + 
                                "Range: 0\n" + 
                                "Cooldown: 20" + reset);
                            validInput = true;
                            break;
                        default:
                            System.out.println(red + bold + "PILIHAN TIDAK VALID. MASUKKAN PILIHAN YANG VALID." + reset);
                            validInput = false;
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println(red + bold + "INPUT TIDAK VALID. MASUKKAN INTEGER!" + reset);
                    sc.nextLine();
                }
            }
            System.out.println(green + bold + "APAKAH ANDA INGIN MELIHAT TANAMAN LAIN? (Y/N)" + reset);
            boolean validSortChoice = false;
            while (!validSortChoice) {
                char sortChoice = sc.next().charAt(0);
                if (sortChoice == 'Y') {
                sc.nextLine();
                continueLoop = true;
                break;
                }
                else if (sortChoice == 'N') {
                sc.nextLine();
                continueLoop = false;
                break;
            }
            else {
                System.out.println(red + bold + "INPUT TIDAK VALID. MASUKKAN Y/N!" + reset);
            }
            sc.nextLine();
        }    
    } 
}

    private static void displayZombiesList() {
        String green = "\033[32m"; // Kode warna hijau
        String yellow = "\u001B[33m"; // Kode warna kuning
        String red = "\033[31m";   // Kode warna merah
        String bold = "\033[1m"; // Kode bold
        String reset = "\033[0m";  // Reset warna
        //Scanner sc = new Scanner(System.in); 
        boolean continueLoop = true;
        while(continueLoop) {
            // Print Nama Tanaman
            System.out.println(red + bold + "\r\n" +
                "██████████████████████████████████████████████████████████████████████████████  \r\n" + reset);
            System.out.println(red + bold + "██      ██ ███████ ████████     ███████  ██████  ███    ███ ██████  ██ ███████ ███████" + reset);
            System.out.println(red + bold + "██      ██ ██         ██           ███  ██    ██ ████  ████ ██   ██ ██ ██      ██" + reset);
            System.out.println(red + bold + "██      ██ ███████    ██          ███   ██    ██ ██ ████ ██ ██████  ██ █████   ███████" + reset);
            System.out.println(red + bold + "██      ██      ██    ██         ███    ██    ██ ██  ██  ██ ██   ██ ██ ██           ██" + reset);
            System.out.println(red + bold + "███████ ██ ███████    ██        ███████  ██████  ██      ██ ██████  ██ ███████ ███████" + reset);
            System.out.println(" ");
            System.out.println(yellow + bold + "1. NORMAL ZOMBIE");
            System.out.println("2. CONEHEAD ZOMBIE");
            System.out.println("3. POLE VAULTING ZOMBIE");
            System.out.println("4. BUCKETHEAD ZOMBIE");
            System.out.println("5. DUCKY TUBE ZOMBIE");
            System.out.println("6. DOLPHIN RIDER ZOMBIE");
            System.out.println("7. FOOTBALL ZOMBIE");
            System.out.println("8. GARGANTUAR");
            System.out.println("9. NEWSPAPER ZOMBIE");
            System.out.println("10. YETI ZOMBIE" + reset);
            System.out.println(red + bold + "\r\n" + //
            "██████████████████████████████████████████████████████████████████████████████  \r\n" + reset);
            System.out.println(green + bold + "MASUKKAN NOMOR ZOMBIE: " + reset);
            // Print deskripsi tiap tanaman 
            boolean validInput = false;
            while (!validInput) {
                try {
                    int choice = sc.nextInt();
                    sc.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.println(
                                yellow + bold + "Name: NORMAL ZOMBIE\n" +
                                "Health: 125\n" +
                                "Attack Damage: 100\n" +
                                "Attack Speed: 1\n" + 
                                "Aquatic: Tidak\n" + reset);
                            validInput = true;
                            break;
                        case 2:
                            System.out.println(
                                yellow + bold + "Name: CONEHEAD ZOMBIE\n" +
                                "Health: 250\n" +
                                "Attack Damage: 100\n" +
                                "Attack Speed: 1\n" + 
                                "Aquatic: Tidak\n" + reset);
                            validInput = true;
                            break;
                        case 3:
                            System.out.println(
                                yellow + bold + "Name: POLE VAULTING ZOMBIE\n" +
                                "Health: 175\n" +
                                "Attack Damage: 100\n" +
                                "Attack Speed: 1\n" + 
                                "Aquatic: Tidak\n" + reset);
                            validInput = true;
                            break;
                        case 4:
                            System.out.println(
                                yellow + bold + "Name: BUCKETHEAD ZOMBIE\n" +
                                "Health: 300\n" +
                                "Attack Damage: 100\n" +
                                "Attack Speed: 1\n" + 
                                "Aquatic: Tidak\n" + reset);
                            validInput = true;
                            break;
                        case 5:
                            System.out.println(
                                yellow + bold + "Name: DUCKY TUBE ZOMBIE\n" +
                                "Health: 100\n" +
                                "Attack Damage: 100\n" +
                                "Attack Speed: 1\n" + 
                                "Aquatic: Iya\n" + reset);
                            validInput = true;
                            break;
                        case 6:
                            System.out.println(
                                yellow + bold + "Name: DOLPHIN RIDER ZOMBIE\n" +
                                "Health: 175\n" +
                                "Attack Damage: 100\n" +
                                "Attack Speed: 1\n" + 
                                "Aquatic: Iya\n" + reset);
                            validInput = true;
                            break;
                        case 7:
                            System.out.println(
                                yellow + bold + "Name: FOOTBALL ZOMBIE\n" +
                                "Health: 300\n" +
                                "Attack Damage: 100\n" +
                                "Attack Speed: 1\n" + 
                                "Aquatic: Tidak\n" + reset);
                            validInput = true;
                            break;
                        case 8:
                            System.out.println(
                                yellow + bold + "Name: GARGANTUAR\n" +
                                "Health: 1000\n" +
                                "Attack Damage: 250\n" +
                                "Attack Speed: 1\n" + 
                                "Aquatic: Tidak\n" + reset);
                            validInput = true;
                            break;
                        case 9:
                            System.out.println(
                                yellow + bold + "Name: NEWSPAPER ZOMBIE\n" +
                                "Health: 175\n" +
                                "Attack Damage: 100\n" +
                                "Attack Speed: 1\n" + 
                                "Aquatic: Tidak\n" + reset);
                            validInput = true;
                            break;
                        case 10:
                            System.out.println(
                                yellow + bold + "Name: YETI ZOMBIE\n" +
                                "Health: 500\n" +
                                "Attack Damage: 200\n" +
                                "Attack Speed: 1\n" + 
                                "Aquatic: Tidak\n" + reset);
                            validInput = true;
                            break;
                        default:
                            System.out.println(red + bold + "PILIHAN TIDAK VALID. MASUKKAN PILIHAN YANG VALID." + reset);
                            validInput = false;
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println(red + bold + "INPUT TIDAK VALID. MASUKKAN INTEGER!" + reset);
                    sc.nextLine();
                }
            }
            System.out.println(green + bold + "APAKAH ANDA INGIN MELIHAT TANAMAN LAIN? (Y/N)" + reset);
            boolean validSortChoice = false;
            while (!validSortChoice) {
                char sortChoice = sc.next().charAt(0);
                if (sortChoice == 'Y') {
                sc.nextLine();
                continueLoop = true;
                break;
                }
                else if (sortChoice == 'N') {
                sc.nextLine();
                continueLoop = false;
                break;
            }
            else {
                System.out.println(red + bold + "INPUT TIDAK VALID. MASUKKAN Y/N!" + reset);
            }
            sc.nextLine();
        }    
    } 
}
        


    public static void startGame() {
        String yellow = "\u001B[33m"; // Kode warna kuning
        String green = "\033[32m"; // Kode warna hijau
        String bold = "\033[1m"; // Kode bold
        String reset = "\033[0m";  // Reset warna
        String red = "\033[31m";   // Kode warna merah
        //Scanner sc = new Scanner(System.in); 
        boolean continueLoop = true;
        int index1;
        Map map = new Map();
        Plant peashooter = new Peashooter();
        Plant potato = new PotatoMine();
        Plant sunflower = new Sunflower();
        Plant repeater = new Repeater();
        Plant squash = new Squash();
        Plant snowpea = new SnowPea();
        Plant tallnut = new Tallnut();
        Plant jalapeno = new Jalapeno();
        Plant lilypad = new Lilypad();
        Plant wallnut = new Wallnut();      

        Inventory inventory = new Inventory();
        Deck deck = new Deck();
        inventory.addPlantToInventory(peashooter);
        inventory.addPlantToInventory(potato);
        inventory.addPlantToInventory(sunflower);
        inventory.addPlantToInventory(repeater);
        inventory.addPlantToInventory(squash);
        inventory.addPlantToInventory(snowpea);
        inventory.addPlantToInventory(tallnut);
        inventory.addPlantToInventory(jalapeno);
        inventory.addPlantToInventory(lilypad);
        inventory.addPlantToInventory(wallnut);

        System.out.println(yellow + bold + "\r\n" + //
                                "█████████████████████████████████████████████████████████████████████████████  \r\n" + reset);
        System.out.println(yellow + "██╗███╗   ██╗██╗   ██╗███████╗███╗   ██╗████████╗ ██████╗ ██████╗ ██╗   ██╗" + reset);
        System.out.println(yellow + "██║████╗  ██║██║   ██║██╔════╝████╗  ██║╚══██╔══╝██╔═══██╗██╔══██╗╚██╗ ██╔╝" + reset);
        System.out.println(yellow + "██║██╔██╗ ██║██║   ██║█████╗  ██╔██╗ ██║   ██║   ██║   ██║██████╔╝ ╚████╔╝ " + reset);
        System.out.println(yellow + "██║██║╚██╗██║╚██╗ ██╔╝██╔══╝  ██║╚██╗██║   ██║   ██║   ██║██╔══██╗  ╚██╔╝  " + reset);
        System.out.println(yellow + "██║██║ ╚████║ ╚████╔╝ ███████╗██║ ╚████║   ██║   ╚██████╔╝██║  ██║   ██║   " + reset);
        System.out.println(yellow + bold + "╚═╝╚═╝  ╚═══╝  ╚═══╝  ╚══════╝╚═╝  ╚═══╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝   ╚═╝   ");
        System.out.println(yellow + bold + "\r\n" + //
                                "█████████████████████████████████████████████████████████████████████████████  \r\n");
        inventory.showInventory();
        System.out.println(yellow + bold + "\r\n" + //
        "██████████████████████████████████████████████████████████████████████████████  \r\n" + reset);
        System.out.println(" " + reset);
        while (continueLoop) {
            System.out.println(green + bold + "INGIN MENGUBAH URUTAN INVENTORY? (Y/N)" + reset);
            char sortChoice = sc.next().charAt(0);
            if (sortChoice == 'Y') {
                System.out.println(green + bold + "MASUKKAN INDEKS TANAMAN YANG INGIN DIPINDAH: " + reset);
                int index6 = sc.nextInt();
                System.out.println(green + bold + "MAU DIPINDAH KE POSISI MANA: " + reset);
                int index7 = sc.nextInt();
                if (index6 >= 1 && index6 <= inventory.getInventory().size() && index7 >= 1 && index7 <= inventory.getInventory().size()) {
                    inventory.switchInventoryTanaman(index6-1, index7-1);
                    System.out.println(inventory.getInventory().get(index7-1).getItem().getName() + " berhasil dipindah ke " + index7);
                    System.out.println("Inventory:");
                    inventory.showInventory();
                } else {
                    System.out.println(green + bold + "INDEKS TAK VALID!" + reset);
                }
            }
            else if(sortChoice == 'N') {
                break;
            }
            else {
                System.out.println(green + bold + "MASUKKAN TAK VALID!" + reset);
            }
        }
    

        sc.nextLine().trim();
        
        System.out.println(green + bold + "TAMBAH TANAMAN KE DECK: " + reset);
        index1 = sc.nextInt();

        while (deck.getDeckSize() < 6) {
            try {
                if (index1 >= 1 && index1 <= inventory.getInventory().size()) {
                    deck.addPlant(inventory.getPlant(index1-1));
                    System.out.println(inventory.getInventory().get(index1-1).getItem().getName() + " ditambah ke deck!");
                    System.out.println("Isi deck: "+ deck.getDeckSize());
                } else {
                    System.out.println(green + bold + "INDEKS TAK VALID!" + reset);
                }
            }
            catch (PlantAlreadyPickedException e) {
                System.out.println(e.getClass().getName() + "! " + "Tanaman sudah dipilih sebelumnya!");
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println(e.getClass().getName() + "! " + "Indeks di luar batas!");
            }
            if (deck.getDeckOfPlants().size() != 6) {
                index1 = sc.nextInt();
            }
        }

        
        System.out.println(green + bold + "DECK:" + reset);
        deck.displayDeck();


        while (continueLoop) {
            System.out.println(green + bold + "INGIN MENUKAR TANAMAN? (Y/N)" + reset);
            char switchChoice = sc.next().charAt(0);
            if (switchChoice == 'Y') {
                try {
                    System.out.println(green + bold + "MASUKKAN INDEKS TANAMAN YANG INGIN DITUKAR: " + reset);
                    int index2 = sc.nextInt();
                    System.out.println(green + bold + "MAU DITUKAR KE POSISI MANA: " + reset);
                    int index3 = sc.nextInt();

                    if (index2 >= 1 && index2 <= deck.getDeckOfPlants().size() && index3 >= 1 && index3 <= deck.getDeckOfPlants().size()) {
                        deck.swapDeck(index2-1, index3-1);
                        System.out.println(deck.getDeckOfPlants().get(index2-1).getItem().getName() + " berhasil ditukar dengan " + deck.getDeckOfPlants().get(index3-1).getItem().getName());
                        System.out.println(green + bold + "DECK: " + reset);
                        deck.displayDeck();
                    } else {
                        System.out.println(green + bold + "INDEKS TAK VALID!" + reset);
                    }
                } catch (CannotSwapDeckException e) {
                    System.out.println(e.getClass().getName() + "! " + "Tidak bisa menukar tanaman!");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(e.getClass().getName() + "! " + "Indeks tidak valid!");
                }
            }
            else if (switchChoice == 'N') {
                break;
            }
            else {
                System.out.println(green + bold + "MASUKKAN TAK VALID!" + reset);
            }
        }

        while (continueLoop) {
            System.out.println(green + bold + "INGIN MENGHAPUS TANAMAN? (Y/N)" + reset);
            char deleteChoice = sc.next().charAt(0);
            if (deleteChoice == 'Y') {
                try {
                    System.out.println(green + bold + "MASUKKAN INDEKS TANAMAN YANG INGIN DIHAPUS: " + reset);
                int index4 = sc.nextInt();
                if (index4 >= 1 && index4 <= deck.getDeckOfPlants().size()) {
                    System.out.println(deck.getDeckOfPlants().get(index4-1).getItem().getName() + " sudah dihapus");
                    deck.deletePlant(index4-1);
                    System.out.println("Deck:");
                    deck.displayDeck();
                } else {
                    System.out.println(green + bold + "INPUT TAK VALID!" + reset);
                }
                } catch (InputMismatchException e) {
                System.out.println(green + bold + "INPUT TIDAK VALID. MASUKKAN INTEGER!" + reset);
                sc.nextLine();
                }
                catch (CannotDeletePlantException e) {
                System.out.println(e.getClass().getName() + "! " + "Tanaman tidak dapat dihapus!");
                }
                catch (IndexOutOfBoundsException e) {
                    System.out.println(e.getClass().getName() + "! " + "Indeks tidak valid!");
                }
            }

            else if (deleteChoice == 'N') {
                break;
            }
            else {
                System.out.println(green + bold + "INPUT TAK VALID!" + reset);
            }
        }

        Thread sunGeneration = new Thread(new Runnable() {
            @Override
            public void run(){
                int lastSun = 0;
                long startTime = System.currentTimeMillis();
                boolean isDay = false;
                while (!Thread.currentThread().isInterrupted() && map.getPlayingStatus()) {
                    long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
                    long cycleTime = elapsedTime % 200; // Cycle repeats every 200 seconds
                    if (cycleTime < 100) { // Day time
                        if (!isDay) {
                            System.out.println(green + bold + "SEKARANG PAGI HARII!!!" + reset);
                            isDay = true;
                            Sun.generateSun();
                        }
                    } else { // Night time
                        if (isDay) {
                            System.out.println(green + bold + "UDAH MALEM NIH!" + reset);
                            isDay = false;
                            Sun.stopGenerateSun();
                        }
                    }
                    if (Sun.sun > lastSun) {
                        System.out.println("Current sun: " + Sun.sun);
                        lastSun = Sun.sun;
                        map.viewMap();
                    }
                    try {
                        map.attackPlants(); 
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Thread was interrupted, stopping...");
                        Thread.currentThread().interrupt(); // Preserve the interrupted status
                    }
                }
            }
        });

        Thread zombieSpawner = new Thread(new Runnable() {
            @Override
            public void run(){
                long startTime = System.currentTimeMillis();
                boolean isSpawning = false;
                while (!Thread.currentThread().isInterrupted() && map.getPlayingStatus()) {
                    long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
                    long cycleTime = elapsedTime % 200; // Cycle repeats every 200 seconds
                    if (cycleTime >= 20 && cycleTime <= 160) { // Zombie spawning time
                        if (!isSpawning) {
                            System.out.println(green + bold + "ZOMBIES ARE COMINGG...BRAINSS!!!" + reset);
                            isSpawning = true;
                            map.setSpawningZombie(isSpawning);
                        }
                        map.spawnZombieMap();
                        map.viewMap();
                    } else {
                        if (isSpawning) {
                            System.out.println(green + bold + "ZOMBIES HAVE STOPPED SPAWNING" + reset);
                            isSpawning = false;
                            map.setSpawningZombie(isSpawning);
                            map.viewMap();
                        }
                    }
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        System.out.println("Thread was interrupted, stopping...");
                        Thread.currentThread().interrupt(); // Preserve the interrupted status
                    }
                }
            }

        });

        Thread zombieMover = new Thread(new Runnable() {
            @Override
            public void run(){
                while (!Thread.currentThread().isInterrupted() && map.getPlayingStatus()) {
                    try {
                        Thread.sleep(1000);
                        map.moveZombies();
                    } catch (InterruptedException e) {
                        System.out.println("Thread was interrupted, stopping...");
                        Thread.currentThread().interrupt(); // Preserve the interrupted status
                    }
                }
                
            }
        });

        Thread gameConditionChecker = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted() && map.getPlayingStatus()) {
                    try {
                        Thread.sleep(1000); // Check game condition every secon
                        if (Map.getFactoryZombie().getSpawnedZombies() != null) {
                            if (Map.getFactoryZombie().getSpawnedZombies().size() == 0 && map.isSpawningZombie() == false) {
                                System.out.println(yellow + bold);
                                System.out.println("       .-=========-.");
                                System.out.println("       \\'-=======-'/");
                                System.out.println("       _|   .=.   |_");
                                System.out.println("      ((|  {{ }}  |))");
                                System.out.println("       \\|   /|\\   |/");
                                System.out.println("        \\__ '`' __/");
                                System.out.println("          _`) (`_");
                                System.out.println("        _/_______\\_");
                                System.out.println("       /___________\\");
                                System.out.println("██╗   ██╗ ██████╗ ██╗   ██╗    ██╗    ██╗██╗███╗   ██╗");
                                System.out.println("╚██╗ ██╔╝██╔═══██╗██║   ██║    ██║    ██║██║████╗  ██║");
                                System.out.println(" ╚████╔╝ ██║   ██║██║   ██║    ██║ █╗ ██║██║██╔██╗ ██║");
                                System.out.println("  ╚██╔╝  ██║   ██║██║   ██║    ██║███╗██║██║██║╚██╗██║");
                                System.out.println("   ██║   ╚██████╔╝╚██████╔╝    ╚███╔███╔╝██║██║ ╚████║");
                                System.out.println("   ╚═╝    ╚═════╝  ╚═════╝      ╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝" + reset) ;
                                checkGameOver();
                                Thread.currentThread().interrupt();
                                zombieMover.interrupt();
                                zombieSpawner.interrupt();
                                sunGeneration.interrupt();
                                break;
                                
                               
                            }
                        }
        
                            if (map.isZombieOnLastTile()) {
                                System.out.println(red + bold);
                                System.out.println(" ██████╗  █████╗ ███╗   ███╗███████╗     ██████╗ ██╗   ██╗███████╗██████╗ ");
                                System.out.println("██╔════╝ ██╔══██╗████╗ ████║██╔════╝    ██╔═══██╗██║   ██║██╔════╝██╔══██╗");
                                System.out.println("██║  ███╗███████║██╔████╔██║█████╗      ██║   ██║██║   ██║█████╗  ██████╔╝");
                                System.out.println("██║   ██║██╔══██║██║╚██╔╝██║██╔══╝      ██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗");
                                System.out.println("╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗    ╚██████╔╝ ╚████╔╝ ███████╗██║  ██║");
                                System.out.println(" ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝     ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═╝" + reset);
                                Thread.currentThread().interrupt();
                                zombieMover.interrupt();
                                zombieSpawner.interrupt();
                                sunGeneration.interrupt();
                                checkGameOver();
                            }
                    } catch (InterruptedException e) {
                        System.out.println("Thread was interrupted, stopping...");
                        Thread.currentThread().interrupt(); // Preserve the interrupted status
                    }
                        // boolean validInput = false;
                        // while (!validInput) {
                        //     System.out.println(green + bold + "INGIN BERMAIN KEMBALI? (Y/N)" + reset);
                        //     String input = sc.nextLine().trim().toUpperCase(); // Read full line and trim whitespace

                        //     if (input.equals("Y")) {
                        //         validInput = true;
                        //         startGame(); // Start game directly
                        //     } else if (input.equals("N")) {
                        //         System.out.println(green + bold + "KEMBALI KE MENU GAME..." + reset);
                        //         validInput = true; // Break the loop, ending method execution
                        //     } else {
                        //         System.out.println(red + bold + "INPUT TIDAK VALID. MASUKKAN Y/N!" + reset);
                        //     
                }
            }  
        });
        
        gameConditionChecker.start();


        // Thread 3: Moves a zombie every 5 seconds.
        // executor.submit(() -> {
        //     while (!Thread.currentThread().isInterrupted()) {
        //         try {
        //             Thread.sleep(5000);
        //             map.moveZombies();
        //         } catch (InterruptedException e) {
        //             System.out.println("Thread was interrupted, stopping...");
        //             Thread.currentThread().interrupt(); // Preserve the interrupted status
        //         }
        //     }
        // });

        // Thread attackAll = new Thread (new Runnable() {
        //     @Override
        //     public void run() {
        //         while (true) {
        //             // System.out.println("Attack all zombies");
        //             try {
        //                 Map.attackPlants();
        //             } catch (NoPlantException e) {
        //                 System.out.println(e.getClass().getName());
        //                 e.printStackTrace();
        //             }
        //             try {
        //                 Thread.sleep(1000);
        //             } catch (InterruptedException e) {
        //                 System.out.println("Print thread interrupted");
        //                 return;
        //             }
        //         }
        //     }
        // });
        sunGeneration.start();
        zombieSpawner.start();
        zombieMover.start();
        // attackAll.start();


        while(map.getPlayingStatus()) {
            System.out.println(green + bold + "INGIN MENANANAM (T) ATAU MENGGALI (G)?" + reset);
            char choice = sc.next().charAt(0);
            if(choice == 'T'){
                System.out.println(green + bold + "INGIN MENANAM TANAMAN? (Y/N)" + reset);
                char plantChoice = sc.next().charAt(0);

                while (plantChoice == 'Y') {
                    System.out.println(green + bold + "MASUKKAN INDEKS TANAMAN YANG INGIN DITANAM: " + reset);
                    System.out.println(green + bold + "DECK" + reset);
                    deck.displayDeck();
                    int index5 = sc.nextInt();
                    System.out.println(green + bold + "MASUKKAN KOORDINAT TANAMAN YANG INGIN DITANAM: " + reset);
                    int row = sc.nextInt();
                    int column = sc.nextInt();
                    if (index5 >= 1 && index5 <= deck.getDeckOfPlants().size() && row >= 0 && row <= 6 && column >= 0 && column <= 9) {
                        map.addPlantToTile(row, column, deck.getDeckOfPlants().get(index5-1).getItem());
                        map.viewMap();
                        System.out.println("Current sun: " + Sun.sun);
                    } else {
                        System.out.println(green + bold + "INDEKS ATAU KOORDINAT TAK VALID!" + reset);
                    }

                    System.out.println(green + bold + "INGIN MENANAM TANAMAN? (Y/N)" + reset);
                    plantChoice = sc.next().charAt(0);

                }
            }
            else if(choice == 'G'){
                System.out.println(green + bold + "INGIN MENGGALI TANAMAN? (Y/N)" + reset);
                char digChoice = sc.next().charAt(0);
                if (digChoice == 'Y') {
                    System.out.println(green + bold + "MASUKKAN KOORDINAT TANAMAN YANG INGIN DIGALI: " + reset);
                    int row2 = sc.nextInt();
                    int column2 = sc.nextInt();
                    if (row2 >= 0 && row2 <= 5 && column2 >= 0 && column2 <= 9) {
                        map.removePlantFromTile(row2-1, column2);
                        map.viewMap();
                        System.out.println("Current sun: " + Sun.sun);                
                    } else {
                        System.out.println(green + bold + "KOORDINAT TAK VALID!" + reset);
                    }
                }
            }
            //Scanner sc = new Scanner(System.in); 
        } 
    }

        

    private static void checkGameOver() {
        String red = "\033[31m";   // Kode warna merah
        String green = "\033[32m"; // Kode warna hijau
        String bold = "\033[1m"; // Kode bold
        String reset = "\033[0m";  // Reset warna
        //Scanner sc = new Scanner(System.in); 
        boolean validInput = false;
        while (!validInput) {
            System.out.println(green + bold + "INGIN BERMAIN KEMBALI? (Y/N)" + reset);
            String input = sc.nextLine().trim().toUpperCase(); // Read full line and trim whitespace

            if (input.equals("Y")) {
                validInput = true;
                startGame(); // Start game directly
            } else if (input.equals("N")) {
                System.out.println(green + bold + "KEMBALI KE MENU GAME..." + reset);
                validInput = true; // Break the loop, ending method execution
            } else {
                System.out.println(red + bold + "INPUT TIDAK VALID. MASUKKAN Y/N!" + reset);
            }
        }
    }
}

