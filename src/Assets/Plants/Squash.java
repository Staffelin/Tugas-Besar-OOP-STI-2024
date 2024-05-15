package Plants;

// import java.util.ArrayList;
// import java.util.Iterator;

import Map.*;
import Zombies.Zombie;

public class Squash extends Plant{
    public Squash () {
        super("Squash", 50, 100, 5000, 0, 1, 20);
    }


    @Override
    public void attack() {
        System.out.println("Squash attack method called");
    
        boolean attacked = false;
    
        // Get the tiles next to the squash
        Petak leftTile = Map.getFromMatriksPetak(this.getRow(), this.getColumn() - 1);
        Petak rightTile = Map.getFromMatriksPetak(this.getRow(), this.getColumn() + 1);
    
        // If the next tiles exist and have zombies, attack
        if (leftTile != null) {
            for (Zombie z : leftTile.getListZombies()) {
                z.takeDamage(z.getHealth()); // Squash kills the zombies
                System.out.println("Squash menyerang zombie di petak " + z.getRow());
                attacked = true;
            }
        }
    
        if (rightTile != null) {
            for (Zombie z : rightTile.getListZombies()) {
                z.takeDamage(z.getHealth()); // Squash kills the zombies
                System.out.println("Squash menyerang zombie di petak " + z.getRow());
                attacked = true;
            }
        }
    
        if (attacked) {
            this.die();
        }
    }
}

