package advantureGame.monster;

public class Zombie extends Monster {
    public Zombie() {
        super(1, "Zombi", 20, 5, (int)(Math.random() * (double)21.0F));
    }

    public int attack() {
        return this.getDamage();
    }
}
