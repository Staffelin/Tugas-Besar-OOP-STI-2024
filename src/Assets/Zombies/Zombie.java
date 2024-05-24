package Zombies;

import java.time.Duration;
import java.time.LocalDateTime;

// import java.util.ArrayList;

import Map.*;
import Plants.*;


public class Zombie implements Position {
    String name;
    int health;
    int attack_damage;
    int attack_speed;
    int current_speed;
    int row;
    int column;
    boolean isAquatic;
    private long spawnTime;
    LocalDateTime lastAttackTime;
    long timeSlowed;
    private boolean isDie = false;
    private boolean slowed = false;
    private int slowDuration = 3000;
    

    public Zombie(String name, int health, int attack_damage, int attack_speed, int current_speed, boolean isAquatic) {
        this.name = name;
        this.health = health;
        this.attack_damage = attack_damage;
        this.attack_speed = attack_speed;
        this.current_speed = current_speed;
        this.isAquatic = isAquatic;
        this.lastAttackTime = LocalDateTime.MIN;
        // this.tile = tile;

        
    }
    
    public void setRow(int row){
        this.row = row;
    }

    public int getRow(){
        return row;
    }

    public void setColumn(int column){
        this.column = column;
    }

    public int getColumn(){
        return column;
    }

    public boolean getDie(){
        return isDie;
    }

    public void setDie(){
        this.isDie = true;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackDamage() {
        return attack_damage;
    }

    public int getAttackSpeed() {
        return attack_speed;
    }

    public void setMovementSpeed(int speed) {
        this.current_speed = speed;
    }

    public int getCurrentSpeed() {
        return current_speed;
    }

    public boolean isAquatic() {
        return isAquatic;
    }

    public void setSpawnTime(long spawnTime) {
        this.spawnTime = spawnTime;
    }

    public long getSpawnTime() {
        return this.spawnTime;
    }

    public void checkSlowEffect() {
        if (slowed && (System.currentTimeMillis() - timeSlowed) >= slowDuration) {
            setAttackSpeed(1);
            setMovementSpeed(10);
            slowed = false;
        }
    }

    public void setEffectTime() {
        while (!slowed) {
            setAttackSpeed(2);
            setMovementSpeed(20);
            timeSlowed = System.currentTimeMillis();
            slowed = true;
            System.out.println("ZOMBIE KENA SLOW EFFECT");
        }
    }



    public void setLastAttackTime(LocalDateTime lastAttackTime) {
        this.lastAttackTime = lastAttackTime;
    }

    public boolean canAttack() {
        LocalDateTime now = LocalDateTime.now();
        long secondsSinceLastAttack = Duration.between(lastAttackTime, now).getSeconds();
        return secondsSinceLastAttack * 1000 >= attack_speed;
    }

    public void attack() {
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

    public void takeDamage(int damage) {
        // System.out.println("HEALTH " + getName() + " DI ROW (" + getRow() + ", " + getColumn() + ")" +" SEKARANG ADALAH " + getHealth());

        this.health -= damage;
        if (this.health <= 0) {
            die();
        }
    }


    protected void die() {
        System.out.println(name + " HAS DIED AT" + (getRow()+1) + ", " + getColumn());  
        setDie();
        Map.getFactoryZombie().getSpawnedZombies().remove(this);
        // Petak tile = Map.getFromMatriksPetak(this.getRow(), this.getColumn());  
        // tile.removeZombie(this);
         
    }

    public boolean isPlantInFront (Petak tile) {
        Petak infront = Map.getFromMatriksPetak(this.getRow(), this.getColumn() - 1);
        if (infront != null && !infront.getListTanaman().isEmpty()) {
            return true;
        }
        return false;
    } 

    public void setAttackSpeed(int attack_speed) {
        this.attack_speed = attack_speed;
    }

    public void applySnowPeaEffect() {
        setMovementSpeed((int) 0.5 * current_speed);
        setAttackSpeed((int) (1.5 * attack_speed));
    }


}

