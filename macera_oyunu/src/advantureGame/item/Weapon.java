package advantureGame.item;

public class Weapon extends Item {
    private int damage;
    private int weaponId;

    public Weapon(String name, int value, int damage, int weaponId) {
        super(name, ItemType.WEAPON, value);
        this.damage = damage;
        this.weaponId = weaponId;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getWeaponId() {
        return this.weaponId;
    }
}
