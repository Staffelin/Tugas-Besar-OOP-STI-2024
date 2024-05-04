import java.util.ArrayList;

public class Map {
    private Petak[][] MatriksPetak;
    int wave;
    ArrayList<Zombie> listZombieMap;


    public Map(){
        MatriksPetak = new Petak[9][6];
        for(int i = 0; i<6; i++){
            MatriksPetak[0][i] = new ProtectedArea(0, i);
            MatriksPetak[8][i] = new ZombieSpawn(8, i);
            for(int j = 0; j<8; j++){
                boolean isAquatic = (j >= 3 && j <= 6);
                if(isAquatic){
                    new PetakKolam(i, j);
                }
                else{
                    new PetakDarat(i, j);
                }
            }
        }
    }
}
