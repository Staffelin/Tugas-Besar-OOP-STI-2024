package Plants;
import Zombies.*;
import Map.*;

import java.util.ArrayList;



public class Jalapeno extends Plant {
    public Jalapeno () {
        super("Jalapeno", 125, 100, 5000, 0, -1, 25);
    }

    @Override
    public void attack() {
        super.attack(); // Call the attack method of the parent class
        setPlantDie(); // Set isDie to true
        // Rest of the code...
    }
}
