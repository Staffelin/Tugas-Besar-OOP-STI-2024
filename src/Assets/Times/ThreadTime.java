package Times;

public class ThreadTime extends Thread{
    private Time time;
    private volatile boolean running = true;

    public ThreadTime(Time time){
        this.time = time;
    }

    public void stopThread() {
        running = false;
    }

    public void run() {
        while (running) {
            try {
                Thread.sleep(1000);
                time.addSeconds();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
