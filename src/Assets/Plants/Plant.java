package Plants;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

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
    LocalDateTime lastPlantedTime;
    LocalDateTime lastAttackTime;
    

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
        return true;
    }

    public void setLastAttackTime(LocalDateTime lastAttackTime) {
        this.lastAttackTime = lastAttackTime;
    }

    public void attack(ArrayList<Zombie> zombie) {
        if (canAttack()) {
            zombie.get(0).takeDamage(attack_damage);
            lastAttackTime = LocalDateTime.now();
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

    }
}
