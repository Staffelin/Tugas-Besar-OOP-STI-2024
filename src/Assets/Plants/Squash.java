package Plants;

import java.util.ArrayList;
import java.util.Iterator;

import Map.*;
import Zombies.Zombie;

public class Squash extends Plant{
    private static boolean isWaiting;
    public Squash () {
        super("Squash", 50, 100, 5000, 0, 1, 20);
    }

    public static void setWaiting(boolean booleanValue) {
        isWaiting = booleanValue;
    }
    public static boolean getWaiting() {
        return isWaiting;
    }

    // @Override
    // public void attack(ArrayList<Zombie> zombies) {
    //     // Get the tile next to the squash    
    //     // If the next tile exists and has zombies, attack
    //     System.out.println("Squash attack method called");
    //     Iterator<Zombie> iterator = zombies.iterator();
    //     while (iterator.hasNext()) {
    //         Zombie z = iterator.next();
    //         if (this.getRow() == z.getRow()) {
    //             z.takeDamage(attack_damage);
    //             System.out.println("Squash menyerang zombie di petak " + z.getRow());
    //             if (z.getHealth() <= 0) {
    //                 iterator.remove();
    //                 System.out.println("Zombie di petak " + z.getRow() + " mati");
    //             }
    //         }
    //     }
    //     this.die();
    //     isWaiting = false; 
    // }
}

