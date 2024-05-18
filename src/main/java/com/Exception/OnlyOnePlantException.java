package Exception;

public class OnlyOnePlantException extends Exception{
    public OnlyOnePlantException() {
        super("Sudah ada tanaman di petak darat!");
    }
}
