import java.util.Random;

public class Main {
    static int armyUnitsSize = 5;

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
        System.out.println("Your health: " + healthSum(yourArmy) + "Enemy Health: " + healthSum(enemyArmy));

    }

    private static void fight(Monster[] yourArmy, Monster[] enemyArmy) {
        int round = 1;
        boolean player1 = false;
        boolean player2 = false;
        while (player1 == false && player2 == false) {
            System.out.println("______ROUND: " + round+"____________");
            round++;
            player1 = fight2(yourArmy, enemyArmy);
            player2 = fight2(enemyArmy, yourArmy);
        }
        if (player1 == true)
            System.out.println("Player 2 win");
        if (player2 == true)
            System.out.println("Player 1 win");
    }

    public static boolean fight2(Monster[] attackerArmy, Monster[] defenderArmy) {
        int tmp;
        boolean endFight = false;
        Random random = new Random();
        for (int i = 0; i < armyUnitsSize; i++) {
            if (attackerArmy[i].isLive()) {
                tmp = random.nextInt(armyUnitsSize);
                if (defenderArmy[tmp].isLive()) {
                    attackerArmy[i].attack(defenderArmy[tmp]);
                    return false;
                }
                else {
                    System.out.println("You can not kill " + defenderArmy[tmp].getName() + " for the second time");
                    if (howManySoldiersRemained(defenderArmy) == 0) {
                        endFight = true;
                        return endFight;
                    }
                }
            }
        }
        return endFight;
    }

    public static int howManySoldiersRemained(Monster[] army) {
        int crew = armyUnitsSize;
        for (int i = 0; i < armyUnitsSize; i++) {
            if (army[i].checkIfKilled())
                crew--;
        }
        System.out.println("CREW: " + crew);
        return crew;
    }

    public static int healthSum(Monster[] army) {
        int healthSum = 0;
        for (int i = 0; i < armyUnitsSize; i++) {
            healthSum += army[i].getHealth();
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
            intMonsterType = random.nextInt(6) + 1;
            if (intMonsterType == 1)
                Army[i] = new Elf();
            if (intMonsterType == 2)
                Army[i] = new Archer();
            if (intMonsterType == 3)
                Army[i] = new Druid();
            if (intMonsterType == 4)
                Army[i] = new Halberdier();
            if (intMonsterType == 5)
                Army[i] = new Monk();
            if (intMonsterType == 6)
                Army[i] = new Swordfish();
        }
    }
}
