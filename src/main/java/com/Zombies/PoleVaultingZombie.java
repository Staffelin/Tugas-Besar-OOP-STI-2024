package Zombies;
import Map.*;
import Plants.*;

public class PoleVaultingZombie extends Zombie {
    private boolean hasVaulted = false;
    public PoleVaultingZombie () {
        super("Pole Vaulting Zombie", 175, 100, 1, 5, false);
    }
    
    @Override
    public void attack() {
        Petak nextTile = Map.getFromMatriksPetak(getRow(), getColumn());
        if (nextTile != null && nextTile.getJumlahTanaman() > 0 && !nextTile.getListTanaman().isEmpty() && !hasVaulted) {
            if (nextTile.getListTanaman().get(0) instanceof Tallnut) {
                System.out.println("Harus basic attack nch!");
                basicAttack();
                hasVaulted = true;
            }
            else {
                vault(nextTile);
            }
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
        this.setColumn(getColumn());
        Petak newTile = Map.getFromMatriksPetak(getRow(), getColumn());
        newTile.addZombie(this);
        System.out.println("Zombie " + getName() + " is now at " + "(" + getRow() + ", " + getColumn() + ")");
        hasVaulted = true;
    }
    
    public void basicAttack() {
        Petak petak = Map.getFromMatriksPetak(getRow(), getColumn());
        if (petak != null && petak.getJumlahTanaman() > 0 && !petak.getListTanaman().isEmpty()) {
            Plant p = petak.getListTanaman().get(0);
            p.takeDamage(attack_damage);
            System.out.println("POLEVAULT ZOMBIE NOW ATTACK AT NORMAL SPEED. NOW ATTACKING " + p.getName() + " AT " + "(" + petak.getRow() + ", " + petak.getColumn() + ")");
            // setMovementSpeed(getCurrentSpeed() + 1);
        }
    }
}