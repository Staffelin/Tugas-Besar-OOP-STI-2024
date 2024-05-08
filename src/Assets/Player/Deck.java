package Player;

import java.util.ArrayList;

import Exception.CannotDeletePlantException;
import Exception.CannotSwapDeckException;
import Plants.*;

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

    public void swapDeck (int indeks1, int indeks2) throws CannotSwapDeckException  {
        Plant temp = deckOfPlants.get(indeks1);
        deckOfPlants.set(indeks1, deckOfPlants.get(indeks2));
        deckOfPlants.set(indeks2, temp);
        
        if (deckOfPlants.get(indeks1) == null || deckOfPlants.get(indeks2) == null || deckOfPlants.get(indeks1) == deckOfPlants.get(indeks2) ) {
            throw new CannotSwapDeckException();
        }
    }

    public void deletePlant (int indeks) throws CannotDeletePlantException {
       
        if (getDeckOfPlants().get(indeks) == null) {
            throw new CannotDeletePlantException();
        } else {
            getDeckOfPlants().remove(indeks);
        }
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

    public Plant getPlant(int indeks) {
        return deckOfPlants.get(indeks);
    }



}