package advantureGame.item;

public class Armor extends Item {
    private int defense;
    private int armorId;

    public Armor(String name, int value, int defense, int armorId) {
        super(name, ItemType.ARMOR, value);
        this.defense = defense;
        this.armorId = armorId;
    }

    public int getDefense() {
        return this.defense;
    }

    public int getArmorId() {
        return this.armorId;
    }
}