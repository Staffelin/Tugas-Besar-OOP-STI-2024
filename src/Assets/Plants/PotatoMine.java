package Plants;

import java.util.ArrayList;

import Map.Petak;
import Zombies.Zombie;

public class PotatoMine extends Plant {
    public PotatoMine () {
        super("Potato Mine", 75, 100, 5000, 0, 3, 20);
    }

    @Override
    public void attack(ArrayList<Zombie> zombies, Petak tile) {
        int mineRow = tile.getRow();
        int mineColumn = tile.getColumn();
    
        for (Zombie zombie : zombies) {
            if (zombie.getRow() == mineRow && zombie.getColumn() == mineColumn + 1) {
                zombie.takeDamage(zombie.getHealth());
            }
        }
    }
}
}
