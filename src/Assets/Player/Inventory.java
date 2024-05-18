package Player;

import java.util.ArrayList;
import Exception.PlantAlreadyPickedException;
import Plants.*;

public class Inventory {
    private ArrayList<Slot<Plant>> plantInventory;
    private Deck deckOfPlants;

    public Inventory() {
        plantInventory = new ArrayList<>();
        deckOfPlants = new Deck();
    }

    public void showInventory() {
        for (int i = 0; i < plantInventory.size(); i++) {
            Slot<Plant> slot = plantInventory.get(i);
            System.out.println((i + 1) + ". " + slot.getItem().getName());
        }
    }

    public void switchInventoryTanaman(int indeks1, int indeks2) {
        Slot<Plant> temp = plantInventory.get(indeks1);
        plantInventory.set(indeks1, plantInventory.get(indeks2));
        plantInventory.set(indeks2, temp);
    }

    public ArrayList<Slot<Plant>> getInventory() {
        return plantInventory;
    }

    public Deck getDeck() {
        return deckOfPlants;
    }

    public void addPlantToInventory(Plant plant) {
        for (Slot<Plant> slot : plantInventory) {
            if (slot.getItem().equals(plant)) {
                return;
            }
        }
        plantInventory.add(new Slot<>(plant));
    }

    public void addPlantToDeck(int indeks) throws PlantAlreadyPickedException {
        Slot<Plant> slotToAdd = plantInventory.get(indeks);
        Plant plantToAdd = slotToAdd.getItem();
        
        // Check if the plant already exists in the deck
        for (Slot<Plant> slot : deckOfPlants.getDeckOfPlants()) {
            if (slot.getItem().equals(plantToAdd)) {
                throw new PlantAlreadyPickedException();
            }
        }
        
        deckOfPlants.getDeckOfPlants().add(new Slot<>(plantToAdd));
    }

    public Plant getPlant(int index){
        return plantInventory.get(index).getItem();
    }

    public void removePlantFromDeck(int indeks) {
        deckOfPlants.getDeckOfPlants().remove(indeks);
    }
}
