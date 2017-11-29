import java.util.Random;

public abstract class Monster {
    private String name;
    private int attack;
    private int health;
    private boolean live;
    private int Player;

    public Monster(){
        this("noname", 1, 5, true);
    }

    public Monster(String name, int attack, int health, boolean live){
        this.name = name;
        this.attack = attack;
        this.health = health;
        this.live = true;
    }

    public void kill(){
        this.live = false;
        System.out.println(this.name+" was killed");
    }

    public boolean isLive(){
        if(this.health>0)
            return true;
        return false;
    }

    public boolean checkIfKilled(){
        if(this.health>0){
            this.live = false;
            return false;
        }
        return true;
    }

    public void attack(Monster attackedMonster){
        Random random = new Random();
        int hit = random.nextInt(this.attack);
        System.out.print(this.name +"("+this.health+") atakuje "+ attackedMonster.name+"("+attackedMonster.health+")");
        damage(hit, attackedMonster);
    }

    public void damage(int hit, Monster attackedMonster){
        int tmpHealth = attackedMonster.getHealth()-hit;
        System.out.println(" -"+hit);
        attackedMonster.health-=hit;
        if(attackedMonster.health<1)
            attackedMonster.kill();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
