package Plants;

// import Zombies.Zombie;



// import Map.*;


public class Peashooter extends Plant {

    public Peashooter () {
        super("Peashooter", 100, 100, 25, 4, -1, 10);
    }

    // @Override
    // public void attack() {
    //     if (getCooldown() > 0) {
    //         setCooldown(getCooldown() - 1);
    //         return;
    //     }
    //     boolean attacked = false;
    //     while(!attacked){
    //         for(int i = column; i < 10; i++){
    //             Petak tile = Map.getFromMatriksPetak(row, i);
    //             if(tile.getListZombies().size() > 0){
    //                 for(Zombie z : tile.getListZombies()){
    //                     z.takeDamage(attack_damage);
    //                     System.out.println("Tanaman " + getName() + " Menyerang " + z.getName() + " di " + "(" + tile.getRow() + ", " + tile.getColumn() + ")");
    //                 }
    //                 attacked = true;
    //                 break;
    //             }

    //         }
    //     }
    //}



}

