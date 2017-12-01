
public class Archer extends Monster {

    Archer(){
        this.setName("Archer");
        this.setAttack(5);
        this.setHealth(25);
        System.out.println(this.getName()+" Created");
    }
    Archer(int player){
        this.setName("Archer");
        this.setAttack(5);
        this.setHealth(25);
        this.setPlayer(player);
        System.out.println(this.getName()+" Created");
    }
}
