package Player;

import java.util.ArrayList;
import Exception.*;
import Plants.*;

public class Deck {
    private ArrayList<Slot<Plant>> deckOfPlants;
    private int deckSize = 0;

    public Deck() {
        deckOfPlants = new ArrayList<>();
    }

    public ArrayList<Slot<Plant>> getDeckOfPlants() {
        return deckOfPlants;
    }

    public boolean isEmpty() {
        return deckOfPlants.isEmpty();
    }

    public int getDeckSize() {
        return deckSize;
    }

    public boolean isSlotEmpty(int index) {
        return deckOfPlants.get(index).getItem() == null;
    }

    public void swapDeck(int index1, int index2) throws CannotSwapDeckException {
        Slot<Plant> temp = deckOfPlants.get(index1);
        deckOfPlants.set(index1, deckOfPlants.get(index2));
        deckOfPlants.set(index2, temp);
        
        if (deckOfPlants.get(index1).getItem() == null || deckOfPlants.get(index2).getItem() == null ||
            deckOfPlants.get(index1).getItem() == deckOfPlants.get(index2).getItem()) {
            throw new CannotSwapDeckException();
        }
    }

    public void deletePlant(int index) throws CannotDeletePlantException {
        if (deckOfPlants.get(index).getItem() == null) {
            throw new CannotDeletePlantException();
        } else {
            deckOfPlants.remove(index);
        }
    }

    public void displayDeck() {
        if (deckOfPlants.isEmpty()) {
            System.out.println("Deck is empty");
            return;
        } else {
            for (int i = 0; i < deckOfPlants.size(); i++) {
                Slot<Plant> slot = deckOfPlants.get(i);
                if (slot.getItem() == null) {
                    System.out.println((i + 1) + ". Empty");
                } else {
                    System.out.println((i + 1) + ". " + slot.getItem().getName());
                }
            }
        }
    }

    public Plant getPlant(int index) {
        return deckOfPlants.get(index).getItem();
    }

    public void addPlant(Plant plant) throws PlantAlreadyPickedException {
        for (Slot<Plant> slot : deckOfPlants) {
            if (slot.getItem().equals(plant)) {
                throw new PlantAlreadyPickedException();
            }
        }
        deckOfPlants.add(new Slot<>(plant));
        deckSize++;
    }

    public void removePlant(int index) {
        deckOfPlants.remove(index);
        deckSize--;
    }
}
