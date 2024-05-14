package Plants;

import java.util.ArrayList;

import Map.*;
import Zombies.Zombie;

public class Squash extends Plant{
    public Squash () {
        super("Squash", 50, 100, 5000, 0, 1, 20);
    }


    @Override
    public void attack(ArrayList<Zombie> zombies) {
        // Get the tile next to the squash
        Petak nextTile = Map.getFromMatriksPetak(this.getRow(), this.getColumn() + 1);

        // If the next tile exists and has zombies, attack
        if (nextTile != null && !nextTile.getListZombies().isEmpty()) {
            for (Zombie zombie : nextTile.getListZombies()) {
                zombie.takeDamage(this.attack_damage); // The squash kills the zombie
            }
            nextTile.getListZombies().clear(); // Remove all zombies from the next tile
            this.die(); // The squash dies after attacking
        }
    }
}

