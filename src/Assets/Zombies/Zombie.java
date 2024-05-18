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
    private boolean isDie = false;
    private int effectTime = 0;
    

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

    public int getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(int effectTime) {
        this.effectTime = effectTime;
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
        // System.out.println("Zombie taking "+damage+" damage"); // Add this line
        this.health -= damage;
        if (this.health <= 0) {
            die();
        }
    }
    public void checkEffect(){
        if (effectTime > 0){
            effectTime--;
        }
        else{
            setMovementSpeed(current_speed);
        }
    }

    protected void die() {
        System.out.println(name + " has died.");  
        setDie();
        Map.spawnedZombies.remove(this);
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


}

