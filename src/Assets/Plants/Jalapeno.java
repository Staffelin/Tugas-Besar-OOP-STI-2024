package Plants;
import Zombies.*;
import Map.*;

//import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
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
        System.out.println("Jalapeno attack  " + getAttackDamage());  
        int currentRow = this.getRow();
        Petak[] row = Map.getMatriksPetak()[currentRow];
        ArrayList<Petak> tileRow = new ArrayList<>(Arrays.asList(row));

        for (int i = this.getColumn(); i < tileRow.size(); i++) {
            if (tileRow.get(i).getJumlahZombie() > 0) {
                System.out.println("Ada zombie, Jalapenoo gaskeunn");
                for (Zombie z : tileRow.get(i).getListZombies()) {
                    z.takeDamage(attack_damage);
                }
                this.die();
                return;   
            }
        }
    }
}



