package Plants;

import Map.*;
import Zombies.*;

// import Map.*;
// import Zombies.Zombie;


public class PotatoMine extends Plant {
    public PotatoMine () {
        super("Potato Mine", 25, 100, 5000, 0, 3, 20);
    }

    public void attack() {
        System.out.println("Potato mine attack method called");
    
        boolean attacked = false;
    
        // Get the tiles next to the squash
        Petak rightTile = Map.getFromMatriksPetak(this.getRow(), this.getColumn() + 1);
    
        // If the next tiles exist and have zombies, attack
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

