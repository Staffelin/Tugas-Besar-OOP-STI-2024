import java.util.Scanner;

import Exception.CannotDeletePlantException;
import Exception.CannotSwapDeckException;
import Exception.DeckFullException;
import Exception.PlantAlreadyPickedException;
import Map.*;
import Plants.*;
import Player.*;
import Times.*;
import Zombies.*;

public class GameEngine {
    public static void main(String[] args) {
        
    
        Scanner sc = new Scanner(System.in);
        int index1;
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

        Player currentPlayer = new Player();
        Map map = new Map();


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


        // System.out.println("Inventory:");
        // inventory.showInventory();
        // System.out.println("Add to deck: ");
        // index1 = sc.nextInt();

        // while (deck.getDeckOfPlants().size() <= 6) {
        //     try {
        //         inventory.addPlant(deck, index1-1);
        //         System.out.println(inventory.getInventory().get(index1-1).getName() + " added to deck");    
        //     }
        //     catch (DeckFullException e) {
        //         System.out.println(e.getClass().getName() + "! " + "Deck is full");
        //         break;
        //     }
        //     catch (PlantAlreadyPickedException e) {
        //         System.out.println(e.getClass().getName() + "! " + "Plant already picked");
        //     }
        //     catch (IndexOutOfBoundsException e) {
        //         System.out.println(e.getClass().getName() + "! " + "Index out of bounds");
        //     }
        //     index1 = sc.nextInt();
        // }

        
        // System.out.println("Deck:");
        // deck.displayDeck();

        // System.out.println("Switch plants in deck? (Y/N)");
        // char switchChoice = sc.next().charAt(0);

        // if (switchChoice == 'Y') {
        //     try {
        //     System.out.println("Masukkan indeks tanaman yang ingin ditukar : ");
        //     int index2 = sc.nextInt();
        //     System.out.println("Mau ditukar ke mana?");
        //     int index3 = sc.nextInt();
        //     deck.swapDeck(index2-1, index3-1);

        //     System.out.println(deck.getDeckOfPlants().get(index2-1).getName() + " swapped with " + inventory.getDeck().getDeckOfPlants().get(index3-1).getName());
        //     System.out.println("Deck:");
        //     deck.displayDeck();
        //     }
        //     catch (CannotSwapDeckException e) {
        //         System.out.println(e.getClass().getName() + "! " + "Cannot swap deck");
        //     }
        // }

        // System.out.println("Delete plant from deck? (Y/N)");
        // char deleteChoice = sc.next().charAt(0);
        // if (deleteChoice == 'Y') {
        //     try {
        //         System.out.println("Masukkan indeks tanaman yang ingin dihapus : ");
        //         int index4 = sc.nextInt();
        //         System.out.println(deck.getDeckOfPlants().get(index4-1).getName() + " deleted");
        //         deck.deletePlant(index4-1);
        //         System.out.println("Deck:");
        //         deck.displayDeck();
        //     }
        //     catch (CannotDeletePlantException e) {
        //         System.out.println(e.getClass().getName() + "! " + "Tanaman tidak dapat dihapus");
        //     }
        // }

        map.viewMap();
        sc.close();

    }

}



