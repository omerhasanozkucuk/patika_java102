package advantureGame.monster;

public class Vampire extends Monster {
    public Vampire() {
        super(2, "Vampir", 15, 8, (int)(Math.random() * (double)31.0F));
    }

    public int attack() {
        return this.getDamage();
    }
}
