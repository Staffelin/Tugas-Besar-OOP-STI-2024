package Player;

public class DeckFullException extends Exception {
    public DeckFullException() {
        super("Deck is full");
    }
}
