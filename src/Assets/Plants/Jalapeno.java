package Plants;
import Zombies.*;
import Map.*;

//import java.time.LocalDateTime;

//import java.util.Iterator;



public class Jalapeno extends Plant {
    public Jalapeno () {
        super("Jalapeno", 125, 100, 5000, 0, -1, 25);
    }

    @Override
    public void attack() {
        if (getCooldown() > 0) {
            setCooldown(getCooldown() - 1);
            return;
        }
        for(int i = 0; i < 10; i++){
            Petak tile = Map.getFromMatriksPetak(row, i);
            if(tile.getListZombies().size() > 0){
                for(Zombie z : tile.getListZombies()){
                    z.takeDamage(attack_damage);
                }
            }
        
        }
        
        this.die();
    }
}



