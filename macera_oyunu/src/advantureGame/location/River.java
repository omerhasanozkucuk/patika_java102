package advantureGame.location;

import advantureGame.item.ConsumableItem;
import advantureGame.item.ItemType;
import advantureGame.monster.Bear;

public class River extends BattleLocation {
    public River() {
        super("Nehir", "Ayıların dolaştığı bir nehir kıyısı.", new ConsumableItem("Su", ItemType.WATER, 0));
        int monsterCount = 1 + (int)(Math.random() * (double)3.0F);

        for(int i = 0; i < monsterCount; ++i) {
            this.addMonster(new Bear());
        }

    }

    public boolean firstStrike() {
        return Math.random() < (double)0.5F;
    }
}
