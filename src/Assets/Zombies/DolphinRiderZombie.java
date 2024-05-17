package Zombies;

import Map.*;
import Plants.Plant;

public class DolphinRiderZombie extends Zombie {
    public DolphinRiderZombie () {
        super("Dolphin Rider Zombie", 175, 100, 1, 5, true);
    }
    boolean hasDived = false;

    @Override
    public void attack() {
        Petak nextTile = Map.getFromMatriksPetak(getRow(), getColumn() - 1);
        if (nextTile != null && nextTile.getJumlahTanaman() > 0 && !nextTile.getListTanaman().isEmpty() && !hasDived) {
            vault(nextTile);
        }
        // After vaulting, perform basic attack
        basicAttack();
    }
    
    public void vault(Petak nextTile) {
        Plant p = nextTile.getListTanaman().get(0);
        p.die();
        System.out.println("Zombie " + getName() + " vaults over " + p.getName() + " at " + "(" + nextTile.getRow() + ", " + nextTile.getColumn() + ")");
        Petak currentTile = Map.getFromMatriksPetak(getRow(), getColumn());
        currentTile.removeZombie(this);
        // Move the zombie to the left
        this.setColumn(getColumn() - 1);
        Petak newTile = Map.getFromMatriksPetak(getRow(), getColumn());
        newTile.addZombie(this);
        System.out.println("Zombie " + getName() + " is now at " + "(" + getRow() + ", " + getColumn() + ")");
        hasDived = true;
    }
    
    public void basicAttack() {
        Petak petak = Map.getFromMatriksPetak(getRow(), getColumn() - 1);
        if (petak != null && petak.getJumlahTanaman() > 0 && !petak.getListTanaman().isEmpty()) {
            Plant p = petak.getListTanaman().get(0);
            p.takeDamage(attack_damage);
            System.out.println("ZOMBIEE IS COMINGG RAWR");
            // setMovementSpeed(getCurrentSpeed() + 1);
        }
    }
}