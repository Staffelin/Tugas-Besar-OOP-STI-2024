package Exception;

public class TwoPlantOnWaterException extends Exception {
    public TwoPlantOnWaterException() {
        super("Cannot plant more than two plant on water!");
    }
}
