package Map;

import java.util.ArrayList;
import Exception.*;
import java.time.LocalDateTime;
import Plants.*;
import Player.Sun;
import Zombies.*;
//import Map.*;


public abstract class Petak {
    private int row;
    private int column;
    private boolean isAquatic;
    private ArrayList<Plant> listTanaman;
    private ArrayList<Zombie> listZombies;

    public Petak(int row, int column, boolean isAquatic) {
        this.row = row;
        this.column = column;
        this.isAquatic = isAquatic;
        this.listZombies = new ArrayList<>(10);
        if (isAquatic) {
            this.listTanaman = new ArrayList<>(2);
        } else {
            this.listTanaman = new ArrayList<>(1);
        }
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isAquatic() {
        return isAquatic;
    }

    public ArrayList<Zombie> getListZombies() {
        return listZombies;
    }

    public int getJumlahZombie(){
        return listZombies.size();
    }

    public ArrayList<Plant> getListTanaman() {
        return listTanaman;
    }

    public int getJumlahTanaman(){
        return listTanaman.size();
    }

    public void tanamTanaman(Plant p) throws CannotAddPlantException, PlantLilypadFirstException, LilypadOnLandException, OnlyOnePlantException, TwoPlantOnWaterException, SunNotEnoughException, LilypadAlreadyExists {
        if (p.isPlantable() && Sun.getSun() >= p.getCost()) {
            if (isAquatic) {
                if (hasLilyPad() || p instanceof Lilypad) {
                    if (p instanceof Lilypad && hasLilyPad()) {
                        throw new LilypadAlreadyExists();
                    }
                    if (listTanaman.size() < 2) {
                        listTanaman.add(p);
                        p.setColumn(column);
                        p.setRow(row);
                        Sun.reduceSun(p.getCost());
                        Lilypad lilyPad = (Lilypad) listTanaman.get(0);
                        lilyPad.setHealth(lilyPad.getHealth() + p.getHealth());
                        p.setLastPlantedTime(LocalDateTime.now());
                        p.attack();
                    } else {
                        throw new TwoPlantOnWaterException();
                    }
                } else {
                    throw new PlantLilypadFirstException();
                }
            } else {
                if (p instanceof Lilypad) {
                    throw new LilypadOnLandException();
                }
                if (p instanceof Sunflower) {
                    ((Sunflower) p).SunflowerGenerateSun();
                }
                if (listTanaman.isEmpty()) {
                    listTanaman.add(p);
                    p.setColumn(column);
                    p.setRow(row);
                    System.out.println(p.getName() + " planted");
                    Sun.reduceSun(p.getCost());
                    p.setLastPlantedTime(LocalDateTime.now());
                    p.attack();                   
                } else {
                    throw new OnlyOnePlantException();
                }
            }
        } else {
            if (!p.isPlantable()) {
                throw new CannotAddPlantException();
            }
            if (Sun.getSun() < p.getCost()) {
                throw new SunNotEnoughException();
            }
        }
    }
    public void removeTanaman() throws NoPlantException {
        if(listTanaman.isEmpty()){
            throw new NoPlantException();
        }
        else{
            listTanaman.remove(listTanaman.size() - 1);
        }
    }

    public boolean hasLilyPad() {
        for (Plant plant : listTanaman) {
            if (plant instanceof Lilypad) {
                return true;
            }
        }
        return false;
    }

    public void addZombie(Zombie Z){
        getListZombies().add(Z);
    }

    // public void attackTile(Petak enemyTile){
    //     if(this.getListTanaman().size() > 0 && enemyTile.getListZombies().size() > 0){
    //         if(this instanceof PetakDarat){
    //             Plant attackingPLant = this.getListTanaman().get(0);
    //             if((enemyTile.getColumn() - this.getColumn() <= attackingPLant.getRange() ||  attackingPLant.getRange() == -1) && enemyTile.getColumn() - this.getColumn() >= 0){
    //                 attackingPLant.attack(enemyTile.getListZombies());
    //             }
    //             this.getListTanaman().get(0).attack(enemyTile.getListZombies());
    //         }
    //         else if(this instanceof PetakKolam){
    //             if(this.getListTanaman().size() == 2){
    //                 this.getListTanaman().get(1).attack(enemyTile.getListZombies());
    //             }
    //         }
    //     }
    // }

    public void removeZombie(Zombie zombie) {
        if (listZombies.isEmpty()) {
            System.out.println("No zombies to remove");
        } else if (!listZombies.contains(zombie)) {
            System.out.println("Zombie not found");
        } else {
            listZombies.remove(zombie);
            // System.out.println("Zombie removed from tile (" + this.row + ", " + this.column + ")");
            
        }
    }
    
    
}