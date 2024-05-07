package Map;

import java.util.ArrayList;
import Plants.*;
import Zombies.*;


public abstract class Petak {
    int row;
    int column;
    boolean isAquatic;
    ArrayList<Plant> listTanaman;
    ArrayList<Zombie> listZombies;

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

    public ArrayList<Plant> getListTanaman() {
        return listTanaman;
    }

    public void tanamTanaman(Plant p) {
        if (isAquatic) {
            if (hasLilyPad() || p instanceof Lilypad) {
                if (listTanaman.size() < 2) {
                    listTanaman.add(p);
                } else {
                    System.out.println("Tidak bisa menanam lebih dari dua tanaman di Petak Kolam");
                }
            } else {
                System.out.println("Tanam dulu Lilypad nya!");
            }
        } else {
            if (listTanaman.isEmpty()) {
                listTanaman.add(p);
            } else {
                System.out.println("Sudah ada tanaman di Petak Darat ini");
            }
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
    
}