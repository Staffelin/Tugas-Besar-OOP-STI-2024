package Map;

import java.util.ArrayList;
import java.util.Random;


import Zombies.*;
import Plants.*;
import Exception.*;

public class Map {
    private static Petak[][] MatriksPetak;
    int wave = 0;
    String[] listSpawnableZombie = {"BucketheadZombie", "ConeheadZombie", "DolphinRiderZombie", "DuckyTubeZombie","FootballZombie","Gargantuar","NewspaperZombie","NormalZombie","PoleVaultingZombie","Yetizombie"};
    public static ArrayList<Zombie> spawnedZombies;
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

    // Get the matriksPetak array
    public static Petak[][] getMatriksPetak() {
        return MatriksPetak;
    }

    // Get a specific Petak from the matriksPetak array
    public static Petak getFromMatriksPetak(int row, int column) {
        if (row >= 0 && row < MatriksPetak.length && column >= 0 && column < MatriksPetak[0].length) {
            return MatriksPetak[row][column];
        } else {
            return null;
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
        if (spawnedZombies == null) {
            spawnedZombies = new ArrayList<>();
        }
    
        for(int i = 0; i < 6; i++){
            if(random.nextDouble() < 0.3 && spawnedZombies.size() < 10){
                String zombieType;
                zombieType = listSpawnableZombie[random.nextInt(listSpawnableZombie.length)];
                Petak tile = MatriksPetak[i][9];
                Petak spawnSite = MatriksPetak[i][10];
                Zombie newZombie = null;
    
                if(tile instanceof PetakDarat){
                    switch (zombieType) {
                        case "BucketheadZombie":
                            newZombie = new BucketheadZombie();
                            break;
                        case "ConeheadZombie":
                            newZombie = new ConeheadZombie();
                            break;
                        case "FootballZombie":
                            newZombie = new FootballZombie();
                            break;
                        case "Gargantuar":
                            newZombie = new Gargantuar();
                            break;
                        case "NewspaperZombie":
                            newZombie = new NewspaperZombie();
                            break;
                        case "PoleVaultingZombie":
                            newZombie = new PoleVaultingZombie();
                            break;
                        case "Yetizombie":
                            newZombie = new YetiZombie();
                            break;
                        default:
                            newZombie = new NormalZombie();
                            break;
                    }
                } else {
                    switch (zombieType) {
                        case "DolphinRiderZombie":
                            newZombie = new DolphinRiderZombie();
                            break;
                        case "DuckyTubeZombie":
                            newZombie = new DuckyTubeZombie();
                            break;
                    }
                }
    
                if (newZombie != null) {
                    newZombie.setRow(i);
                    spawnedZombies.add(newZombie); 
                    spawnSite.addZombie(newZombie);
                    newZombie.setSpawnTime(System.currentTimeMillis());
                }
            }
        }
    }

    public void moveZombies() {    
        for (int i = 0; i < MatriksPetak.length; i++) {
            for (int j = MatriksPetak[i].length - 1; j > 0; j--) {
                Petak petak = MatriksPetak[i][j];
                Petak nextPetak = MatriksPetak[i][j - 1];
                ArrayList<Zombie> zombies = new ArrayList<>(petak.getListZombies()); // Create a copy of the list
                for (Zombie zombie : zombies) {
                    // Check if 5 seconds have passed since the zombie was spawned
                    if (System.currentTimeMillis() - zombie.getSpawnTime() >= 5000) {
                        // Move the zombie from the current tile to the next tile
                        petak.removeZombie(zombie); // Pass the zombie to be removed
                        nextPetak.addZombie(zombie);
                        // System.out.println("Moved zombie from (" + i + ", " + j + ") to (" + i + ", " + (j - 1) + ")");
                        // Update the zombie's position
                        // Update the spawn time
                        zombie.setSpawnTime(System.currentTimeMillis());
                    }
                }
            }
        }
    }


    public void attackZombies() {
        for (int i = 0; i < MatriksPetak.length; i++) {
            for (int j = 1; j < MatriksPetak[i].length; j++) {
                Petak petak = MatriksPetak[i][j];
                for(int x = j; x<11; x++){
                    Petak enemyTile = MatriksPetak[i][x];
                    petak.attackTile(enemyTile);
                }
            }
        }
    }
        
    public void viewMap() {
        for (int i = 0; i < MatriksPetak.length; i++) {
            for (int j = 0; j < MatriksPetak[i].length; j++) {
                Petak currentTile = MatriksPetak[i][j];
                String tileRepresentation;
                if (currentTile instanceof ProtectedArea) {
                    tileRepresentation = "\u001B[93m{ }\u001B[0m"; // Creme color
                } else if (currentTile instanceof ZombieSpawn) {
                    tileRepresentation = "\u001B[90m[ ]\u001B[0m"; // Gray color
                } else {
                    tileRepresentation = currentTile instanceof PetakKolam ? "\u001B[34m{ }\u001B[0m" : "\u001B[32m[ ]\u001B[0m";
                }
                int zombieCount = currentTile.getJumlahZombie();
                if (zombieCount > 0) {
                    System.out.print(tileRepresentation.charAt(0) + "Z]" + zombieCount + tileRepresentation.charAt(1) + " ");
                } else if (currentTile.getListTanaman().size() == 1) {
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
                } else if (currentTile.getListTanaman().size() == 2) {
                    if (currentTile.getListTanaman().get(1) instanceof Peashooter) {
                        System.out.print(tileRepresentation.charAt(0) + "P}" + tileRepresentation.charAt(1));
                    }
                    else if (currentTile.getListTanaman().get(1) instanceof Sunflower) {
                        System.out.print(tileRepresentation.charAt(0) + "S}" + tileRepresentation.charAt(1));
                    }
                    else if (currentTile.getListTanaman().get(1) instanceof PotatoMine) {
                        // Handle the case when there is a second plant
                    }
                } else {
                    System.out.print(tileRepresentation + " ");
                }
            }
            System.out.println();
        }
        for(int x = 0; x < 22; x++){
            System.out.print("==");
        }
        System.out.println();
    }
    public void addPlantToTile(int row, int column, Plant plant) {
        Petak tile = MatriksPetak[row][column];
        try {
            tile.tanamTanaman(plant);
            System.out.println(plant.getName() + " berhasil ditanam di (" + (row+1) + ", " + column + ")"); 
        } catch (CannotAddPlantException e) {
    
            System.out.println("Cannot add plant to tile: " + e.getMessage());
        } 
        catch (PlantLilypadFirstException e) {
            System.out.println("Cannot add plant to tile: " + e.getMessage());
        }
        catch (LilypadOnLandException e) {
            System.out.println("Cannot add plant to tile: " + e.getMessage());
        }
        catch (OnlyOnePlantException e) {
            System.out.println("Cannot add plant to tile: " + e.getMessage());
        }
        catch (TwoPlantOnWaterException e) {
            System.out.println("Cannot add plant to tile: " + e.getMessage());
        }
        catch (SunNotEnoughException e) {
            System.out.println("Cannot add plant to tile: " + e.getMessage());
        }
    }

    public void removePlantFromTile(int row, int column) {
        Petak tile = MatriksPetak[row][column];
        try {
            tile.removeTanaman();
            System.out.println("Tanaman di (" + (row+1) + ", " + column + ") berhasil dihapus");
        } catch (NoPlantException e) {
            System.out.println("Cannot remove plant from tile: " + e.getMessage());
        }
    }
    
}
