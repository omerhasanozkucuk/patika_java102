package advantureGame.location;

import advantureGame.combat.LootManager;
import advantureGame.entity.Player;
import advantureGame.item.Armor;
import advantureGame.item.Item;
import advantureGame.item.LootType;
import advantureGame.item.Weapon;
import advantureGame.monster.Monster;
import advantureGame.monster.Snake;

public class Mine extends BattleLocation {
    private LootManager lootManager = new LootManager();

    public Mine() {
        super("Maden", "Yılanların pusuda beklediği bir maden ocağı.", (Item)null);
        int monsterCount = 1 + (int)(Math.random() * (double)5.0F);

        for(int i = 0; i < monsterCount; ++i) {
            this.addMonster(new Snake());
        }

    }

    public boolean firstStrike() {
        return Math.random() < (double)0.5F;
    }

    public LootType rollLoot() {
        return this.lootManager.rollLoot();
    }

    protected void onMonsterDefeated(Player player, Monster monster) {
        LootType loot = this.lootManager.rollLoot();
        switch (loot) {
            case WEAPON:
                Weapon weapon = this.lootManager.rollWeapon();
                player.getInventory().addWeapon(weapon);
                System.out.println(weapon.getName() + " kazandın!");
                break;
            case ARMOR:
                Armor armor = this.lootManager.rollArmor();
                player.getInventory().addArmor(armor);
                System.out.println(armor.getName() + " kazandın!");
                break;
            case MONEY:
                int amount = this.lootManager.rollMoney();
                player.getInventory().addMoney(amount);
                System.out.println(amount + " para kazandın!");
                break;
            case NONE:
            default:
                System.out.println("Bu yılandan bir şey çıkmadı.");
        }

    }

    public void giveReward(Player player) {
    }
}

