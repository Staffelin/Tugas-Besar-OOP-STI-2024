package Plants;

import java.util.ArrayList;
import java.util.Iterator;

import Map.*;
import Zombies.Zombie;

public class Squash extends Plant{
    private static boolean isWaiting;
    public Squash () {
        super("Squash", 50, 100, 5000, 0, 1, 20);
    }

    public static void setWaiting(boolean booleanValue) {
        isWaiting = booleanValue;
    }
    public static boolean getWaiting() {
        return isWaiting;
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
        this.die();
        isWaiting = false; 
    }
}

