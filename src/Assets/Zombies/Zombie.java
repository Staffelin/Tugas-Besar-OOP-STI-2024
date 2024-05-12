package Zombies;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Map.Petak;
import Map.PetakDarat;
import Map.PetakKolam;
import Plants.*;

public class Zombie implements Position {
    String name;
    int health;
    int attack_damage;
    int attack_speed;
    int current_speed;
    int row;
    boolean isAquatic;
    private long spawnTime;
    LocalDateTime lastAttackTime;
    

    public Zombie(String name, int health, int attack_damage, int attack_speed, int current_speed, boolean isAquatic) {
        this.name = name;
        this.health = health;
        this.attack_damage = attack_damage;
        this.attack_speed = attack_speed;
        this.current_speed = current_speed;
        this.isAquatic = isAquatic;
        this.lastAttackTime = LocalDateTime.MIN;

        
    }
    
    public void setRow(int row){
        this.row = row;
    }

    public int getRow(){
        return row;
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


    public void setLastAttackTime(LocalDateTime lastAttackTime) {
        this.lastAttackTime = lastAttackTime;
    }

    public boolean canAttack() {
        LocalDateTime now = LocalDateTime.now();
        long secondsSinceLastAttack = Duration.between(lastAttackTime, now).getSeconds();
        return secondsSinceLastAttack * 1000 >= attack_speed;
    }

    public void attack(ArrayList<Plant> plants, Petak tile) {
        if (canAttack()) {
            if(tile instanceof PetakDarat){
                plants.get(0).takeDamage(attack_damage);
            }
            else if(tile instanceof PetakKolam){
                if(plants.size() == 2){
                    plants.get(1).takeDamage(attack_damage);
                }
                else{
                    plants.get(0).takeDamage(attack_damage);
                }
            }
        }
        setLastAttackTime(LocalDateTime.now());
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            die();
        }
    }

    protected void die() {
        System.out.println(name + " has died.");        
    }
}
