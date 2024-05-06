package Player;

public class CannotDeletePlantException extends Exception {
    public CannotDeletePlantException() {
        super("Cannot delete plant");
    }
}
