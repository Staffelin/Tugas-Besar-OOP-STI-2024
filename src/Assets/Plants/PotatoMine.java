package Plants;

import Map.*;
import Zombies.Zombie;

public class PotatoMine extends Plant {
    public PotatoMine () {
        super("Potato Mine", 75, 100, 5000, 0, 3, 20);
    }

    @Override
    public void attack() {
        if (getCooldown() > 0) {
            setCooldown(getCooldown() - 1);
            return;
        }
        Petak tile = Map.getFromMatriksPetak(row, column);
        if(tile.getListZombies().size() > 0){
            for(Zombie z : tile.getListZombies()){
                z.takeDamage(attack_damage);
            }
        }
        
        this.die();
    }
}

