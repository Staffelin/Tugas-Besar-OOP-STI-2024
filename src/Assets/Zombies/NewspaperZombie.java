package Zombies;

public class NewspaperZombie extends Zombie {
    public NewspaperZombie () {
        super("Newspaper Zombie", 175, 100, 1, 5, false);
    }

    public void increaseSpeed() {
        setMovementSpeed(3);
        System.out.println("Newspaper Zombie now moves faster!");
        }
    

    @Override
    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 100) {
            increaseSpeed();
        }
        if (health <= 0) {
            die();
        }
    }
}

