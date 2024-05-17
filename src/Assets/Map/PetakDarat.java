package Map;

import Plants.Plant;
import Zombies.Zombie;

public class PetakDarat<T extends Plant, U extends Zombie> extends Petak<T, U> {
    public PetakDarat(int row, int column) {
        super(row, column, false);
    }
}
