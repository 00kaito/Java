
public class Elf extends Monster{
    Elf(){
        this.setName("Elf");
        this.setAttack(10);
        this.setHealth(15);
        System.out.println(this.getName()+" Created");
    }

    Elf(int player){
        this.setName("Elf");
        this.setAttack(10);
        this.setHealth(15);
        this.setPlayer(player);
        System.out.println(this.getName()+" Created");
    }
}
