package Zombies;

public class BucketheadZombie extends Zombie {
    public BucketheadZombie () {
        super("Buckethead Zombie", 300, 100, 1, 1, false);
    }

    public void setHasMetal(has_metal : boolean) {
        this.has_metal = has_metal;
    }
}