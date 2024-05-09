package Zombies;

public class FootballZombie extends Zombie {
    public FootballZombie () {
        super("Football Zombie", 300, 100, 1, 4, false);
    }

    public void setHasMetal(has_metal : boolean) {
        this.has_metal = has_metal;
    }
}