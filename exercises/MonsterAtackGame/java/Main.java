import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    static int numberOfSoldiers = 4;

    public static void main(String[] args) {
        Random random = new Random();

        List<Monster> player1 = new ArrayList<>();
        List<Monster> player2 = new ArrayList<>();

        System.out.println("GENERATRE MY ARMY");
        player1 = fillMonsterList(1);
        System.out.println(player1);
        System.out.println("GENERATE ENEMY AMRY");
        player2 = fillMonsterList(2);

        System.out.println(player2);
        Fight2NewCode(player1, player2, 0, 0, 0);

        System.out.println("Summary");
        System.out.println("Your health: " + healthSum(player1) + "Enemy Health: " + healthSum(player2));

    }

    private static List<Monster> fillMonsterList(int player) {
        List<Monster> monsters = new ArrayList<>();
        Random random = new Random();
        int intMonsterType;
        for (int i = 0; i < numberOfSoldiers; i++) {
            intMonsterType = random.nextInt(6) + 1;
            if (intMonsterType == 1)
                monsters.add(new Elf(player));
            if (intMonsterType == 2)
                monsters.add(new Archer(player));
            if (intMonsterType == 3)
                monsters.add(new Druid(player));
            if (intMonsterType == 4)
                monsters.add(new Halberdier(player));
            if (intMonsterType == 5)
                monsters.add(new Monk(player));
            if (intMonsterType == 6)
                monsters.add(new Swordfish(player));
        }
        return monsters;
    }

    private static void refreshLiveMonsterList(List<Monster> monsters) {

        for (int i = monsters.size() - 1; i >= 0; i--) {
            if (!monsters.get(i).isLive())
                monsters.remove(i);
        }
    }

    private static boolean Fight2NewCode(List<Monster> attacker, List<Monster> defender, int next1, int next2, int round) {
        int randDefenderMonster;
        boolean fight = true;
        Random random = new Random();

        if (attacker.get(next1).getPlayer() == 1) {
            System.out.println("P1 Attacker index:"+ next1 + "armySize:"+attacker.size());
            round++;
            System.out.println("Round: "+round);
            System.out.print("Player1: ");
            randDefenderMonster = random.nextInt(defender.size());
            attacker.get(next1).attack(defender.get(randDefenderMonster));
            refreshLiveMonsterList(defender);
            next1++;
            if (next1 >= attacker.size() - 1)
                next1 = 0;
            if (next2 >= defender.size() - 1)
                next2 = 0;
        }

        if (attacker.get(next2).getPlayer() == 2) {
            System.out.println("P2 Attacker index:"+ next1 + "armySize:"+attacker.size());
            System.out.print("Player2: ");
                randDefenderMonster = random.nextInt(defender.size());
                attacker.get(next2).attack(defender.get(randDefenderMonster));
                refreshLiveMonsterList(defender);
                next2++;
                if (next2 >= attacker.size() - 1)
                    next2 = 0;
                if (next1 >= defender.size() - 1)
                    next1 = 0;

            showTheBoard(defender, attacker, numberOfSoldiers);
        }

        if (attacker.size() == 0 || defender.size() == 0) {
            fight = false;
        } else {
            Fight2NewCode(defender, attacker, next1, next2, round);
        }
        return fight;
    }


    public static int healthSum(List<Monster> army) {
        int healthSum = 0;
        for (int i = 0; i < army.size(); i++) {
            healthSum += army.get(i).getHealth();
        }
        return healthSum;
    }

    public static void showTheBoard(List<Monster> player1, List<Monster> player2, int initialArmySize){
        System.out.println("________BOARD_______");
        for (int i=0; i<initialArmySize; i++){
            if (player1.size()>0 && player1.size()>i) {
                System.out.print(player1.get(i).getName() + "(" + player1.get(i).getHealth() + ")" + " - ");
            }
            else{
                System.out.print("(dead) - ");
            }
            if (player2.size()>0 && player2.size()>i){
                System.out.print(player2.get(i).getName() + "(" + player2.get(i).getHealth()+")");
            }
            else{
                System.out.print("(dead)");
            }
            System.out.println("");
        }
        System.out.println("________________________");
        System.out.println("");
        System.out.println("");
    }

}
