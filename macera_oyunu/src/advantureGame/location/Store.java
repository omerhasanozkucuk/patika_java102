package advantureGame.location;

import advantureGame.entity.Player;
import advantureGame.item.Armor;
import advantureGame.item.Item;
import advantureGame.item.Weapon;
import java.util.ArrayList;
import java.util.List;

public class Store extends Location {
    private List<Item> inventory = new ArrayList();

    public Store() {
        super("Mağaza", "Destekleyici eşyalar satın alabileceğin yer.");
    }

    public void addStock(Item item) {
        this.inventory.add(item);
    }

    public List<Item> getInventory() {
        return this.inventory;
    }

    public void enter(Player player) {
        this.setVisited(true);
        System.out.println(player.getName() + " mağazaya girdi.");
    }

    public void sell(Player player, Item item) {
        if (!player.getInventory().spendMoney(item.getValue())) {
            System.out.println("Yeterli paran yok.");
        } else {
            if (item instanceof Weapon) {
                player.getInventory().addWeapon((Weapon)item);
            } else if (item instanceof Armor) {
                player.getInventory().addArmor((Armor)item);
            } else {
                player.getInventory().addItem(item);
            }

            this.inventory.remove(item);
            System.out.println(item.getName() + " satın alındı.");
        }
    }
}
