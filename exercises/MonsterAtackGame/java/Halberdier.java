public class Halberdier extends Monster{
    Halberdier(){
        this.setName("Halberdier");
        this.setAttack(10);
        this.setHealth(30);
        System.out.println(this.getName()+" Created");
    }

    Halberdier(int player){
        this.setName("Halberdier");
        this.setAttack(10);
        this.setHealth(30);
        this.setPlayer(player);
        System.out.println(this.getName()+" Created");
    }
}
