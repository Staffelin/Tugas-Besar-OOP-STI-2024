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
        Petak thisTile = Map.getFromMatriksPetak(this.getRow(), this.getColumn());
        // If the next tiles exist and have zombies, attack
        if(thisTile.getJumlahZombie() > 0){
            for(Zombie z : thisTile.getListZombies()){
                z.takeDamage(attack_damage);
                System.out.println("Potato Mine menyerang zombie di petak " + z.getRow());
            }
            attacked = true;
        }
        if (rightTile != null && rightTile.getJumlahZombie() > 0){
            for (Zombie z : rightTile.getListZombies()) {
                z.takeDamage(z.getHealth()); // Squash kills the zombies
                System.out.println("PotatoMine menyerang zombie di petak " + z.getRow());
            }
            attacked = true;
        }
    
        if (attacked) {
            this.die();
        }
    }
}

