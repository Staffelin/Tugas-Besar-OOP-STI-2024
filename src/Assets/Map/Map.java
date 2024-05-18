package Map;

import java.util.ArrayList;
import java.util.Random;


import Zombies.*;
import Plants.*;
import Exception.*;

public class Map {
    private static Petak[][] MatriksPetak;
    int wave = 0;
    String[] listSpawnableZombieDarat = {"BucketheadZombie", "ConeheadZombie", "FootballZombie","Gargantuar","NewspaperZombie","NormalZombie","PoleVaultingZombie","Yetizombie"};
    String[] listSpawnableZombieKolam = {"DolphinRiderZombie", "DuckyTubeZombie"};
    public static ArrayList<Zombie> spawnedZombies;
    Random random = new Random();
    private boolean stillPlaying = true;

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

    public boolean getPlayingStatus(){
        return stillPlaying;
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
        if(spawnedZombies.size() < 10){
            for(int i = 0; i < 6; i++){
                if(random.nextDouble() < 0.3 && spawnedZombies.size() < 10){
                    String zombieType;
                    if(i == 2 || i == 3){
                        zombieType = listSpawnableZombieKolam[random.nextInt(listSpawnableZombieKolam.length)];
                    }
                    else{
                        zombieType = listSpawnableZombieDarat[random.nextInt(listSpawnableZombieDarat.length)];
                    }
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
                    } else if(tile instanceof PetakKolam){
                        switch (zombieType) {
                            case "DolphinRiderZombie":
                                newZombie = new DolphinRiderZombie();
                                break;
                            default:
                                newZombie = new DuckyTubeZombie();
                                break;
                        }
                    }
        
                    if (newZombie != null) {
                        newZombie.setRow(i);
                        newZombie.setColumn(10);
                        spawnedZombies.add(newZombie); 
                        spawnSite.addZombie(newZombie);
                        newZombie.setSpawnTime(System.currentTimeMillis());
                        System.out.println(zombieType + " spawned at (" + (i+1) + ", 10)");
                    }
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
                    if (zombie.getDie() == false) {
                        if(petak.getListTanaman().size() == 0){
                            if (System.currentTimeMillis() - zombie.getSpawnTime() >= 5000) {
                                petak.removeZombie(zombie); // Pass the zombie to be removed
                                nextPetak.addZombie(zombie);
                                // System.out.println("Moving zombies...");
                                // System.out.println("Moved zombie from (" + i + ", " + j + ") to (" + i + ", " + (j - 1) + ")");
                                zombie.setRow(i);
                                zombie.setColumn(j - 1);
                                // Update the spawn time
    
                                zombie.setSpawnTime(System.currentTimeMillis());
                            }
                        }
                        else {
                            zombie.attack();
                        }
                        
                    }
                    else {
                        petak.removeZombie(zombie);
                    }
                }
            }
            if(MatriksPetak[i][0].getListZombies().size() > 0){
                stillPlaying = false;
            }
        }
    }


    public void attackPlants() {
        for (int i = 0; i < 6; i++) {
            for(int j = 1; j < 10; j++){
                Petak currTile = getFromMatriksPetak(i, j);
                if(currTile instanceof PetakDarat && currTile.getListTanaman().size() > 0){
                    Plant currPlant = currTile.getListTanaman().get(0);
                        currPlant.attack();
                    
                }
                else if(currTile instanceof PetakKolam && currTile.getListTanaman().size() > 2){
                    Plant currPlant = currTile.getListTanaman().get(1);
                    if(currPlant != null){
                        currPlant.attack();
                    }
                }
            }
        }
    }
        
    public void viewMap() {
        String green = "\033[32m"; // Kode warna hijau
        String blue = "\033[34m"; // Kode warna biru
        String reset = "\033[0m";  // Reset warna
        for (int i = 0; i < MatriksPetak.length; i++) {
            for (int j = 0; j < MatriksPetak[i].length; j++) {
                Petak currentTile = MatriksPetak[i][j];
                String tileRepresentation = currentTile instanceof PetakKolam ? 
                blue + "{      }" + reset: 
                green + "[      ]" + reset;
                int zombieCount = currentTile.getJumlahZombie();
                // Cek jika ada tanaman dan zombie di petak yang sama
                if ((currentTile.getListTanaman().size() == 1  && zombieCount > 0) || currentTile.getListTanaman().size() == 2  && zombieCount > 0) {
                // Menampilkan simbol tanaman dan jumlah zombie
                    if (currentTile.getListTanaman().get(0) instanceof Peashooter) {
                        System.out.print(green + "[" + reset + "P Z("+zombieCount+")" + green + "]" + reset  + " ");
                    }
                    else if (currentTile.getListTanaman().get(0) instanceof Sunflower) {
                        System.out.print(green + "[" + reset + "S Z("+zombieCount+")" + green + "]" + reset  + " ");
                    }
                    else if (currentTile.getListTanaman().get(0) instanceof PotatoMine) {
                        System.out.print(green + "[" + reset + "M Z("+zombieCount+")" + green + "]" + reset  + " ");
                    }
                    else if (currentTile.getListTanaman().get(0) instanceof Repeater) {
                        System.out.print(green + "[" + reset + "R Z("+zombieCount+")" + green + "]" + reset  + " ");
                    }
                    else if (currentTile.getListTanaman().get(0) instanceof Squash) {
                        System.out.print(green + "[" + reset + "Q Z("+zombieCount+")" + green + "]" + reset  + " ");
                    }
                    else if (currentTile.getListTanaman().get(0) instanceof Jalapeno) {
                        System.out.print(green + "[" + reset + "J Z("+zombieCount+")" + green + "]" + reset  + " ");
                    }
                    else if (currentTile.getListTanaman().get(0) instanceof Lilypad) {
                        System.out.print(green + "[" + reset + "L Z("+zombieCount+")" + green + "]" + reset  + " ");
                    }
                    else if (currentTile.getListTanaman().get(0) instanceof SnowPea) {
                        System.out.print(green + "[" + reset + "O Z("+zombieCount+")" + green + "]" + reset  + " ");
                    }
                    else if (currentTile.getListTanaman().get(0) instanceof Tallnut) {
                        System.out.print(green + "[" + reset + "T Z("+zombieCount+")" + green + "]" + reset  + " ");
                    }
                    else if (currentTile.getListTanaman().get(0) instanceof Wallnut) {
                        System.out.print(green + "[" + reset + "N Z("+zombieCount+")" + green + "]" + reset  + " ");
                    }
                }
                else if (currentTile.getListTanaman().size() == 0 && zombieCount > 0) {
                    if (!currentTile.isAquatic() || j == 10) {
                        System.out.print(green + "[ " + reset + "Z("+zombieCount+")" + green + " ]" + reset  + " ");
                        for(Zombie z : currentTile.getListZombies()){
                            z.checkEffect();
                        }
                    }
                    else if (currentTile.isAquatic()) {
                        System.out.print(blue + "{ " + reset + "Z("+zombieCount+")" + blue + " }" + reset  + " ");
                        for(Zombie z : currentTile.getListZombies()){
                            z.checkEffect();
                    }
                    }
                } else if (currentTile.getListTanaman().size() == 1) {
                    if(currentTile.getListTanaman().get(0).getHealth() <= 0 || currentTile.getListTanaman().get(0).getPlantDie() == true){
                        try{
                            currentTile.removeTanaman();
                            System.out.print(tileRepresentation + " ");
                        }
                        catch(NoPlantException e){
                            System.out.println("Emang gaada tanaman" + e.getMessage());
                        
                        }
                    }
                    else{
                        if (currentTile.getListTanaman().get(0) instanceof Peashooter) {
                            System.out.print(green + "[ " + reset + "  P " + green + " ]" + reset  + " ");
                        }
                        else if (currentTile.getListTanaman().get(0) instanceof Sunflower) {
                            System.out.print(green + "[ " + reset + "  S " + green + " ]" + reset  + " ");
                        }
                        else if (currentTile.getListTanaman().get(0) instanceof PotatoMine) {
                            System.out.print(green + "[ " + reset + "  M " + green + " ]" + reset  + " ");
                        }
                        else if (currentTile.getListTanaman().get(0) instanceof Repeater) {
                            System.out.print(green + "[ " + reset + "  R " + green + " ]" + reset  + " ");
                        }
                        else if (currentTile.getListTanaman().get(0) instanceof Squash) {
                            System.out.print(green + "[ " + reset + "  Q " + green + " ]" + reset  + " ");
                        }
                        else if (currentTile.getListTanaman().get(0) instanceof Jalapeno) {
                            System.out.print(green + "[ " + reset + "  J " + green + " ]" + reset  + " ");
                        }
                        else if (currentTile.getListTanaman().get(0) instanceof Lilypad) {
                            System.out.print(blue + "{ " + reset + "  L " + blue + " }" + reset  + " ");
                        }
                        else if (currentTile.getListTanaman().get(0) instanceof SnowPea) {
                            System.out.print(green + "[ " + reset + "  O " + green + " ]" + reset  + " ");
                        }
                        else if (currentTile.getListTanaman().get(0) instanceof Tallnut) {
                            System.out.print(green + "[ " + reset + "  T " + green + " ]" + reset  + " ");
                        }
                        else if (currentTile.getListTanaman().get(0) instanceof Wallnut) {
                            System.out.print(green + "[ " + reset + "  N " + green + " ]" + reset  + " ");
                        }
                    }
                    
                } else if (currentTile.getListTanaman().size() == 2 && currentTile.getListTanaman().get(0) instanceof Lilypad)  {
                    if (currentTile.getListTanaman().get(1) instanceof Peashooter) {
                        System.out.print(blue + "{ " + reset + "  P " + blue + " }" + reset  + " ");
                    }
                    else if (currentTile.getListTanaman().get(1) instanceof Sunflower) {
                        System.out.print(blue + "{ " + reset + "  S " + blue + " }" + reset  + " ");
                    }
                    else if (currentTile.getListTanaman().get(1) instanceof PotatoMine) {
                        System.out.print(blue + "{ " + reset + "  M " + blue + " }" + reset  + " ");
                    }
                    else if (currentTile.getListTanaman().get(1) instanceof Repeater) {
                        System.out.print(blue + "{ " + reset + "  R " + blue + " }" + reset  + " ");
                    }
                    else if (currentTile.getListTanaman().get(1) instanceof Squash) {
                        System.out.print(blue + "{ " + reset + "  Q " + blue + " }" + reset  + " ");
                    }
                    else if (currentTile.getListTanaman().get(1) instanceof Jalapeno) {
                        System.out.print(blue + "{ " + reset + "  J " + blue + " }" + reset  + " ");
                    }
                    else if (currentTile.getListTanaman().get(0) instanceof Lilypad) {
                        System.out.print(blue + "{ " + reset + "  L " + blue + " }" + reset  + " ");
                    }
                    else if (currentTile.getListTanaman().get(0) instanceof SnowPea) {
                        System.out.print(blue + "{ " + reset + "  O " + blue + " }" + reset  + " ");
                    }
                    else if (currentTile.getListTanaman().get(0) instanceof Tallnut) {
                        System.out.print(blue + "{ " + reset + "  T " + blue + " }" + reset  + " ");
                    }
                    else if (currentTile.getListTanaman().get(0) instanceof Wallnut) {
                        System.out.print(blue + "{ " + reset + "  N " + blue + " }" + reset  + " ");
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
        Petak tile = MatriksPetak[row-1][column];
        try {
            tile.tanamTanaman(plant);
            System.out.println(plant.getName() + " berhasil ditanam di (" + (row) + ", " + column + ")"); 
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