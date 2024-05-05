package Times;

public class Time {
    private int time_seconds;

    public Time(int time_seconds) {
        this.time_seconds = time_seconds;
    }

    public int getTimeSeconds () {
        return time_seconds;
    }

    public void setTimeSeconds (int time_seconds) {
        this.time_seconds = time_seconds;
    }

    public int getDay () {
        return (time_seconds / 200) + 1;
    }

    public void addSeconds() {
        time_seconds++;
    }

    public void increaseTime (int seconds) {
        time_seconds += seconds;
    }

    public void decreaseTime (int seconds) {
        time_seconds -= seconds;
    }

    public String getCurrentPhase() {
        if (time_seconds % 200 <= 100) {
            return "Day";
        } else {
            return "Night";
        }
    }
}