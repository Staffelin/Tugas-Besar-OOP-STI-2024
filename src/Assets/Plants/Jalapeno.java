package Plants;
import Zombies.*;

import java.util.ArrayList;
import java.util.Iterator;

import Map.*;

//import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.Arrays;
//import java.util.Iterator;



public class Jalapeno extends Plant {
    public Jalapeno () {
        super("Jalapeno", 125, 100, 5000, 0, -1, 25);
    }

    @Override
    public void attack() {
           ArrayList<Zombie> zombiesInRow = new ArrayList<>();
            for (int i = this.column; i < Map.getMatriksPetak()[this.row].length; i++) {
                Petak tile = Map.getFromMatriksPetak(this.row, i);
                if (tile != null) {
                    System.out.println("Tile at row " + this.row + ", column " + i + " has " + tile.getListZombies().size() + " zombies");
                        zombiesInRow.addAll(tile.getListZombies());
                }
            }
            System.out.println("Zombies in row: " + zombiesInRow.size());

            Iterator<Zombie> iterator = zombiesInRow.iterator();
            while (iterator.hasNext()) {
                Zombie z = iterator.next();
                if (this.getRow() == z.getRow()) {
                    z.takeDamage(attack_damage);
                    System.out.println("Jalapeno menyerang zombie di petak " + z.getRow());
                    if (z.getHealth() <= 0) {
                        iterator.remove();
                        System.out.println("Zombie di petak " + z.getRow() + " mati");
                    }
                }
            }
            this.die();
        }
                    
    }




