import java.util.InputMismatchException;
import java.util.Scanner;
import Exception.*;
import Map.*;
import Plants.*;
import Player.*;


public class GameEngine {

    private static Scanner menuScanner = new Scanner(System.in);
    private static Scanner gameScanner = new Scanner(System.in);
    private static Thread sunGeneration;
    private static Thread zombieSpawner;
    private static Thread zombieMover;
    private static Thread mapViewer;
    private static boolean inGame = true;
    public static void main(String[] args) {
        displayMainMenu();
    }

    private static void displayMainMenu(){
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

        // Scanner gameScanner  = new Scanner(System.in); 
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
                int choice = menuScanner.nextInt();
                menuScanner.nextLine();

                switch (choice) {
                    case 1:
                        inGame = true;
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
                        inGame = false;
                        break;
                    default:
                        System.out.println(red + bold + "PILIHAN TIDAK VALID. MASUKKAN PILIHAN YANG VALID." + reset);
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println(red + bold + "INPUT TIDAK VALID. MASUKKAN INTEGER!" + reset);
                menuScanner.nextLine();
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
        // Scanner gameScanner  = new Scanner(System.in); 
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
            String choice = gameScanner.nextLine().trim().toUpperCase();
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
        //Scanner gameScanner  = new Scanner(System.in); 
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
                    int choice = gameScanner .nextInt();
                    gameScanner .nextLine();

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
                    gameScanner .nextLine();
                }
            }
            System.out.println(green + bold + "APAKAH ANDA INGIN MELIHAT TANAMAN LAIN? (Y/N)" + reset);
            boolean validSortChoice = false;
            while (!validSortChoice) {
                char sortChoice = gameScanner .next().charAt(0);
                if (sortChoice == 'Y') {
                gameScanner .nextLine();
                continueLoop = true;
                break;
                }
                else if (sortChoice == 'N') {
                gameScanner .nextLine();
                continueLoop = false;
                break;
            }
            else {
                System.out.println(red + bold + "INPUT TIDAK VALID. MASUKKAN Y/N!" + reset);
            }
            gameScanner .nextLine();
        }    
    } 
}

    private static void displayZombiesList() {
        String green = "\033[32m"; // Kode warna hijau
        String yellow = "\u001B[33m"; // Kode warna kuning
        String red = "\033[31m";   // Kode warna merah
        String bold = "\033[1m"; // Kode bold
        String reset = "\033[0m";  // Reset warna
        //Scanner gameScanner  = new Scanner(System.in); 
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
                    int choice = gameScanner .nextInt();
                    gameScanner .nextLine();

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
                    gameScanner .nextLine();
                }
            }
            System.out.println(green + bold + "APAKAH ANDA INGIN MELIHAT TANAMAN LAIN? (Y/N)" + reset);
            boolean validSortChoice = false;
            while (!validSortChoice) {
                char sortChoice = gameScanner .next().charAt(0);
                if (sortChoice == 'Y') {
                gameScanner .nextLine();
                continueLoop = true;
                break;
                }
                else if (sortChoice == 'N') {
                gameScanner .nextLine();
                continueLoop = false;
                break;
            }
            else {
                System.out.println(red + bold + "INPUT TIDAK VALID. MASUKKAN Y/N!" + reset);
            }
            gameScanner .nextLine();
        }    
    } 
}
        


    public static void startGame() {
        String yellow = "\u001B[33m"; // Kode warna kuning
        String green = "\033[32m"; // Kode warna hijau
        String bold = "\033[1m"; // Kode bold
        String reset = "\033[0m";  // Reset warna
        //Scanner gameScanner  = new Scanner(System.in); 
        while(inGame){
            boolean continueLoop = true;
            Map map = new Map();
            Sun sun = new Sun();
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
                char sortChoice = gameScanner.next().charAt(0);
                if (sortChoice == 'Y') {
                    System.out.println(green + bold + "MASUKKAN INDEKS TANAMAN YANG INGIN DIPINDAH: " + reset);
                    int index6 = 0;
                    boolean validInput = false;
                    while (!validInput) {
                        try {
                            index6 = gameScanner.nextInt();
                            if (index6 >= 1 && index6 <= 10) { 
                                validInput = true;
                            } else {
                                System.out.println(green + bold + "INDEKS TAK VALID! MASUKKAN ANGKA ANTARA 1 SAMPAI 10." + reset);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println(green + bold + "INPUT TAK VALID! MASUKKAN INTEGER." + reset);
                            gameScanner.next();
                        }
                    }
                    System.out.println(green + bold + "MAU DIPINDAH KE POSISI MANA: " + reset);
                    validInput = false;
                    int index7 = 0;
                    while (!validInput) {
                        try {
                            index7 = gameScanner.nextInt();
                            if (index7 >= 1 && index7 <= 11) { // assuming the valid range is 1 to 11
                                validInput = true;
                            } else {
                                System.out.println(green + bold + "INDEKS TAK VALID! Harap masukkan angka antara 1 dan 11." + reset);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println(green + bold + "INPUT TAK VALID! Harap masukkan angka." + reset);
                            gameScanner.next(); // clear the invalid input
                        }
                    }

                    if (index6 == index7) {
                        System.out.println(green + bold + "TIDAK BISA DITUKAR DENGAN POSISI SEBELUMNYA" + reset);
                    }
                    else if (index6 >= 1 && index6 <= inventory.getInventory().size() && index7 >= 1 && index7 <= inventory.getInventory().size()) {
                        inventory.switchInventoryTanaman(index6 - 1, index7 - 1);
                        System.out.println(inventory.getInventory().get(index7 - 1).getItem().getName() + " berhasil dipindah ke " + index7);
                        System.out.println("Inventory:");
                        inventory.showInventory();
                    } else {
                        System.out.println(green + bold + "INDEKS TAK VALID!" + reset);
                    }
                } else if (sortChoice == 'N') {
                    break;
                } else {
                    System.out.println(green + bold + "MASUKKAN TAK VALID!" + reset);
                }
            }
           
        System.out.println(green + bold + "INVENTORY" + reset);
        inventory.showInventory();
    
        System.out.println(green + bold + "TAMBAH TANAMAN KE DECK: " + reset);
        while (continueLoop) {
            if (deck.getDeckSize() < 6) {
                System.out.println(green + bold + "MASUKKAN INDEKS TANAMAN YANG INGIN DITAMBAHKAN KE DECK: " + reset);
                boolean invalidInput = true;
                while (invalidInput) {
                    try {
                        int index1 = gameScanner.nextInt();
                        if (index1 >= 1 && index1 <= inventory.getInventory().size()) {
                            deck.addPlant(inventory.getPlant(index1 - 1));
                            System.out.println(inventory.getInventory().get(index1 - 1).getItem().getName() + " ditambah ke deck!");
                            System.out.println("Deck size is: " + deck.getDeckSize());
                            invalidInput = false;
                        } else {
                            System.out.println(green + bold + "INDEKS TAK VALID! Harap masukkan angka antara 1 dan " + inventory.getInventory().size() + "." + reset);
                        }
                    } catch (InputMismatchException e) {
                        System.out.println(green + bold + "INPUT TAK VALID! Harap masukkan angka." + reset);
                        gameScanner.next(); // clear the invalid input
                    } catch (PlantAlreadyPickedException e) {
                        System.out.println(e.getClass().getName() + "! Tanaman sudah dipilih sebelumnya!");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getClass().getName() + "! Indeks di luar batas!");
                    }
                }
            } else {
                System.out.println(green + bold + "DECK:" + reset);
                deck.displayDeck();
                break;
            }
        }

        // Now start the swap and delete process only after deck is full
        while (continueLoop) {
            System.out.println(green + bold + "INGIN MENUKAR TANAMAN? (Y/N)" + reset);
            char switchChoice = gameScanner.next().charAt(0);
            if (switchChoice == 'Y') {
                boolean invalidInput = true;
                while (invalidInput) {
                    try {
                        System.out.println(green + bold + "MASUKKAN INDEKS TANAMAN YANG INGIN DITUKAR: " + reset);
                        int index2 = gameScanner.nextInt();
                        System.out.println(green + bold + "MAU DITUKAR KE POSISI MANA: " + reset);
                        int index3 = gameScanner.nextInt();
                        if (index2 >= 1 && index2 <= deck.getDeckOfPlants().size() && index3 >= 1 && index3 <= deck.getDeckOfPlants().size()) {
                            if (index2 == index3) {
                                System.out.println(green + bold + "TIDAK BISA DITUKAR DENGAN POSISI SAMA" + reset);
                            } else {
                                deck.swapDeck(index2 - 1, index3 - 1);
                                System.out.println(deck.getDeckOfPlants().get(index2 - 1).getItem().getName() + " berhasil ditukar dengan " + deck.getDeckOfPlants().get(index3 - 1).getItem().getName());
                                System.out.println(green + bold + "DECK: " + reset);
                                deck.displayDeck();
                            }
                            invalidInput = false;
                        } else {
                            System.out.println(green + bold + "INDEKS TAK VALID! Harap masukkan angka antara 1 dan " + deck.getDeckOfPlants().size() + "." + reset);
                        }
                    } catch (InputMismatchException e) {
                        System.out.println(green + bold + "INPUT TAK VALID! Harap masukkan angka." + reset);
                        gameScanner.next(); // clear the invalid input
                    } catch (CannotSwapDeckException e) {
                        System.out.println(e.getClass().getName() + "! Tidak bisa menukar tanaman!");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getClass().getName() + "! Indeks tidak valid!");
                    }
                }
            } else if (switchChoice == 'N') {
                break;
            } else {
                System.out.println(green + bold + "MASUKKAN TAK VALID!" + reset);
            }
        }

        while (continueLoop) {
            System.out.println(green + bold + "INGIN MENGHAPUS TANAMAN? (Y/N)" + reset);
            char deleteChoice = gameScanner.next().charAt(0);
            if (deleteChoice == 'Y') {
                boolean invalidInput = true;
                while (invalidInput) {
                    try {
                        System.out.println(green + bold + "MASUKKAN INDEKS TANAMAN YANG INGIN DIHAPUS: " + reset);
                        int index4 = gameScanner.nextInt();
                        if (index4 >= 1 && index4 <= deck.getDeckOfPlants().size()) {
                            System.out.println(deck.getDeckOfPlants().get(index4 - 1).getItem().getName() + " sudah dihapus");
                            deck.deletePlant(index4 - 1);
                            System.out.println("Deck:");
                            deck.displayDeck();
                            invalidInput = false;
                        } else {
                            System.out.println(green + bold + "INPUT TAK VALID! Harap masukkan angka antara 1 dan " + deck.getDeckOfPlants().size() + "." + reset);
                        }
                    } catch (InputMismatchException e) {
                        System.out.println(green + bold + "INPUT TAK VALID! Harap masukkan angka." + reset);
                        gameScanner.next(); // clear the invalid input
                    } catch (CannotDeletePlantException e) {
                        System.out.println(e.getClass().getName() + "! Tanaman tidak dapat dihapus!");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getClass().getName() + "! Indeks tidak valid!");
                    }
                }
            } else if (deleteChoice == 'N') {
                break;
            } else {
                System.out.println(green + bold + "INPUT TAK VALID!" + reset);
            }
        }
    


            sunGeneration = new Thread(new Runnable() {
                @Override
                public void run(){
                    int lastSun = 0;
                    long startTime = System.currentTimeMillis();
                    boolean isDay = false;
                    while (!Thread.currentThread().isInterrupted() && map.getPlayingStatus()) {
                        long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
                        if (elapsedTime < 100) { // Day time
                            if (!isDay) {
                                System.out.println(green + bold + "SEKARANG PAGI HARII!!!" + reset);
                                isDay = true;
                                sun.generateSun();
                            }
                        } else { // Night time
                            if (isDay) {
                                System.out.println(green + bold + "UDAH MALEM NIH!" + reset);
                                isDay = false;
                                sun.stopGenerateSun();
                            }
                        }
                        if (Sun.sun > lastSun) {
                            System.out.println("Current sun: " + Sun.sun);
                            lastSun = Sun.sun;
                        }
                        if(elapsedTime >= 160 && (map.isZombieOnLastTile() || Map.getFactoryZombie().getSpawnedZombies().isEmpty())){
                            Thread.currentThread().interrupt();
                        }
                        try {
                            map.attackPlants();
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            System.out.println("sunGeneration was interrupted, stopping...");
                            Thread.currentThread().interrupt(); // Preserve the interrupted status
                        }
                    }
                }
            });

            zombieSpawner = new Thread(new Runnable() {
                @Override
                public void run() {
                    long startTime = System.currentTimeMillis();
                    boolean isSpawning = false;
                    boolean flagEventTriggered = false;
            
                    while (!Thread.currentThread().isInterrupted() && map.getPlayingStatus()) {
                        long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
            
                        if (elapsedTime >= 20 && elapsedTime <= 160) { // Zombie spawning time
                            if (!isSpawning) {
                                System.out.println(green + bold + "ZOMBIES ARE COMINGG...BRAINSS!!!" + reset);
                                isSpawning = true;
                                map.setSpawningZombie(isSpawning);
                            }
                            map.spawnZombieMap();
            
                            if (elapsedTime >= 100 && !flagEventTriggered) { // Trigger flag event
                                Map.setFlag(true);
                                System.out.println(green + bold + "Flag Triggered" + reset);
                                flagEventTriggered = true;
                            }
            
                        } else {
                            if (isSpawning) {
                                System.out.println(green + bold + "ZOMBIES HAVE STOPPED SPAWNING" + reset);
                                isSpawning = false;
                                map.setSpawningZombie(isSpawning);
                                Thread.currentThread().interrupt();
                            }
                        }
            
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            System.out.println("zombieSpawner was interrupted, stopping...");
                            Thread.currentThread().interrupt(); // Preserve the interrupted status
                        }
                    }
                }
            });
            

            zombieMover = new Thread(new Runnable() {
                @Override
                public void run(){
                    while (!Thread.currentThread().isInterrupted() && map.getPlayingStatus()) {
                        try {
                            Thread.sleep(1000);
                            map.moveZombies();
                        } catch (InterruptedException e) {
                            System.out.println("zombieMover was interrupted, stopping...");
                            Thread.currentThread().interrupt(); // Preserve the interrupted status
                        }
                    }
                    
                }
            });

            Thread mapViewer = new Thread(new Runnable() {
                @Override
                public void run(){
                    long startTime = System.currentTimeMillis();
                    while (!Thread.currentThread().isInterrupted() && map.getPlayingStatus()) {
                        long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
                        try {
                            System.out.println("Current time: " + elapsedTime);
                            map.viewMap();
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            System.out.println("mapViewer was interrupted, stopping...");
                            Thread.currentThread().interrupt(); // Preserve the interrupted status
                        }
                    }
                }
            });
            sunGeneration.start();
            mapViewer.start();
            zombieSpawner.start();
            zombieMover.start();

            while(sunGeneration.isAlive() && (zombieMover.isAlive() || zombieSpawner.isAlive())){
                System.out.println(green + bold + "INGIN MENANANAM (T) ATAU MENGGALI (G)?" + reset);
                String choice = gameScanner.nextLine();
                if(choice.equals("T")){
                    System.out.println(green + bold + "INGIN MENANAM TANAMAN? (Y/N)" + reset);
                    char plantChoice = gameScanner .next().charAt(0);
                    while (plantChoice == 'Y') {
                        System.out.println(green + bold + "MASUKKAN INDEKS TANAMAN YANG INGIN DITANAM: " + reset);
                        System.out.println(green + bold + "DECK" + reset);
                        deck.displayDeck();
                        int index5 = gameScanner .nextInt();
                        System.out.println(green + bold + "MASUKKAN KOORDINAT TANAMAN YANG INGIN DITANAM: " + reset);
                        int row = gameScanner .nextInt();
                        int column = gameScanner .nextInt();
                        boolean invalidInput = true;
                        while(invalidInput){
                            if (index5 >= 1 && index5 <= deck.getDeckOfPlants().size() && row >= 0 && row <= 6 && column >= 0 && column <= 9) {
                                map.addPlantToTile(row, column, deck.getDeckOfPlants().get(index5-1).getItem());
                                invalidInput = false;
                                System.out.println("Current sun: " + Sun.sun);
                            } else {
                                System.out.println(green + bold + "INDEKS ATAU KOORDINAT TAK VALID!" + reset);
                            }
                        }
                        

                        System.out.println(green + bold + "INGIN MENANAM TANAMAN? (Y/N)" + reset);
                        plantChoice = gameScanner .next().charAt(0);

                    }
                }
                else if(choice.equals("G")){
                    System.out.println(green + bold + "INGIN MENGGALI TANAMAN? (Y/N)" + reset);
                    char digChoice = gameScanner .next().charAt(0);
                    if (digChoice == 'Y') {
                        System.out.println(green + bold + "MASUKKAN KOORDINAT TANAMAN YANG INGIN DIGALI: " + reset);
                        int row2 = gameScanner .nextInt();
                        int column2 = gameScanner .nextInt();
                        boolean invalidInput = true;
                        while(invalidInput){
                            if (row2 >= 0 && row2 <= 5 && column2 >= 0 && column2 <= 9) {
                                map.removePlantFromTile(row2-1, column2);
                                // map.viewMap();
                                invalidInput = false;
                                System.out.println("Current sun: " + Sun.sun);                
                            } else {
                                System.out.println(green + bold + "KOORDINAT TAK VALID!" + reset);
                            }
                        }
                        
                    }
                }
                //Scanner gameScanner  = new Scanner(System.in); 
                
        } 
        mapViewer.interrupt();
        // zombieMover.interrupt();
        // zombieSpawner.interrupt();
        EndGamePrint(map);
        }
        
        System.exit(1);
        
    }
    
    public static void EndGamePrint(Map map){
        String yellow = "\u001B[33m"; // Kode warna kuning
        String bold = "\033[1m"; // Kode bold
        String reset = "\033[0m";  
        String red = "\033[31m";
        zombieMover.interrupt();
        if(mapViewer != null){
            mapViewer.interrupt();
        }
        if (Map.getFactoryZombie().getSpawnedZombies() != null) {
            if (Map.getFactoryZombie().getSpawnedZombies().size() == 0 && !map.isSpawningZombie()) {
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
                System.out.println("   ╚═╝    ╚═════╝  ╚═════╝      ╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝" + reset);
            }

            if (map.isZombieOnLastTile()) {
                System.out.println(red + bold);
                System.out.println(" ██████╗  █████╗ ███╗   ███╗███████╗     ██████╗ ██╗   ██╗███████╗██████╗ ");
                System.out.println("██╔════╝ ██╔══██╗████╗ ████║██╔════╝    ██╔═══██╗██║   ██║██╔════╝██╔══██╗");
                System.out.println("██║  ███╗███████║██╔████╔██║█████╗      ██║   ██║██║   ██║█████╗  ██████╔╝");
                System.out.println("██║   ██║██╔══██║██║╚██╔╝██║██╔══╝      ██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗");
                System.out.println("╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗    ╚██████╔╝ ╚████╔╝ ███████╗██║  ██║");
                System.out.println(" ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝     ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═╝" + reset);
            }
        }
        restartGame(map);

    }
        

    private static void restartGame(Map map) {
        String green = "\033[32m"; 
        String bold = "\033[1m"; 
        String reset = "\033[0m";  
        boolean validInput = false;
        System.out.println(green + bold + "INGIN BERMAIN KEMBALI?? (Y/N)" + reset);
        
        while (!validInput) {
            
            String input = gameScanner.nextLine(); 
    
            if (input.equals("Y")) {
                validInput = true;
                startGame(); 
            } else if (input.equals("N")) {
                System.out.println(green + bold + "KEMBALI KE MENU GAME..." + reset);
                validInput = true; 
                inGame = false;
                displayMainMenu();
            } 
        }
    }
        
    
    
    
}

