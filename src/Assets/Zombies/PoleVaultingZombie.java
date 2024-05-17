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
        System.out.println("Attack from Pole Vaulting Zombie");
        Petak nextTile = Map.getFromMatriksPetak(getRow(), getColumn());
        System.out.println("Petak didepan terdapat " + nextTile.getJumlahTanaman() + " tanaman");   
        if (nextTile.getJumlahTanaman() > 0 && !hasVaulted) {
            System.out.println("berhasil vault dong!");
            vault(nextTile);
        }
        // After vaulting, perform basic attack
        else{
            basicAttack();
        }
        
    }
    
    public void vault(Petak nextTile) {
        Plant p = nextTile.getListTanaman().get(0);
        System.out.println("Zombie " + getName() + " vaults over " + p.getName() + " at " + "(" + nextTile.getRow() + ", " + nextTile.getColumn() + ")");
        Petak currentTile = Map.getFromMatriksPetak(getRow(), getColumn());
        currentTile.removeZombie(this);
        // Move the zombie to the left
        this.setColumn(getColumn());
        Petak newTile = Map.getFromMatriksPetak(getRow(), getColumn());
        newTile.addZombie(this);
        System.out.println("Zombie " + getName() + " is now at " + "(" + getRow() + ", " + getColumn() + ")");
        hasVaulted = true;
        p.die();
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