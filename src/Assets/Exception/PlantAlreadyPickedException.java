package Exception;

public class PlantAlreadyPickedException extends Exception {
    public PlantAlreadyPickedException() {
        super("Plant already picked");
    }
}
