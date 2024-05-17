package Zombies;

public class FootballZombie extends Zombie {
    private boolean has_metal = true;
    public FootballZombie () {
        super("Football Zombie", 300, 100, 1, 4, false);
    }

    public void setHasMetal(boolean has_metal) {
        this.has_metal = has_metal;
    }
}