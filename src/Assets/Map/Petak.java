package Map;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import Exception.*;
import Plants.*;
import Player.Sun;
import Zombies.*;

public abstract class Petak<T extends Plant, U extends Zombie> {
    private int row;
    private int column;
    private boolean isAquatic;
    private List<T> listTanaman;
    private List<U> listZombies;

    public Petak(int row, int column, boolean isAquatic) {
        this.row = row;
        this.column = column;
        this.isAquatic = isAquatic;
        this.listZombies = new ArrayList<>(10);
        this.listTanaman = new ArrayList<>(isAquatic ? 2 : 1);
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

    public List<U> getListZombies() {
        return listZombies;
    }

    public int getJumlahZombie() {
        return listZombies.size();
    }

    public List<T> getListTanaman() {
        return listTanaman;
    }

    public int getJumlahTanaman() {
        return listTanaman.size();
    }

    public void tanamTanaman(T p) throws CannotAddPlantException, PlantLilypadFirstException, LilypadOnLandException, OnlyOnePlantException, TwoPlantOnWaterException, SunNotEnoughException {
        if (p.isPlantable() && Sun.getSun() >= p.getCost()) {
            if (isAquatic) {
                if (hasLilyPad() || p instanceof Lilypad) {
                    if (listTanaman.size() < 2) {
                        listTanaman.add(p);
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
        if (listTanaman.isEmpty()) {
            throw new NoPlantException();
        } else {
            listTanaman.remove(listTanaman.size() - 1);
        }
    }

    public boolean hasLilyPad() {
        for (T plant : listTanaman) {
            if (plant instanceof Lilypad) {
                return true;
            }
        }
        return false;
    }

    public void addZombie(U zombie) {
        listZombies.add(zombie);
    }

    public void removeZombie(U zombie) {
        if (listZombies.isEmpty()) {
            System.out.println("No zombies to remove");
        } else if (!listZombies.contains(zombie)) {
            System.out.println("Zombie not found");
        } else {
            listZombies.remove(zombie);
        }
    }
}
