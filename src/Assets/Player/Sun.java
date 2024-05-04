package Player;

public class Sun{
    static int sun;

    public static int getSun(){
        return sun;
    }

    public static void reduceSun(int cost){
        sun -= cost;
    }

    public static void increaseSun (int cost) {
        sun += cost;
    }

    // TO DO: Buat generate sun tiap berapa second
}