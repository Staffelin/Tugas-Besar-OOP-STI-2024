package Plants;

import java.util.ArrayList;

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

    @Override
    public void attack(ArrayList<Zombie> zombies) {
        // Get the tile next to the squash
        Petak nextTile = Map.getFromMatriksPetak(this.getRow(), this.getColumn() + 1);
    
        // If the next tile exists and has zombies, attack
        if (nextTile != null && !nextTile.getListZombies().isEmpty()) {
            for (Zombie zombie : nextTile.getListZombies()) {
                zombie.takeDamage(this.attack_damage); // The squash attacks the zombie
                System.out.println("Squash attacked");
            }
            nextTile.getListZombies().clear(); // Remove all zombies from the next tile
            this.die(); // The squash dies after attacking
            isWaiting = false;
        }   
    }
}

