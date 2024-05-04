public class Zombie implements Attack {
    String name;
    int health;
    int attack_damage;
    int attack_speed;
    int current_speed;
    boolean isAquatic;

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
