package advantureGame.location;

import advantureGame.combat.CombatManager;
import advantureGame.entity.Player;
import advantureGame.item.Item;
import advantureGame.monster.Monster;
import java.util.ArrayList;
import java.util.List;

public abstract class BattleLocation extends Location {
    private List<Monster> monsters = new ArrayList();
    private Item reward;

    public BattleLocation(String name, String description, Item reward) {
        super(name, description);
        this.reward = reward;
    }

    protected void addMonster(Monster m) {
        this.monsters.add(m);
    }

    public abstract boolean firstStrike();

    public void battle(Player player) {
        CombatManager combatManager = new CombatManager();

        for(Monster monster : new ArrayList(this.monsters)) {
            if (!player.isAlive()) {
                break;
            }

            System.out.println("\n" + monster.getName() + " ile karşılaştın!");
            combatManager.startCombat(player, monster);
            if (player.isAlive()) {
                this.monsters.remove(monster);
                this.onMonsterDefeated(player, monster);
            }
        }

        if (player.isAlive() && this.monsters.isEmpty()) {
            this.setCleared(true);
            this.giveReward(player);
        }

    }

    protected void onMonsterDefeated(Player player, Monster monster) {
    }

    public void giveReward(Player player) {
        if (this.reward != null) {
            player.getInventory().addItem(this.reward);
            System.out.println(this.reward.getName() + " kazandın!");
        }

    }

    public void enter(Player player) {
        this.setVisited(true);
        if (this.isCleared()) {
            System.out.println("Bu bölge zaten temizlendi, tekrar giriş yapılamaz.");
        } else {
            this.battle(player);
        }
    }
}

