package advantureGame.monster;

public class Bear extends Monster {
    public Bear() {
        super(3, "Ayı", 30, 10, (int)(Math.random() * (double)51.0F));
    }

    public int attack() {
        return this.getDamage();
    }
}