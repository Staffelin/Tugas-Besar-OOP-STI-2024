package Plants;

import java.util.ArrayList;
import java.util.Arrays;

import Map.*;
import Zombies.Zombie;

public class Repeater extends Plant {
    public Repeater () {
        super("Repeater", 200, 100, 75, 4, -1, 10);
    }
    
    @Override
    public void attack() {
         if (getCooldown() > 0) {
            setCooldown(getCooldown() - 1);
            return;
        }
        System.out.println("Repeater attack  " + getAttackDamage());  
        int currentRow = this.getRow();
        Petak[] row = Map.getMatriksPetak()[currentRow];
        ArrayList<Petak> tileRow = new ArrayList<>(Arrays.asList(row));

        for (int i = this.getColumn(); i < tileRow.size(); i++) {
            if (tileRow.get(i).getJumlahZombie() > 0) {
                System.out.println("Ada zombie!! Repeater dikerahkannnnn");
                for (Zombie z : tileRow.get(i).getListZombies()) {
                    z.takeDamage(attack_damage);
                }
                setCooldown(getAttackSpeed());
                return;   
            }
        }

    }
}
