package Plants;

import Player.Sun;

public class Sunflower extends Plant {
    private static boolean running = false;
    private static Thread sunThread;

    public Sunflower () {
        super("Sunflower", 50, 100, 0, 0, 0, 10);
    }

    public void SunflowerGenerateSun() {
        running = true;
        sunThread = new Thread(() -> {
            while (running) {
                Sun.increaseSun(25);
                try {
                    Thread.sleep(3000); // Sleep for 3 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        sunThread.start();
    }
}
