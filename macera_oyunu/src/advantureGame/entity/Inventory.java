package advantureGame.entity;

import advantureGame.item.Armor;
import advantureGame.item.Item;
import advantureGame.item.ItemType;
import advantureGame.item.Weapon;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Weapon> weapons = new ArrayList();
    private List<Armor> armors = new ArrayList();
    private List<Item> items = new ArrayList();
    private int money;

    public Inventory(int startingMoney) {
        this.money = startingMoney;
    }

    public void addWeapon(Weapon w) {
        this.weapons.add(w);
    }

    public void addArmor(Armor a) {
        this.armors.add(a);
    }

    public void addItem(Item i) {
        this.items.add(i);
    }

    public void addMoney(int amount) {
        this.money += amount;
    }

    public boolean spendMoney(int amount) {
        if (this.money >= amount) {
            this.money -= amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean hasItemType(ItemType type) {
        for(Item i : this.items) {
            if (i.getType() == type) {
                return true;
            }
        }

        return false;
    }

    public List<Weapon> getWeapons() {
        return this.weapons;
    }

    public List<Armor> getArmors() {
        return this.armors;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public int getMoney() {
        return this.money;
    }
}
