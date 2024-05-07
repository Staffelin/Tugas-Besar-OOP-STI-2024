package Exception;

public class CannotDeletePlantException extends Exception {
    public CannotDeletePlantException() {
        super("Tidak dapat menghapus tanaman");
    }
}
