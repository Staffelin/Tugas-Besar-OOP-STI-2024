package Plants;

public class Lilypad extends Plant {
    public Lilypad () {
        super("LILYPAD", 25, 100, 0, 0, 0, 10);
    }

    public void healthUpdate(int newhealth){
        setHealth(this.health + newhealth);
    }
}
