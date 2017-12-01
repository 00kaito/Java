public class Swordfish extends Monster {
    Swordfish(){
        this.setName("Swordfish");
        this.setAttack(9);
        this.setHealth(40);
        System.out.println(this.getName()+" Created");
    }

    Swordfish(int player){
        this.setName("Swordfish");
        this.setAttack(9);
        this.setHealth(40);
        this.setPlayer(player);
        System.out.println(this.getName()+" Created");
    }
}
