package Exception;

public class CannotAddPlantException extends Exception {
    public CannotAddPlantException() {
        super("Tidak dapat menanam tanaman");
    }
}
