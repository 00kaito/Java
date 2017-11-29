import java.util.List;
import java.util.Random;

public class Main {
    static int armyUnitsSize = 3;

    public static void main(String[] args) {
        Random random = new Random();

        Monster[] yourArmy = new Monster[armyUnitsSize];
        Monster[] enemyArmy = new Monster[armyUnitsSize];

        System.out.println("GENERATRE MY ARMY");
        armyGenerator(armyUnitsSize, yourArmy, random);
        System.out.println("GENERATE ENEMY AMRY");
        armyGenerator(armyUnitsSize, enemyArmy, random);

        fight(yourArmy, enemyArmy);

        System.out.println("Summary");
        System.out.println("Your health: "+healthSum(yourArmy) +"Enemy Health: "+healthSum(enemyArmy));

    }

    private static void fight(Monster[] yourArmy, Monster[] enemyArmy) {
        Random random = new Random();
        int round = 1;
        int armyUnitIterator = 0;
        int yourSoldiers = armyUnitsSize;
        int enemySoldiers = armyUnitsSize;
        boolean victory = false;
        byte turnPlayer = 1;

        int yourLiveSoldiers = 0;
        int enemyLiveSoldiers = 0;
        boolean endFight = false;
        while (endFight == false) {
            for (int i = 0; i < armyUnitsSize; i++) {
                if (turnPlayer == 1) {
                    System.out.println("ROUND: " + round);
                    round++;
                    if (yourArmy[i].isLive()) {
                        yourArmy[i].attack(enemyArmy[random.nextInt(enemySoldiers)]);
                        turnPlayer = 2;
                    } else {
                        yourLiveSoldiers = howManySoldiers(yourArmy);
                        if (yourLiveSoldiers >= armyUnitsSize) {
                            endFight = true;
                            break;
                        }
                        continue;
                    }
                } else {
                    if (enemyArmy[i].isLive()) {
                        enemyArmy[i].attack(yourArmy[random.nextInt(yourSoldiers)]);
                        turnPlayer = 1;
                    } else {
                        enemyLiveSoldiers = howManySoldiers(yourArmy);
                        if (enemyLiveSoldiers >= armyUnitsSize) {
                            endFight = true;
                            break;
                        }
                        continue;
                    }
                }
            }
        }
    }


    public static int howManySoldiers(Monster[] army) {
        int crew = armyUnitsSize;
        for (int i = 0; i < armyUnitsSize; i++) {
            if (army[i].checkIfKilled())
                crew--;
        }
        System.out.println("CREW: "+crew);
        return crew;
    }

    public static int healthSum(Monster[] army) {
        int healthSum = 0;
        for (int i = 0; i < armyUnitsSize; i++) {
            healthSum+=army[i].getHealth();
        }
        return healthSum;
    }

    private static boolean victoryChecker(Monster[] fArmy, Monster[] sArmy) {
        int army1Crew = armyUnitsSize;
        int army2Crew = armyUnitsSize;
        for (int i = 0; i < armyUnitsSize; i++) {
            if (fArmy[i].checkIfKilled() == true)
                army1Crew--;
            if (sArmy[i].checkIfKilled() == true)
                army2Crew--;
        }
        if (army1Crew < 1) {
            System.out.println("First army lose");
            return true;
        }
        if (army2Crew < 1) {
            System.out.println("Second army lose");
            return true;
        }
        return false;
    }

    private static void armyGenerator(int armyUnitsSize, Monster[] Army, Random random) {
        int intMonsterType;
        for (int i = 0; i < armyUnitsSize; i++) {
            intMonsterType = random.nextInt(3) + 1;
            if (intMonsterType == 1)
                Army[i] = new Elf();
            if (intMonsterType == 2)
                Army[i] = new Archer();
            if (intMonsterType == 3)
                Army[i] = new Druid();
        }
    }
}
