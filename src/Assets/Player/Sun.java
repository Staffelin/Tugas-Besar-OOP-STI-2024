package Player;

public class Sun{
    public static int sun = 25;
    private static boolean running = false;
    private static Thread sunThread;

    public static int getSun(){
        return sun;
    }

    public static void reduceSun(int cost){
        sun -= cost;
    }

    public static void increaseSun (int cost) {
        sun += cost;
    }

    public static void generateSun() {
        running = true;
        sunThread = new Thread(() -> {
            while (running) {
                sun += 25;
                try {
                    Thread.sleep((long) (Math.random() * (10000 - 5000) + 5000));
                } catch (InterruptedException e) {
                    running = false;
                    Thread.currentThread().interrupt(); // Preserve the interrupted status
                }
            }
        });
        sunThread.start();
    }
    
    public static void stopGenerateSun() {
        running = false;
        if (sunThread != null) {
            sunThread.interrupt();
        }
    }

    // TO DO: Buat generate sun tiap berapa second
}