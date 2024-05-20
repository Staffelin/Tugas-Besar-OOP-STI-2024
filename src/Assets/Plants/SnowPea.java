package Plants;
import Map.*;
import Zombies.*;

public class SnowPea extends Plant {
    public SnowPea () {
        super("SNOW PEA", 175, 100, 25, 4, -1, 10);
    }

    @Override
    public void attack(){
        if (getCooldown() > 0) {
            setCooldown(getCooldown() - 1);
            return;
        }
        boolean attacked = false;
            for(int i = column; i < 10; i++){
                if(attacked == false){
                    Petak tile = Map.getFromMatriksPetak(row, i);
                    if(tile.getListZombies().size() > 0){
                        for(Zombie z : tile.getListZombies()){
                            z.takeDamage(attack_damage);
                            z.setEffectTime();
                            System.out.println("Snow Pea attacking " + z.getName() + " at (" + row + ", " + i + ")");
                        }
                        attacked = true;
                        break;
                    }
                }
            }
        setLastAttackTime();
    }
}

 

