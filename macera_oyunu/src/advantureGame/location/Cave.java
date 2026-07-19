
package advantureGame.location;

import advantureGame.item.ConsumableItem;
import advantureGame.item.ItemType;
import advantureGame.monster.Zombie;

public class Cave extends BattleLocation {
    public Cave() {
        super("Mağara", "Zombilerin gizlendiği karanlık bir mağara.", new ConsumableItem("Yemek", ItemType.FOOD, 0));
        int monsterCount = 1 + (int)(Math.random() * (double)3.0F);

        for(int i = 0; i < monsterCount; ++i) {
            this.addMonster(new Zombie());
        }

    }

    public boolean firstStrike() {
        return Math.random() < (double)0.5F;
    }
}