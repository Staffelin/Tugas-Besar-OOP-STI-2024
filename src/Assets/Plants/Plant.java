public class Plant implements Attack{
    String name;
    int cost;
    int health;
    int attack_damage;
    int attack_speed;
    int range;
    int cooldown;

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


    public void attack(){}
}
