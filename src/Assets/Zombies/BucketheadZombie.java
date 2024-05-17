package Zombies;

public class BucketheadZombie extends Zombie {
    boolean has_metal = true;
    public BucketheadZombie () {
        super("Buckethead Zombie", 300, 100, 1, 1, false);
    }

    public void setHasMetal(boolean has_metal) {
        this.has_metal = has_metal;
    }
}