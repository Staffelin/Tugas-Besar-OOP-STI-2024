package Map;

import java.util.ArrayList;
import java.util.Random;
import Zombies.*;

public class Map {
    private Petak[][] MatriksPetak;
    int wave;
    ArrayList<Zombie> listZombieMap;
    Random random = new Random();

    public Map() {
        // Initialize the matrix with the specified dimensions
        MatriksPetak = new Petak[6][11];
    
        // Assign protected area and zombie spawn columns
        for (int i = 0; i < 6; i++) {
            MatriksPetak[i][0] = new ProtectedArea(i, 0);  // Protected area at the first column
            MatriksPetak[i][10] = new ZombieSpawn(i, 10);  // Zombie spawn at the last column
        }
    
        // Populate the map with PetakKolam and PetakDarat
        for (int i = 0; i < 6; i++) {  // Loop through rows
            for (int j = 1; j < 10; j++) { // Loop through columns, excluding first and last
                if (i == 2 || i == 3) { // 3rd and 4th rows (indexed by 2 and 3)
                    MatriksPetak[i][j] = new PetakKolam(i, j); // Assign PetakKolam
                } else {
                    MatriksPetak[i][j] = new PetakDarat(i, j); // Assign PetakDarat
                }
            }
        }
    }
    
    

    public void resetMap(){
        for (int i = 0; i < MatriksPetak.length; i++) {
            for (int j = 0; j < MatriksPetak[i].length; j++) {
                MatriksPetak[i][j].getListTanaman().clear();
                MatriksPetak[i][j].getListZombies().clear();
            }
        }
    }

    public void spawnZombieMap() {
        int lastColumn = MatriksPetak[0].length - 1;
        for (int i = 0; i < MatriksPetak.length; i++) {
            Petak tile = MatriksPetak[i][lastColumn];
            if ((tile instanceof PetakKolam || tile instanceof PetakDarat) && random.nextDouble() < 0.3) {
                Zombie newZombie = new Zombie("Z", 100, 100, 10, 5, false);
                tile.addZombie(newZombie);
                System.out.println("Spawned a zombie at (" + i + ", " + lastColumn + ")");
            }
        }
    }

    public void viewMap() {
        for (int i = 0; i < MatriksPetak.length; i++) {
            for (int j = 0; j < MatriksPetak[i].length; j++) {
                Petak currentTile = MatriksPetak[i][j];
                String tileRepresentation = currentTile instanceof PetakKolam ? "{}" : "[]";
                int zombieCount = currentTile.getJumlahZombie();
                if (zombieCount > 0) {
                    System.out.print(tileRepresentation.charAt(0) + "Z" + zombieCount + tileRepresentation.charAt(1) + " ");
                } else {
                    System.out.print(tileRepresentation + " ");
                }
            }
            System.out.println();
        }
    }

    
}
