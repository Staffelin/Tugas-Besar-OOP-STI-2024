package Plants;

import java.util.ArrayList;

import Map.Petak;
import Zombies.Zombie;

public class Squash extends Plant{
    public Squash () {
        super("Squash", 50, 100, 5000, 0, 1, 20);
    }

    // @Override
    // public void attack(ArrayList<Zombie> zombies, Petak tile) {
    //     int squashRow = tile.getRow();
    //     int squashColumn = tile.getColumn();
    
    //     for (Zombie zombie : zombies) {
    //         if (zombie.getRow() == squashRow && zombie.getColumn() == squashColumn + 1) {
    //             zombie.takeDamage(zombie.getHealth());
    //         }
    //     }
    // }
}
