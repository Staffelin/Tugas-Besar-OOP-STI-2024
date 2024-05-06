package Player;

public class CannotSwapDeckException extends Exception{
    public CannotSwapDeckException() {
        super("Cannot swap deck");
    }
}
