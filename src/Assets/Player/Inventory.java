package Player;
import java.util.ArrayList;
import Exception.PlantAlreadyPickedException;
import Plants.*;

public class Inventory{    
    private ArrayList <Plant> plant_inventory;
    private Deck deckOfPlants;

    public Inventory(){
        plant_inventory = new ArrayList<Plant>();
        deckOfPlants = new Deck();
    }

    public void showInventory() {
        for (int i = 0; i < plant_inventory.size(); i++) {
            System.out.println((i+1) + ". " + plant_inventory.get(i).getName());
        }
    }

    public void switchInventoryTanaman (int indeks1, int indeks2) {
        Plant temp = plant_inventory.get(indeks1);
        plant_inventory.set(indeks1, plant_inventory.get(indeks2));
        plant_inventory.set(indeks2, temp);
    }

    public ArrayList<Plant> getInventory() {
        return plant_inventory;
    }

    public Deck getDeck() {
        return deckOfPlants;
    }

    public void addPlant (Deck deck, int indeks) throws PlantAlreadyPickedException {

        Plant plantToAdd = plant_inventory.get(indeks);
        if (deck.getDeckOfPlants().contains(plantToAdd)) {
            throw new PlantAlreadyPickedException();
        }
        deck.getDeckOfPlants().add(plantToAdd);
    }


    public void removePlantFromDeck (int indeks) { // tambahin exception
        deckOfPlants.getDeckOfPlants().remove(indeks);
    }



    
}