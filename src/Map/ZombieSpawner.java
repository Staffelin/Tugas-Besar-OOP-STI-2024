package Map;

class ZombieSpawner implements Runnable {
    private Map map;

    public ZombieSpawner(Map map) {
        this.map = map;
    }

    @Override
    public void run() {
        while (true) {
            try {
                map.moveZombies();
                Thread.sleep(5000); // Sleep for 5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
