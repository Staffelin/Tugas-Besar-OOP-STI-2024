package Map;

import java.util.ArrayList;
import java.util.Random;
import Zombies.*;
import Plants.*;

public class Map {
    private Petak[][] MatriksPetak;
    int wave = 0;
    String[] listSpawnableZombie = {"BucketHead"};
    ArrayList<Zombie> spawnedZombies;
    Random random = new Random();

    public Map() {
        MatriksPetak = new Petak[6][11];
        for (int i = 0; i < 6; i++) {
            MatriksPetak[i][0] = new ProtectedArea(i, 0);
            MatriksPetak[i][10] = new ZombieSpawn(i, 10);
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 1; j < 10; j++) {
                if (i == 2 || i == 3) {
                    MatriksPetak[i][j] = new PetakKolam(i, j);
                } else {
                    MatriksPetak[i][j] = new PetakDarat(i, j);
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
        for(int i = 0; i < 6; i++){
            if(random.nextDouble() < 0.3){
                Zombie newZombie = new Zombie(listSpawnableZombie[random.nextInt(listSpawnableZombie.length)], 100, 100, 10, 5, false);
                spawnedZombies.add(newZombie);
            }
        }
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
                String tileRepresentation = currentTile instanceof PetakKolam ? "{ }" : "[ ]";
                int zombieCount = currentTile.getJumlahZombie();
                if (zombieCount > 0) {
                    System.out.print(tileRepresentation.charAt(0) + "[Z]" + zombieCount + tileRepresentation.charAt(1) + " ");
                } else if (currentTile.getListTanaman().size() > 0) {
                    if (currentTile.getListTanaman().get(0) instanceof Peashooter) {
                        System.out.print(tileRepresentation.charAt(0) + "P]" + tileRepresentation.charAt(1));
                    }
                    else if (currentTile.getListTanaman().get(0) instanceof Sunflower) {
                        System.out.print(tileRepresentation.charAt(0) + "S]" + tileRepresentation.charAt(1));
                    }
                    else if (currentTile.getListTanaman().get(0) instanceof PotatoMine) {
                        System.out.print(tileRepresentation.charAt(0) + "M]" + tileRepresentation.charAt(1));
                    }
                    else if (currentTile.getListTanaman().get(0) instanceof Repeater) {
                        System.out.print(tileRepresentation.charAt(0) + "R]" + tileRepresentation.charAt(1));
                    }
                    else if (currentTile.getListTanaman().get(0) instanceof Squash) {
                        System.out.print(tileRepresentation.charAt(0) + "Q]" + tileRepresentation.charAt(1));
                    }
                    else if (currentTile.getListTanaman().get(0) instanceof SnowPea) {
                        System.out.print(tileRepresentation.charAt(0) + "N]" + tileRepresentation.charAt(1));
                    }
                    else if (currentTile.getListTanaman().get(0) instanceof Tallnut) {
                        System.out.print(tileRepresentation.charAt(0) + "T]" + tileRepresentation.charAt(1));
                    }
                    else if (currentTile.getListTanaman().get(0) instanceof Jalapeno) {
                        System.out.print(tileRepresentation.charAt(0) + "J]" + tileRepresentation.charAt(1));
                    }
                    else if (currentTile.getListTanaman().get(0) instanceof Lilypad) {
                        System.out.print(tileRepresentation.charAt(0) + "L}" + tileRepresentation.charAt(1));
                    }
                    else if (currentTile.getListTanaman().get(0) instanceof Wallnut) {
                        System.out.print(tileRepresentation.charAt(0) + "W]" + tileRepresentation.charAt(1));
                    }
                } else {
                    System.out.print(tileRepresentation + " ");
                }
            }
            System.out.println();
        }
    }

    public void addPlantToTile(int row, int column, Plant plant) {
        Petak tile = MatriksPetak[row][column];
        tile.tanamTanaman(plant);
    }
    
}
