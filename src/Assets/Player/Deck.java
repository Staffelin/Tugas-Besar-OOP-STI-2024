import java.util.ArrayList; 

public class Deck{
    // private Plant[] deckOfPlants;

    // public Deck() {
    //     deckOfPlants = new Plant[6];
    // }

    private ArrayList <Plant> deckOfPlants;

    public Deck() {
        deckOfPlants = new ArrayList<>();
    }

    public ArrayList<Plant> getDeckOfPlants() {
        return deckOfPlants;
    }

    public boolean isEmpty() {
        return deckOfPlants.isEmpty();
    }

    public boolean isSlotEmpty (int indeks) {
        return deckOfPlants.get(indeks) == null;
    }

    public void displayDeck() {
        if (deckOfPlants.isEmpty()) {
            System.out.println("Deck is empty");
            return;
        }
        else {
            for (int i = 0; i < deckOfPlants.size(); i++) {
                if (deckOfPlants.get(i) == null) {
                    System.out.println((i+1) + ". Empty");
                } else {
                    System.out.println((i+1) + ". " + deckOfPlants.get(i).getName());
                }
            }
        }
    }



}