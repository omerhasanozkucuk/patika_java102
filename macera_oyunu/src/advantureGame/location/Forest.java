package advantureGame.location;

import advantureGame.item.ConsumableItem;
import advantureGame.item.ItemType;
import advantureGame.monster.Vampire;

public class Forest extends BattleLocation {
    public Forest() {
        super("Orman", "Vampirlerin gizlendiği yoğun bir orman.", new ConsumableItem("Odun", ItemType.FIREWOOD, 0));
        int monsterCount = 1 + (int)(Math.random() * (double)3.0F);

        for(int i = 0; i < monsterCount; ++i) {
            this.addMonster(new Vampire());
        }

    }

    public boolean firstStrike() {
        return Math.random() < (double)0.5F;
    }
}
