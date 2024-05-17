package Map;

import Plants.*;
import Zombies.*;

public class PetakKolam<T extends Plant, U extends Zombie> extends Petak<T, U> {
    public PetakKolam(int row, int column) {
        super(row, column, true);
    }
}