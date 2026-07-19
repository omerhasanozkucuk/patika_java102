package advantureGame.combat;

import advantureGame.item.Armor;
import advantureGame.item.LootType;
import advantureGame.item.Weapon;

public class LootManager {
    private static final int WEAPON_CHANCE = 15;
    private static final int ARMOR_CHANCE = 15;
    private static final int MONEY_CHANCE = 25;
    private static final int NOTHING_CHANCE = 45;

    public LootManager() {
    }

    public LootType rollLoot() {
        int roll = (int)(Math.random() * (double)100.0F) + 1;
        if (roll <= 15) {
            return LootType.WEAPON;
        } else if (roll <= 30) {
            return LootType.ARMOR;
        } else {
            return roll <= 55 ? LootType.MONEY : LootType.NONE;
        }
    }

    public Weapon rollWeapon() {
        int roll = (int)(Math.random() * (double)100.0F) + 1;
        if (roll <= 20) {
            return new Weapon("Tüfek", 40, 12, 3);
        } else {
            return roll <= 50 ? new Weapon("Kılıç", 25, 8, 2) : new Weapon("Tabanca", 15, 5, 1);
        }
    }

    public Armor rollArmor() {
        int roll = (int)(Math.random() * (double)100.0F) + 1;
        if (roll <= 20) {
            return new Armor("Ağır Zırh", 40, 12, 3);
        } else {
            return roll <= 50 ? new Armor("Orta Zırh", 25, 8, 2) : new Armor("Hafif Zırh", 15, 5, 1);
        }
    }

    public int rollMoney() {
        int roll = (int)(Math.random() * (double)100.0F) + 1;
        if (roll <= 20) {
            return 10;
        } else {
            return roll <= 50 ? 5 : 1;
        }
    }
}