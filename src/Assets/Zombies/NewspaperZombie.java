package Zombies;

public class NewspaperZombie extends Zombie {
    public NewspaperZombie () {
        super("Newspaper Zombie", 175, 100, 1, 5, false);
    }

    public void increaseSpeed() {
        if (this.health <= 100) {
            this.current_speed = 3;
        }
    }

}

