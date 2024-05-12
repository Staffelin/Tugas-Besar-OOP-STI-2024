package Plants;
import Zombies.*;
import Map.*;

import java.util.ArrayList;

public class Jalapeno extends Plant {
    public Jalapeno () {
        super("Jalapeno", 125, 100, 5000, 0, 2, 25);
        
        
    
    }

    @Override
    public void attack(ArrayList<Zombie> zombies) {
    
        // for (Zombie zombie : zombies) {
        //     if (zombie.getPositionRow() == jalapenoRow) {
        //         zombie.takeDamage(this.getAttackDamage());
        //     }
        // }
    }
}
