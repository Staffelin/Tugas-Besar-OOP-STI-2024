package Plants;
import Zombies.*;

public class Plant implements Attack {
    String name;
    int cost;
    int health;
    int attack_damage;
    int attack_speed;
    int range;
    int cooldown;

    public Plant(String name, int cost, int health, int attack_damage, int attack_speed, int range, int cooldown){
        this.name = name;
        this.cost = cost;
        this.health = health;
        this.attack_damage = attack_damage;
        this.attack_speed = attack_speed;
        this.range = range;
        this.cooldown = cooldown;
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


    public void attack(){
        // TO DO: Implementasi attack
    }
}
