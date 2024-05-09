package Map;

import java.util.ArrayList;

import Exception.CannotAddPlantException;

import java.time.LocalDateTime;
import Plants.*;
import Zombies.*;


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
        this.listZombies = new ArrayList<>();
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

    public void tanamTanaman(Plant p) throws CannotAddPlantException {
        if (p.isPlantable()) {
            if (isAquatic) {
                if (hasLilyPad() || p instanceof Lilypad) {
                    if (listTanaman.size() < 2) {
                        listTanaman.add(p);
                        p.setLastPlantedTime(LocalDateTime.now());
                    } else {
                        System.out.println("Tidak bisa menanam lebih dari dua tanaman di Petak Kolam");
                    }
                } else {
                    System.out.println("Tanam dulu Lilypad nya!");
                }
            } else {
                if (listTanaman.isEmpty()) {
                    listTanaman.add(p);
                    p.setLastPlantedTime(LocalDateTime.now());
                } else {
                    System.out.println("Sudah ada tanaman di Petak Darat ini");
                }
            }
        }
        else {
            throw new CannotAddPlantException();
        }
    }


    public void removeTanaman(){
        if(listTanaman.isEmpty()){
            System.out.println("Tidak ada Tanaman");
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
    
}