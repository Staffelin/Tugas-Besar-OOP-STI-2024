package Zombies;

public class NewspaperZombie extends Zombie {
    public NewspaperZombie () {
        super("Newspaper Zombie", 175, 100, 1, 5, false);
    }

    public void increaseSpeed() {
        setMovementSpeed(3);
        System.out.println("Newspaper Zombie speed increased to 3");
    }

    @Override
    public void takeDamage (int damage) {
        this.health -= damage;
        if (this.health <= 100) {
            increaseSpeed();
        }
        if (this.health <= 0) {
            die();
        }
    }
}

