package Player;

public class SunTest {
    public static void main(String[] args) {
        Sun.generateSun();

        new Thread(() -> {
            int lastSun = 0;
            while (true) {
                if (Sun.sun > lastSun) {
                    System.out.println("Current sun: " + Sun.sun);
                    lastSun = Sun.sun;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
