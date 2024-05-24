package Map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import Zombies.*;
import Plants.*;
import Exception.*;

public class Map {
    private static Petak[][] MatriksPetak;
    private static boolean flag = false;
    String[] listSpawnableZombieDarat = {"BucketheadZombie", "ConeheadZombie", "FootballZombie","Gargantuar","NewspaperZombie","NormalZombie","PoleVaultingZombie","Yetizombie"};
    String[] listSpawnableZombieKolam = {"DolphinRiderZombie", "DuckyTubeZombie"};
    Random random = new Random();
    private boolean stillPlaying = true;
    private boolean isSpawningZombie = false;
    private static FactoryZombie Factory;

    public Map() {
        MatriksPetak = new Petak[6][11];
        for (int i = 0; i < 6; i++) {
            MatriksPetak[i][0] = new ProtectedArea(i, 0);
            MatriksPetak[i][10] = new ZombieSpawn(i, 10); 
            Factory = new FactoryZombie();
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


    public static Petak getFromMatriksPetak(int row, int column) {
        if (row >= 0 && row < MatriksPetak.length && column >= 0 && column < MatriksPetak[0].length) {
            return MatriksPetak[row][column];
        } else {
            return null;
        }
    }

    public static FactoryZombie getFactoryZombie() {
        return Factory;
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
        Factory.spawnZombie(this);
    }

    public void moveZombies() {    
        for (int i = 0; i < MatriksPetak.length; i++) {
            for (int j = MatriksPetak[i].length - 1; j > 0; j--) {
                Petak petak = MatriksPetak[i][j];
                Petak nextPetak = MatriksPetak[i][j - 1];
                ArrayList<Zombie> zombies = new ArrayList<>(petak.getListZombies()); 
                for (Zombie zombie : zombies) {
                    if (zombie.getDie() == false) {
                        if(petak.getListTanaman().size() == 0){
                            if (System.currentTimeMillis() - zombie.getSpawnTime() >= 10000) {
                                petak.removeZombie(zombie); 
                                nextPetak.addZombie(zombie);
                                zombie.setRow(i);
                                zombie.setColumn(j - 1);
    
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
                System.out.println("ZOMBIE BERHASIL MENCAPAI RUMAH");
                stillPlaying = false;
                break;
            }
        }
    }


public void attackPlants() {
    for (int i = 0; i < MatriksPetak.length; i++) {
        for(int j = 1; j < MatriksPetak[i].length; j++){
            Petak currTile = getFromMatriksPetak(i, j);
            List<Plant> plants = new ArrayList<>(currTile.getListTanaman());
            for (Plant p : plants) {
                p.attack();
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
                            z.checkSlowEffect();
                        }
                    }
                    else if (currentTile.isAquatic()) {
                        System.out.print(blue + "{ " + reset + "Z("+zombieCount+")" + blue + " }" + reset  + " ");
                        for(Zombie z : currentTile.getListZombies()){
                            z.checkSlowEffect();
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
        
        for(int x = 0; x < 44; x++){
            System.out.print("==");
        }
        System.out.println();
    }
    public void addPlantToTile(int row, int column, Plant plant) {
        Petak tile = MatriksPetak[row-1][column];
        try {
            Plant newPlant = plant.getClass().getDeclaredConstructor().newInstance();
            tile.tanamTanaman(newPlant);
            System.out.println(newPlant.getName() + " berhasil ditanam di (" + row + ", " + column + ")");
        } catch (CannotAddPlantException e) {
            System.out.println("Cannot add plant to tile: " + e.getMessage());
        } catch (PlantLilypadFirstException e) {
            System.out.println("Cannot add plant to tile: " + e.getMessage());
        } catch (LilypadOnLandException e) {
            System.out.println("Cannot add plant to tile: " + e.getMessage());
        } catch (OnlyOnePlantException e) {
            System.out.println("Cannot add plant to tile: " + e.getMessage());
        } catch (TwoPlantOnWaterException e) {
            System.out.println("Cannot add plant to tile: " + e.getMessage());
        } catch (SunNotEnoughException e) {
            System.out.println("Cannot add plant to tile: " + e.getMessage());
        } catch (LilypadAlreadyExists e) {
            System.out.println("Cannot add plant to tile: " + e.getMessage());
        } catch (PotatoMineOnWaterException e) {
            System.out.println("Cannot add plant to tile: " + e.getMessage());
        } catch (ReflectiveOperationException e) {
            System.out.println("Failed to create a new instance of the plant: " + e.getMessage());
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

    public boolean isSpawningZombie() {
        return isSpawningZombie;

    }

    public void setSpawningZombie(boolean isSpawningZombie) {
        this.isSpawningZombie = isSpawningZombie;
    }

    public boolean isZombieOnLastTile () {
        for (int i = 0; i < MatriksPetak.length; i++) {
            if (MatriksPetak[i][0].getListZombies().size() > 0) {
                return true;
            }
        }
        return false;
    }

    public static void setFlag(boolean flag) {
        Map.flag = flag;
        Factory.setFlag(flag);
    }
    
}