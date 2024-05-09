import java.util.Scanner;
import Exception.*;
import Map.*;
import Plants.*;
import Player.*;
import Zombies.*;

public class GameEngine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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

        Zombie normalZombie = new NormalZombie();
        Zombie bucketHead = new BucketheadZombie();
        Zombie coneHead = new ConeheadZombie();
        Zombie dolphinRider = new DolphinRiderZombie();
        Zombie football = new FootballZombie();
        Zombie gargantuar = new Gargantuar();
        Zombie newsPaper = new NewspaperZombie();
        Zombie poleVaulting = new PoleVaultingZombie();
        Zombie yeti = new YetiZombie();

        

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


        System.out.println("Inventory:");
        inventory.showInventory();
        System.out.println("Tambah tanaman ke deck: ");
        String input = sc.nextLine().trim();
        index1 = input.isEmpty() ? -1 : Integer.parseInt(input);

        while (deck.getDeckOfPlants().size() < 6) {
            try {
                if (index1 >= 1 && index1 <= inventory.getInventory().size()) {
                    inventory.addPlant(deck, index1-1);
                    System.out.println(inventory.getInventory().get(index1-1).getName() + " ditambah ke deck!");
                } else if (input.isEmpty()) {
                    break;
                } else {
                    System.out.println("Indeks tidak valid!");
                }
            }
            catch (PlantAlreadyPickedException e) {
                System.out.println(e.getClass().getName() + "! " + "Tanaman sudah dipilih sebelumnya!");
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println(e.getClass().getName() + "! " + "Indeks di luar batas!");
            }
            if (deck.getDeckOfPlants().size() != 6) {
                input = sc.nextLine().trim();
                index1 = input.isEmpty() ? -1 : Integer.parseInt(input);
            }
        }

        
        System.out.println("Deck:");
        deck.displayDeck();

        System.out.println("Ingin menukar tanaman? (Y/N)");
        char switchChoice = sc.next().charAt(0);

        if (switchChoice == 'Y') {
            try {
                System.out.println("Masukkan indeks tanaman yang ingin ditukar : ");
                int index2 = sc.nextInt();
                System.out.println("Mau ditukar ke posisi mana?");
                int index3 = sc.nextInt();

                if (index2 >= 1 && index2 <= deck.getDeckOfPlants().size() && index3 >= 1 && index3 <= deck.getDeckOfPlants().size()) {
                    deck.swapDeck(index2-1, index3-1);
                    System.out.println(deck.getDeckOfPlants().get(index2-1).getName() + " berhasil ditukar dengan " + deck.getDeckOfPlants().get(index3-1).getName());
                    System.out.println("Deck:");
                    deck.displayDeck();
                } else {
                    System.out.println("Indeks tidak valid!");
                }
            } catch (CannotSwapDeckException e) {
                System.out.println(e.getClass().getName() + "! " + "Tidak bisa menukar tanaman!");
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getClass().getName() + "! " + "Indeks tidak valid!");
            }
        }

        System.out.println("Hapus tanaman? (Y/N)");
        char deleteChoice = sc.next().charAt(0);
        if (deleteChoice == 'Y') {
            try {
            System.out.println("Masukkan indeks tanaman yang ingin dihapus : ");
            int index4 = sc.nextInt();
            if (index4 >= 1 && index4 <= deck.getDeckOfPlants().size()) {
                System.out.println(deck.getDeckOfPlants().get(index4-1).getName() + " sudah dihapus");
                deck.deletePlant(index4-1);
                System.out.println("Deck:");
                deck.displayDeck();
            } else {
                System.out.println("Indeks tidak valid!");
            }
            }
            catch (CannotDeletePlantException e) {
            System.out.println(e.getClass().getName() + "! " + "Tanaman tidak dapat dihapus!");
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println(e.getClass().getName() + "! " + "Indeks tidak valid!");
            }
        }

        // MULAI PERMAINAN

        Sun.generateSun();

        new Thread(() -> {
            int lastSun = 0;
            while (true) {
                if (Sun.sun > lastSun) {
                    System.out.println("Current sun: " + Sun.sun);
                    lastSun = Sun.sun;
                    map.spawnZombieMap();
                    map.viewMap();
                    map.moveZombies();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).
        start();




        System.out.println("Ingin menanam tanaman? (Y/N)");
        char plantChoice = sc.next().charAt(0);

        while (plantChoice == 'Y') {
            System.out.println("Masukkan indeks tanaman yang ingin ditanam : ");
            System.out.println("Deck:");
            deck.displayDeck();
            int index5 = sc.nextInt();
            System.out.println("Masukkan koordinat tanaman yang ingin ditanam : ");
            int row = sc.nextInt();
            int column = sc.nextInt();
            if (index5 >= 1 && index5 <= deck.getDeckOfPlants().size() && row >= 0 && row <= 5 && column >= 0 && column <= 9) {
                map.addPlantToTile(row-1, column, deck.getDeckOfPlants().get(index5-1));
                map.viewMap();
                System.out.println("Current sun: " + Sun.sun);
            } else {
                System.out.println("Indeks atau koordinat tidak valid!");
            }

            System.out.println("Ingin menanam tanaman? (Y/N)");
            plantChoice = sc.next().charAt(0);

        }
        
        sc.close();
        
        

    }
}
