package Plants;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Map.*;
import Zombies.*;

public class Plant implements Position {
    String name;
    int cost;
    int health;
    int attack_damage;
    int attack_speed;
    int range;
    int cooldown;
    int row;
    int column;
    LocalDateTime lastPlantedTime;
    LocalDateTime lastAttackTime;
    private boolean plantDie = false;
    

    public Plant(String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown){
        this.name = name;
        this.cost = cost;
        this.health = health;
        this.attack_damage = attack_damage;
        this.attack_speed = attack_speed;
        this.range = range;
        this.cooldown = cooldown;
        this.lastAttackTime = LocalDateTime.MIN;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getRow(){
        return row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setPlantDie(){
        this.plantDie = true;
    }

    public boolean getPlantDie(){
        return plantDie;
    }

    public int getColumn(){
        return column;
    }

    public String getName(){
        return name;
    }

    public int getCost(){
        return cost;
    }

    public int getHealth(){
        return health;
    }

    public int getAttackDamage(){
        return attack_damage;
    }

    public int getAttackSpeed(){
        return attack_speed;
    }

    public int getRange(){
        return range;
    }

    public int getCooldown(){
        return cooldown;
    }

    public boolean isPlantable() {
        LocalDateTime now = LocalDateTime.now();
        if (lastPlantedTime != null && (Duration.between(lastPlantedTime, now).getSeconds()) < getCooldown()) {
            return false; 
        }
        else {
            return true;    
        }
    }
    
    public void setLastPlantedTime(LocalDateTime lastPlantedTime) {
        this.lastPlantedTime = lastPlantedTime;
    }


    public boolean canAttack() {
        return Duration.between(lastAttackTime, LocalDateTime.now()).getSeconds() >= attack_speed*1000;
    }

    public void setLastAttackTime() {
        this.lastAttackTime = LocalDateTime.now();
    }

    public void attack(ArrayList<Zombie> zombie) {
        if (canAttack()) {
            zombie.get(0).takeDamage(attack_damage);
            setLastAttackTime();
        }
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            die();
        }
    }

    protected void die() {
        System.out.println(name + " has died.");
        setPlantDie();
        Petak tile = Map.getFromMatriksPetak(this.getRow(), this.getColumn());
        tile.getListTanaman().remove(this); 


    }
}
