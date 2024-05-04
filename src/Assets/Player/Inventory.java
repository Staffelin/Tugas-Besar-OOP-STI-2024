

public class Inventory{
    // ArrayList<Plant> InventoryTanaman;

    // public void printListTanaman(){
    //     for (Plant plant : InventoryTanaman){
    //         System.out.println(plant.getName());
    //     }
    // }

    // public void switchListTanaman (Plant plant1, Plant plant2){
    //     int index1 = InventoryTanaman.indexOf(plant1);
    //     int index2 = InventoryTanaman.indexOf(plant2);
    //     InventoryTanaman.set(index1, plant2);
    //     InventoryTanaman.set(index2, plant1);
    // }

    // public void addTanamanToDeck (Plant plant) {

    // }
    
    private Plant [] plant_inventory;
    private Deck deckOfPlants;

    public Inventory(){
        plant_inventory = new Plant[10];
        deckOfPlants = new Deck();
    }

    public void showInventory() {
        for (int i = 0; i < plant_inventory.length; i++) {
            System.out.println((i+1) + ". " + plant_inventory[i].getName());
        }
    }

    public void switchInventoryTanaman (int indeks1, int indeks2) {
        Plant temp = plant_inventory[indeks1];
        plant_inventory[indeks1] = plant_inventory[indeks2];
        plant_inventory[indeks2] = temp;
    }

    public Plant [] getInventory() {
        return plant_inventory;
    }

    public Deck getDeck() {
        return deckOfPlants;
    }

    public void swapDeck (int indeks1, int indeks2) {
        Plant temp = deckOfPlants.getDeckOfPlants().get(indeks1);
        deckOfPlants.getDeckOfPlants().set(indeks1, deckOfPlants.getDeckOfPlants().get(indeks2));
        deckOfPlants.getDeckOfPlants().set(indeks2, temp);
    }

    public void deletePlant (int indeks) {
        deckOfPlants.getDeckOfPlants().remove(indeks);
    }

    public void addPlant (int indeks) {
        deckOfPlants.getDeckOfPlants().add(plant_inventory[indeks]);
    }

    // public void addPlantToDeck (Plant plant, int indeks) {

    // }

    // public void removePlantFromDeck (int indeks) { // tambahin exception
    //     deckOfPlants[indeks] = null;
    // }



    
}