package Zombies;

import Map.*;
import Plants.*;

public class DolphinRiderZombie extends Zombie {
    public DolphinRiderZombie () {
        super("Dolphin Rider Zombie", 175, 100, 1, 5, true);
    }
    boolean hasDived = false;

    @Override
    public void attack() {
        Petak nextTile = Map.getFromMatriksPetak(getRow(), getColumn());
        if (nextTile.getListTanaman().get(0) instanceof Lilypad && !hasDived) {
            if (nextTile.getListTanaman().size() > 1 && nextTile.getListTanaman().get(1) instanceof Tallnut) {
                System.out.println("HARUS BASIC ATTACK!");
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
            System.out.println("ZOMBIE " + getName() + " VAULTS OVER " + p.getName() + " AT " + "(" + nextTile.getRow() + ", " + nextTile.getColumn() + ")");
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
        System.out.println("ZOMBIE " + getName() + " IS NOW AT " + "(" + getRow() + ", " + getColumn() + ")");
        hasDived = true;
    }
    
    public void basicAttack() {
        Petak petak = Map.getFromMatriksPetak(getRow(), getColumn());
        if (petak != null && petak.getJumlahTanaman() > 0 && !petak.getListTanaman().isEmpty()) {
            Plant p = petak.getListTanaman().get(0);
            p.takeDamage(attack_damage);
            System.out.println("DOLPHIN RIDER ZOMBIE NOW ATTACK AT NORMAL SPEED. NOW ATTACKING " + p.getName() + " AT " + "(" + petak.getRow() + ", " + petak.getColumn() + ")");
            // setMovementSpeed(getCurrentSpeed() + 1);
        }
    }
}