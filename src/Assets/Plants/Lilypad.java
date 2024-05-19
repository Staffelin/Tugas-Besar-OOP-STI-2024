package Plants;

public class Lilypad extends Plant {
    public Lilypad () {
        super("LILYPAD", 25, 100, 0, 0, 0, 10);
    }

    public void healthUpdate(int newHealth){
        this.setHealth(getHealth() + newHealth);
    }
}
