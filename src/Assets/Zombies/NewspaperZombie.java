package Zombies;

public class NewspaperZombie extends Zombie {
    public NewspaperZombie () {
        super("Newspaper Zombie", 175, 100, 1, 5, false);
    }

    public increaseSpeed() {
        if (this.health <= 100) {
            this.currentSpeed = 3;
        }
    }

}

