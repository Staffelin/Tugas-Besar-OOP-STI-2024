import java.util.InputMismatchException;
import java.util.Scanner;
import Exception.*;
import Map.*;
import Plants.*;
import Player.*;


public class GameEngine {
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
        
        Scanner sc = new Scanner(System.in);
        boolean exitGame = false;

        while (!exitGame) {
            System.out.println(yellow + "███╗   ███╗███████╗███╗   ██╗██╗   ██╗     ██████╗  █████╗ ███╗   ███╗███████╗" + reset);
            System.out.println(yellow + "████╗ ████║██╔════╝████╗  ██║██║   ██║    ██╔════╝ ██╔══██╗████╗ ████║██╔════╝" + reset);
            System.out.println(yellow + "██╔████╔██║█████╗  ██╔██╗ ██║██║   ██║    ██║  ███╗███████║██╔████╔██║█████╗  " + reset);
            System.out.println(yellow + "██║╚██╔╝██║██╔══╝  ██║╚██╗██║██║   ██║    ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝  " + reset);
            System.out.println(yellow + "██║ ╚═╝ ██║███████╗██║ ╚████║╚██████╔╝    ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗" + reset);
            System.out.println(yellow + "╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝      ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝" + reset);
            System.out.println(yellow + bold + " 1. START" + reset);
            System.out.println(yellow + bold +" 2. HELP" + reset);
            System.out.println(yellow + bold +" 3. PLANTS LIST" + reset);
            System.out.println(yellow + bold +" 4. ZOMBIES LIST" + reset);
            System.out.println(yellow + bold +" 5. EXIT" + reset);
            System.out.println(yellow + bold + "\r\n" + //
            "██████████████████████████████████████████████████████████████████████████████  \r\n" + reset);
            System.out.println(green + bold + "MASUKKAN NOMOR MENU YANG DIPILIH: " + reset);
            try {
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        startGame();
                        break;
                    case 2:
                        displayHelp();
                        break;
                    case 3:
                        displayPlantsList();
                        break;
                    case 4:
                        displayZombiesList();
                        break;
                    case 5:
                        System.out.println("\n================================");
                        System.out.println("   Terima Kasih Telah Bermain!   ");
                        System.out.println("================================");
                        exitGame = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tak valid. Masukkan integer!");
                sc.nextLine();
            }
        }
        sc.close();
    }

    private static void displayHelp() {
        System.out.println("Selamat datang di Michael vs. Lalapan!");
    }

    private static void displayPlantsList() {
        // Assume Plant classes have a method to describe themselves
        System.out.println("Plants available:");
        // Example: System.out.println(new Peashooter().getDescription());
        // Repeat for each plant type
    }

    private static void displayZombiesList() {
        // Assume Zombie classes have a method to describe themselves
        System.out.println("Zombies that may appear:");
        // Example: System.out.println(new NormalZombie().getDescription());
        // Repeat for each zombie type
    }

    public static void startGame() {
        String yellow = "\u001B[33m"; // Kode warna kuning
        String green = "\033[32m"; // Kode warna hijau
        String bold = "\033[1m"; // Kode bold
        String reset = "\033[0m";  // Reset warna
        Scanner sc = new Scanner(System.in);
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
        inventory.getInventory().add(peashooter);
        inventory.getInventory().add(potato);
        inventory.getInventory().add(sunflower);
        inventory.getInventory().add(repeater);
        inventory.getInventory().add(squash);
        inventory.getInventory().add(snowpea);
        inventory.getInventory().add(tallnut);
        inventory.getInventory().add(jalapeno);
        inventory.getInventory().add(lilypad);
        inventory.getInventory().add(wallnut);

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
                    System.out.println(inventory.getInventory().get(index7-1).getName() + " berhasil dipindah ke " + index7);
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

        while (deck.getDeckOfPlants().size() < 6) {
            try {
                if (index1 >= 1 && index1 <= inventory.getInventory().size()) {
                    inventory.addPlant(deck, index1-1);
                    System.out.println(inventory.getInventory().get(index1-1).getName() + " ditambah ke deck!");
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
                        System.out.println(deck.getDeckOfPlants().get(index2-1).getName() + " berhasil ditukar dengan " + deck.getDeckOfPlants().get(index3-1).getName());
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
                    System.out.println(deck.getDeckOfPlants().get(index4-1).getName() + " sudah dihapus");
                    deck.deletePlant(index4-1);
                    System.out.println("Deck:");
                    deck.displayDeck();
                } else {
                    System.out.println(green + bold + "INGIN TAK VALID!" + reset);
                }
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
                while (!Thread.currentThread().isInterrupted() || map.getPlayingStatus()) {
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
                        map.attackPlants(); // Access the static method in a static way
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
                while (!Thread.currentThread().isInterrupted() || map.getPlayingStatus()) {
                    long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
                    long cycleTime = elapsedTime % 200; // Cycle repeats every 200 seconds
                    if (cycleTime >= 20 && cycleTime <= 160) { // Zombie spawning time
                        if (!isSpawning) {
                            System.out.println(green + bold + "ZOMBIES ARE COMINGG...BRAINSS!!!" + reset);
                            isSpawning = true;
                        }
                        map.spawnZombieMap();
                        map.viewMap();
                    } else {
                        if (isSpawning) {
                            System.out.println(green + bold + "ZOMBIES HAVE STOPPED SPAWNING" + reset);
                            isSpawning = false;
                            map.viewMap();
                        }
                    }
                    try {
                        Thread.sleep(1000);
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
                while (!Thread.currentThread().isInterrupted() || map.getPlayingStatus()) {
                    try {
                        Thread.sleep(5000);
                        map.moveZombies();
                    } catch (InterruptedException e) {
                        System.out.println("Thread was interrupted, stopping...");
                        Thread.currentThread().interrupt(); // Preserve the interrupted status
                    }
                }
                System.out.println("Thread stopped");
                
            }
        });

        
        // Thread 1: Generates sun every second during the day time.
        // executor.submit(() -> {
        //     int lastSun = 0;
        //     long startTime = System.currentTimeMillis();
        //     boolean isDay = false;
        //     while (!Thread.currentThread().isInterrupted()) {
        //         long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
        //         long cycleTime = elapsedTime % 200; // Cycle repeats every 200 seconds
        //         if (cycleTime < 100) { // Day time
        //             if (!isDay) {
        //                 System.out.println("It's now day time.");
        //                 isDay = true;
        //                 Sun.generateSun();
        //             }
        //         } else { // Night time
        //             if (isDay) {
        //                 System.out.println("It's now night time.");
        //                 isDay = false;
        //                 Sun.stopGenerateSun();
        //             }
        //         }
        //         if (Sun.sun > lastSun) {
        //             System.out.println("Current sun: " + Sun.sun);
        //             lastSun = Sun.sun;
        //             map.viewMap();
        //         }
        //         try {
        //             Thread.sleep(1000);
        //         } catch (InterruptedException e) {
        //             System.out.println("Thread was interrupted, stopping...");
        //             Thread.currentThread().interrupt(); // Preserve the interrupted status
        //         }
        //     }
        // });

        
        // Thread 2: Spawns zombies every second with a 0.3 probability.
        // Zombies start spawning from second 20 to second 160 of each cycle.
        // executor.submit(() -> {
        //     long startTime = System.currentTimeMillis();
        //     boolean isSpawning = false;
        //     while (!Thread.currentThread().isInterrupted()) {
        //         long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
        //         long cycleTime = elapsedTime % 200; // Cycle repeats every 200 seconds
        //         if (cycleTime >= 20 && cycleTime <= 160) { // Zombie spawning time
        //             if (!isSpawning) {
        //                 System.out.println("Zombies have started spawning.");
        //                 isSpawning = true;
        //             }
        //             map.spawnZombieMap();
        //             map.viewMap();
        //         } else {
        //             if (isSpawning) {
        //                 System.out.println("Zombies have stopped spawning.");
        //                 isSpawning = false;
        //                 map.viewMap();
        //             }
        //         }
        //         try {
        //             Thread.sleep(1000);
        //         } catch (InterruptedException e) {
        //             System.out.println("Thread was interrupted, stopping...");
        //             Thread.currentThread().interrupt(); // Preserve the interrupted status
        //         }
        //     }
        // });

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
                        map.addPlantToTile(row, column, deck.getDeckOfPlants().get(index5-1));
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
        }

        System.out.println(green + bold + "GAME OVER!" + reset);
        sc.close();
        
        

    }
}
