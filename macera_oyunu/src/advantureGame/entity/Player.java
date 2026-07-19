
package advantureGame.entity;

import advantureGame.item.Armor;
import advantureGame.item.Weapon;

public class Player {
    private String name;
    private int health;
    private int maxHealth;
    private Inventory inventory;
    private Weapon equippedWeapon;
    private Armor equippedArmor;

    public Player(String name, int maxHealth, int startingMoney) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.inventory = new Inventory(startingMoney);
    }

    public int attack() {
        int baseDamage = 3;
        if (this.equippedWeapon != null) {
            baseDamage += this.equippedWeapon.getDamage();
        }

        return baseDamage;
    }

    public void takeDamage(int dmg) {
        int defense = this.equippedArmor != null ? this.equippedArmor.getDefense() : 0;
        int actualDamage = Math.max(0, dmg - defense);
        this.health -= actualDamage;
        if (this.health < 0) {
            this.health = 0;
        }

    }

    public void heal(int amount) {
        this.health = Math.min(this.maxHealth, this.health + amount);
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public Weapon getEquippedWeapon() {
        return this.equippedWeapon;
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public Armor getEquippedArmor() {
        return this.equippedArmor;
    }

    public void setEquippedArmor(Armor equippedArmor) {
        this.equippedArmor = equippedArmor;
    }
}