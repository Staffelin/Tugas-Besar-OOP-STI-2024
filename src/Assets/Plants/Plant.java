package Plants;
import java.time.Duration;
import java.time.LocalDateTime;
// import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Iterator;

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

    public void setHealth(int health){
        this.health = health;
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
        return Duration.between(lastAttackTime, LocalDateTime.now()).getSeconds() >= attack_speed;
    }

    public void setLastAttackTime() {
        this.lastAttackTime = LocalDateTime.now();
    }

    public void setCooldown (int cooldown) {
        this.cooldown = cooldown;
    }

    public void attack() {
        if (canAttack()) {
            ArrayList<Zombie> zombiesInRow = new ArrayList<>();
            for(int i = column; i < 10; i++){   
                Petak tile = Map.getFromMatriksPetak(row, i);
                if(tile.getListZombies().size() > 0){
                    zombiesInRow.addAll(tile.getListZombies());
                    break;
                }
            }
            Iterator<Zombie> iterator = zombiesInRow.iterator();
            while (iterator.hasNext()) {
                Zombie z = iterator.next();
                if (this.getRow() == z.getRow()) {
                    z.takeDamage(attack_damage);
                    if(!(this instanceof Sunflower || this instanceof Lilypad || this instanceof Wallnut || this instanceof Tallnut)) {
                        System.out.println("Tanaman " + getName() + " Menyerang " + z.getName() + " di " + "(" + (z.getRow()+1) + ", " + z.getColumn() + ")");
                    }
                    if (z.getHealth() <= 0) {
                        iterator.remove();
                        // System.out.println("ZOMBIE DI PETAK " + z.getRow() + " MATI");
                    }
                }
            }
            setLastAttackTime();
        }
    }
    

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            die();
        }
    }

    public void die() {
        System.out.println(name + " HAS DIED.");
        setPlantDie();
        Petak tile = Map.getFromMatriksPetak(this.getRow(), this.getColumn());
        tile.getListTanaman().remove(this); 
    }
}