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
    public void attack() {
        if (getCooldown() > 0) {
            setCooldown(getCooldown() - 1);
            return;
        }
        ArrayList<Petak> tileRow = new ArrayList<>();
        int currentRow = this.getRow();
        for (Petak[] row : Map.getMatriksPetak()) {
            tileRow.add(row[currentRow]);
        }
        for (int i = currentRow; i < tileRow.size(); i++) {
            if (tileRow.get(i).getJumlahZombie() > 0) {
                System.out.println("Ada zombie");
                for (Zombie z : tileRow.get(i).getListZombies()) {
                    z.takeDamage(attack_damage);
                }
                setCooldown(getAttackSpeed());
                return;   
            }
        }
    }


}
