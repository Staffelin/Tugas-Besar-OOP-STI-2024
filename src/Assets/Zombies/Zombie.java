package Zombies;

public class Zombie implements Attack {
    String name;
    int health;
    int attack_damage;
    int attack_speed;
    int current_speed;
    boolean isAquatic;

    public Zombie(String name, int health, int attack_damage, int attack_speed, int current_speed, boolean isAquatic) {
        this.name = name;
        this.health = health;
        this.attack_damage = attack_damage;
        this.attack_speed = attack_speed;
        this.current_speed = current_speed;
        this.isAquatic = isAquatic;
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

    // Implement methods from the Attack interface here
    public void attack(){}
}
