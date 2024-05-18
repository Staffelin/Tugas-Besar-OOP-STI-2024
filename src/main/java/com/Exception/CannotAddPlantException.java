package Exception;

public class CannotAddPlantException extends Exception {
    public CannotAddPlantException() {
        super("Tunggu cooldown untuk menanam tanaman lagi!");
    }
}
