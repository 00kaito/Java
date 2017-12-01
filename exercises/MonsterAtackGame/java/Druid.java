
public class Druid extends Monster{
    Druid(){
        this.setName("Druid");
        this.setAttack(7);
        this.setHealth(35);
        System.out.println(this.getName()+" Created");
    }
    Druid(int player){
        this.setName("Druid");
        this.setAttack(7);
        this.setHealth(35);
        this.setPlayer(player);
        System.out.println(this.getName()+" Created");
    }
}
