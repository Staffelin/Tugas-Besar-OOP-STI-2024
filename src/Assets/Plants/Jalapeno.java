package Plants;
import Zombies.*;
import Map.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;



public class Jalapeno extends Plant {
    public Jalapeno () {
        super("Jalapeno", 125, 100, 5000, 0, -1, 25);
        
        
    
    }

    @Override
    public void attack(ArrayList<Zombie> zombies) {
        System.out.println("Jalapeno attack method called");
            Iterator<Zombie> iterator = zombies.iterator();
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
