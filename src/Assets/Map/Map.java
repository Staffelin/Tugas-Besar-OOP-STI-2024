package Map;

import java.util.ArrayList;
import java.util.Random;
import Zombies.*;
import Plants.*;
import Exception.*;

public class Map {
    private Petak[][] MatriksPetak;
    int wave = 0;
    String[] listSpawnableZombie = {"BucketheadZombie", "ConeheadZombie", "DolphinRiderZombie", "DuckyTubeZombie","FootballZombie","Gargantuar","NewspaperZombie","NormalZombie","PoleVaultingZombie","Yetizombie"};
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
        spawnedZombies = new ArrayList<>(); 
    
        for(int i = 0; i < 6; i++){
            if(random.nextDouble() < 0.3){
                String zombieType;
                zombieType = listSpawnableZombie[random.nextInt(listSpawnableZombie.length)];
                Petak tile = MatriksPetak[i][9];
                
                if(MatriksPetak[i][9] instanceof PetakDarat){
                    if(zombieType == "BucketheadZombie"){
                        BucketheadZombie newZombie = new BucketheadZombie();
                        spawnedZombies.add(newZombie); 
                        tile.addZombie(newZombie);
                    }
                    else if(zombieType == "ConeheadZombie"){
                        ConeheadZombie newZombie = new ConeheadZombie();
                        spawnedZombies.add(newZombie); 
                        tile.addZombie(newZombie);
                    }
                    else if(zombieType == "FootballZombie"){
                        FootballZombie newZombie = new FootballZombie();
                        spawnedZombies.add(newZombie);
                        tile.addZombie(newZombie);
                    }
                    else if(zombieType == "Gargantuar"){
                        Gargantuar newZombie = new Gargantuar();
                        spawnedZombies.add(newZombie);
                        tile.addZombie(newZombie);
                    }
                    else if(zombieType == "NewspaperZombie"){
                        NewspaperZombie newZombie = new NewspaperZombie();
                        spawnedZombies.add(newZombie);
                        tile.addZombie(newZombie);
                    }
                    else if(zombieType == "PoleVaultingZombie"){
                        PoleVaultingZombie newZombie = new PoleVaultingZombie();
                        spawnedZombies.add(newZombie);
                        tile.addZombie(newZombie);
                    }
                    else if(zombieType == "Yetizombie"){
                        YetiZombie newZombie = new YetiZombie();
                        spawnedZombies.add(newZombie);
                        tile.addZombie(newZombie);
                    }
                    else{
                        NormalZombie newZombie = new NormalZombie();
                        spawnedZombies.add(newZombie); 
                        tile.addZombie(newZombie);
                    }
                }
                else{
                    if(zombieType == "DolphinRiderZombie"){
                        DolphinRiderZombie newZombie = new DolphinRiderZombie();
                        spawnedZombies.add(newZombie); 
                        tile.addZombie(newZombie);
                    }
                    else if(zombieType == "DuckyTubeZombie"){
                        DuckyTubeZombie newZombie = new DuckyTubeZombie();
                        spawnedZombies.add(newZombie); 
                        tile.addZombie(newZombie);
                    }
                }
    
                
                System.out.println("Spawned a " + zombieType + " at row " + (i+1));
            }
        }
    

            
        
    }

    public void moveZombies() {
        for (int i = 0; i < MatriksPetak.length; i++) {
            for (int j = 1; j < MatriksPetak[i].length - 1; j++) { // Exclude the first and last columns
                Petak currentTile = MatriksPetak[i][j];
                Petak nextTile = MatriksPetak[i][j - 1]; // Move to the tile on the left

                for (Zombie zombie : currentTile.getListZombies()) {
                    currentTile.removeZombie();
                    nextTile.addZombie(zombie);
                }
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
                } 
                else if (currentTile.getListTanaman().size() == 2) {
                    if (currentTile.getListTanaman().get(1) instanceof Peashooter) {
                        System.out.print(tileRepresentation.charAt(0) + "P}" + tileRepresentation.charAt(1));
                    }
                    else if (currentTile.getListTanaman().get(1) instanceof Sunflower) {
                        System.out.print(tileRepresentation.charAt(0) + "S}" + tileRepresentation.charAt(1));
                    }
                    else if (currentTile.getListTanaman().get(1) instanceof PotatoMine) {
                        System.out.print(tileRepresentation.charAt(0) + "M}" + tileRepresentation.charAt(1));
                    }
                    else if (currentTile.getListTanaman().get(1) instanceof Repeater) {
                        System.out.print(tileRepresentation.charAt(0) + "R}" + tileRepresentation.charAt(1));
                    }
                    else if (currentTile.getListTanaman().get(1) instanceof Squash) {
                        System.out.print(tileRepresentation.charAt(0) + "Q}" + tileRepresentation.charAt(1));
                    }
                    else if (currentTile.getListTanaman().get(1) instanceof SnowPea) {
                        System.out.print(tileRepresentation.charAt(1) + "N}" + tileRepresentation.charAt(1));
                    }
                    else if (currentTile.getListTanaman().get(1) instanceof Tallnut) {
                        System.out.print(tileRepresentation.charAt(1) + "T}" + tileRepresentation.charAt(1));
                    }
                    else if (currentTile.getListTanaman().get(1) instanceof Jalapeno) {
                        System.out.print(tileRepresentation.charAt(1) + "J}" + tileRepresentation.charAt(1));
                    }
                    else if (currentTile.getListTanaman().get(1) instanceof Wallnut) {
                        System.out.print(tileRepresentation.charAt(1) + "W]" + tileRepresentation.charAt(1));
                    }
                }
                else {
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
    
}
