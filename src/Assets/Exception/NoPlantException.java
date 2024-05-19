package Exception;

public class NoPlantException extends Exception {
    public NoPlantException() {
        super("There is no plant in this tile");
    }
    
}
