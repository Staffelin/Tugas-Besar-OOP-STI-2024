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