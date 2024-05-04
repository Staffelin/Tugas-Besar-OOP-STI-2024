import java.util.ArrayList;

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
        this.listTanaman = new ArrayList<>();
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

    public void tanamTanaman(Plant p){
        if(!isAquatic && listTanaman.isEmpty()){
            listTanaman.add(p);
        }
    }

    public void cabutTanaman(Plant p){
        listTanaman.remove(p);
    }

    public void spawnZombie(Zombie z){
        listZombies.add(z);
    }

    public void removeZombie(Zombie z){
        listZombies.remove(z);
    }




    
    
}