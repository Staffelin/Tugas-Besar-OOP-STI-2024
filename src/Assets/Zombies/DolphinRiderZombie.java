package Zombies;

import Map.*;
import Plants.Plant;
import Plants.Tallnut;

public class DolphinRiderZombie extends Zombie {
    public DolphinRiderZombie () {
        super("Dolphin Rider Zombie", 175, 100, 1, 5, true);
    }
    boolean hasDived = false;

    @Override
    public void attack() {
        Petak nextTile = Map.getFromMatriksPetak(getRow(), getColumn());
        if (nextTile != null && nextTile.getJumlahTanaman() > 0 && !nextTile.getListTanaman().isEmpty() && !hasDived) {
            if (nextTile.getListTanaman().get(1) instanceof Tallnut) {
                System.out.println("Harus basic attack nch!");
                basicAttack();
                hasDived = true;
            }
            else {
                vault(nextTile);
            }
        }
        // After vaulting, perform basic attack
        basicAttack();
    }
    
    public void vault(Petak nextTile) {
        for (int i = 0; i < nextTile.getListTanaman().size(); i++) {
            Plant p = nextTile.getListTanaman().get(i);
            p.die();
            System.out.println("Zombie " + getName() + " vaults over " + p.getName() + " at " + "(" + nextTile.getRow() + ", " + nextTile.getColumn() + ")");
        }
        Petak currentTile = Map.getFromMatriksPetak(getRow(), getColumn());
        currentTile.removeZombie(this);
        // Move the zombie to the left
        this.setColumn(getColumn()-1);
        Petak newTile = Map.getFromMatriksPetak(getRow(), getColumn());
        newTile.addZombie(this);
        if (newTile != null && newTile.getJumlahTanaman() > 0 && !newTile.getListTanaman().isEmpty()) {
            Plant p2 = newTile.getListTanaman().get(0);
            p2.die();
        }
        System.out.println("Zombie " + getName() + " is now at " + "(" + getRow() + ", " + getColumn() + ")");
        hasDived = true;
    }
    
    public void basicAttack() {
        Petak currentTile = Map.getFromMatriksPetak(getRow(), getColumn());
        Petak nextTile = Map.getFromMatriksPetak(getRow(), getColumn()-1);
    
        if (currentTile != null && currentTile.getJumlahTanaman() > 0 && !currentTile.getListTanaman().isEmpty()) {
            Plant p = currentTile.getListTanaman().get(0);
            p.takeDamage(attack_damage);
            System.out.println(getName() + " IS ATTACKING <CURRENT TILE> " + p.getName() + " at (" + currentTile.getRow() + ", " + currentTile.getColumn() + ")");
        } 
        else if (nextTile != null && nextTile.getJumlahTanaman() > 0 && !nextTile.getListTanaman().isEmpty()) {
            Plant p = nextTile.getListTanaman().get(0);
            p.takeDamage(attack_damage);
            System.out.println(getName() + " IS ATTACKING <NEXT TILE> " + p.getName() + " at (" + nextTile.getRow() + ", " + nextTile.getColumn() + ")");
        }
    }
}