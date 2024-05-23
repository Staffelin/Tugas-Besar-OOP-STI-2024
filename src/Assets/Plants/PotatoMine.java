package Plants;

import java.util.ArrayList;
import java.util.List;

import Map.*;
import Zombies.*;

// import Map.*;
// import Zombies.Zombie;


public class PotatoMine extends Plant {
    public PotatoMine () {
        super("POTATO MINE", 25, 100, 5000, 0, 1, 20);
    }

   @Override
    public void attack() {
        boolean attacked = false;

        // Get the tiles next to the squash
        Petak rightTile = Map.getFromMatriksPetak(this.getRow(), this.getColumn() + 1);
        Petak currentTile = Map.getFromMatriksPetak(this.getRow(), this.getColumn());

        // If the next tiles exist and have zombies, attack

        if (currentTile != null) {
            List<Zombie> currentZombies = new ArrayList<>(currentTile.getListZombies());
            for (Zombie z : currentZombies) {
                z.takeDamage(this.attack_damage); 
                System.out.println("POTATO MINE MENYERANG ZOMBIE DI PETAK ASAL, DI " + z.getRow());
                attacked = true;
            }
        }

        if (rightTile != null) {
                List<Zombie> rightZombies = new ArrayList<>(rightTile.getListZombies());
                for (Zombie z : rightZombies) {
                    z.takeDamage(this.attack_damage); 
                    System.out.println("POTATO MINE MENYERANG ZOMBIE DI PETAK KANANNYA, DI " + z.getRow());
                    attacked = true;
                }
            }

        if (attacked) {
            this.die();
        }
    }
}

