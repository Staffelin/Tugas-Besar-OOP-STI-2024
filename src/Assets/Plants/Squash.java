package Plants;

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

    public void attack() {
        if (getCooldown() > 0) {
            setCooldown(getCooldown() - 1);
            return;
        }
        for(int i = this.row; i < this.row+3; i++){
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
