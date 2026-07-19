package advantureGame.monster;

public abstract class Monster {
    private int id;
    private String name;
    private int health;
    private int damage;
    private int money;

    public Monster(int id, String name, int health, int damage, int money) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.money = money;
    }

    public abstract int attack();

    public boolean isAlive() {
        return this.health > 0;
    }

    public void takeDamage(int dmg) {
        this.health -= dmg;
        if (this.health < 0) {
            this.health = 0;
        }

    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getMoney() {
        return this.money;
    }
}
