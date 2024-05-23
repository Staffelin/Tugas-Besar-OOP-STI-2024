package Zombies;

import java.util.ArrayList;
import java.util.Random;
import Map.*;

public class FactoryZombie {
    private String[] listSpawnableZombieDarat = {"BucketheadZombie", "ConeheadZombie", "FootballZombie", "Gargantuar", "NewspaperZombie", "NormalZombie", "PoleVaultingZombie", "Yetizombie"};
    private String[] listSpawnableZombieKolam = {"DolphinRiderZombie", "DuckyTubeZombie"};
    private Random random = new Random();
    private int normalSpawnSize = 10;
    private int flagSpawnSize = 25;
    public static ArrayList<Zombie> spawnedZombies = new ArrayList<>();
    private boolean flag = false;

    public ArrayList<Zombie> getSpawnedZombies() {
        return spawnedZombies;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void spawnZombie(Map map) {
        if (spawnedZombies == null) {
            spawnedZombies = new ArrayList<>();
        }
        int spawnSize = flag ? flagSpawnSize : normalSpawnSize;
        double spawnRate = flag ? 0.6 : 0.3;
        if (spawnedZombies.size() < spawnSize) {
            for (int i = 0; i < 6; i++) {
                if (random.nextDouble() < spawnRate && spawnedZombies.size() < spawnSize) {
                    String zombieType;
                    if (i == 2 || i == 3) {
                        zombieType = listSpawnableZombieKolam[random.nextInt(listSpawnableZombieKolam.length)];
                    } else {
                        zombieType = listSpawnableZombieDarat[random.nextInt(listSpawnableZombieDarat.length)];
                    }
                    Petak spawnSite = Map.getFromMatriksPetak(i, 10);
                    Zombie newZombie = createZombie(zombieType);

                    if (newZombie != null) {
                        newZombie.setRow(i);
                        newZombie.setColumn(10);
                        spawnedZombies.add(newZombie);
                        spawnSite.addZombie(newZombie);
                        newZombie.setSpawnTime(System.currentTimeMillis());
                        System.out.println(zombieType + " spawned at (" + (i + 1) + ", 10)");
                    }
                }
            }
        }
    }

    private Zombie createZombie(String zombieType) {
        switch (zombieType) {
            case "BucketheadZombie":
                return new BucketheadZombie();
            case "ConeheadZombie":
                return new ConeheadZombie();
            case "FootballZombie":
                return new FootballZombie();
            case "Gargantuar":
                return new Gargantuar();
            case "NewspaperZombie":
                return new NewspaperZombie();
            case "PoleVaultingZombie":
                return new PoleVaultingZombie();
            case "Yetizombie":
                return new YetiZombie();
            case "DolphinRiderZombie":
                return new DolphinRiderZombie();
            case "DuckyTubeZombie":
                return new DuckyTubeZombie();
            default:
                return new NormalZombie();
        }
    }
}
