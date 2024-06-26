package Plants;

import java.util.ArrayList;
import java.util.List;

// import java.util.ArrayList;
// import java.util.Iterator;

import Map.*;
import Zombies.Zombie;

public class Squash extends Plant{
    public Squash () {
        super("SQUASH", 50, 100, 5000, 0, 1, 20);
    }


    
    @Override
    public void attack() {
        boolean attacked = false;
    
        // Get the tiles next to the squash
        Petak leftTile = Map.getFromMatriksPetak(this.getRow(), this.getColumn() - 1);
        Petak rightTile = Map.getFromMatriksPetak(this.getRow(), this.getColumn() + 1);
        Petak currentTile = Map.getFromMatriksPetak(this.getRow(), this.getColumn());
    
        // If the next tiles exist and have zombies, attack
    
        if (currentTile != null) {
            List<Zombie> currentZombies = new ArrayList<>(currentTile.getListZombies());
            for (Zombie z : new ArrayList<>(currentZombies)) {
                z.takeDamage(this.attack_damage); // Squash kills the zombies
                System.out.println("SQUASH MENYERANG ZOMBIE DI PETAK ASAL, DI " + z.getRow());
                attacked = true;
            }
        }
    
        if (rightTile != null) {
                List<Zombie> rightZombies = new ArrayList<>(rightTile.getListZombies());
                for (Zombie z : new ArrayList<>(rightZombies)) {
                    z.takeDamage(this.attack_damage); // Squash kills the zombies
                    System.out.println("SQUASH MENYERANG ZOMBIE DI PETAK KANANNYA, DI " + z.getRow());
                    attacked = true;
                }
            }
    
        if (leftTile != null) {
                List<Zombie> leftZombies = new ArrayList<>(leftTile.getListZombies());
                for (Zombie z : new ArrayList<>(leftZombies)) {
                    z.takeDamage(this.attack_damage); // Squash kills the zombies
                    System.out.println("SQUASH MENYERANG ZOMBIE DI PETAK KIRINYA, DI " + z.getRow());
                    attacked = true;
                }
            }
        
    
        if (attacked) {
            this.die();
        }
    }
}
