package advantureGame.monster;

public class Snake extends Monster {
    public Snake() {
        super(4, "Yılan", 12, 0, 0);
    }

    public int rollDamage() {
        return 3 + (int)(Math.random() * (double)4.0F);
    }

    public int attack() {
        return this.rollDamage();
    }
}

