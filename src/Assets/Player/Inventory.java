

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
        plant_inventory = new Plant[6];
        deckOfPlants = new Deck();
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

    // public void addPlantToDeck (Plant plant, int indeks) {

    // }

    // public void removePlantFromDeck (int indeks) { // tambahin exception
    //     deckOfPlants[indeks] = null;
    // }



    
}