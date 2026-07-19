
package advantureGame;

import advantureGame.entity.Player;
import advantureGame.item.Armor;
import advantureGame.item.Item;
import advantureGame.item.ItemType;
import advantureGame.item.Weapon;
import advantureGame.location.BattleLocation;
import advantureGame.location.Cave;
import advantureGame.location.Forest;
import advantureGame.location.Location;
import advantureGame.location.Mine;
import advantureGame.location.River;
import advantureGame.location.SafeHouse;
import advantureGame.location.Store;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Player player;
    private List<Location> locations = new ArrayList();
    private Scanner scanner;

    public Game() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== Macera Oyunu ===");
        System.out.print("Karakterinin adını gir: ");
        String name = this.scanner.nextLine();
        this.player = new Player(name, 100, 20);
        this.player.setEquippedWeapon(new Weapon("Yumruk", 0, 3, 0));
        this.setupLocations();
        boolean playing = true;

        while(playing && this.player.isAlive()) {
            this.printMenu();
            String choice = this.scanner.nextLine();
            if (choice.equalsIgnoreCase("q")) {
                playing = false;
            } else {
                Location selected = this.resolveChoice(choice);
                if (selected == null) {
                    System.out.println("Geçersiz seçim.");
                } else {
                    if (selected instanceof Store) {
                        this.handleStore((Store)selected);
                    } else {
                        this.navigate(selected);
                    }

                    if (selected instanceof SafeHouse && this.checkWinCondition()) {
                        System.out.println("\nTüm ödülleri toplayıp Güvenli Ev'e döndün. KAZANDIN!");
                        playing = false;
                    }
                }
            }
        }

        if (!this.player.isAlive()) {
            System.out.println("\nKaybettin...");
        }

    }

    private void setupLocations() {
        Store store = new Store();
        store.addStock(new Weapon("Tabanca", 15, 5, 1));
        store.addStock(new Weapon("Kılıç", 25, 8, 2));
        store.addStock(new Weapon("Tüfek", 40, 12, 3));
        store.addStock(new Armor("Hafif Zırh", 15, 5, 1));
        store.addStock(new Armor("Orta Zırh", 25, 8, 2));
        store.addStock(new Armor("Ağır Zırh", 40, 12, 3));
        this.locations.add(new SafeHouse());
        this.locations.add(new Cave());
        this.locations.add(new Forest());
        this.locations.add(new River());
        this.locations.add(new Mine());
        this.locations.add(store);
    }

    private void printMenu() {
        PrintStream var10000 = System.out;
        int var10001 = this.player.getHealth();
        var10000.println("\n--- Nereye gitmek istersin? (Can: " + var10001 + "/" + this.player.getMaxHealth() + ", Para: " + this.player.getInventory().getMoney() + ") ---");

        for(int i = 0; i < this.locations.size(); ++i) {
            Location loc = (Location)this.locations.get(i);
            String status = loc instanceof BattleLocation && loc.isCleared() ? " (temizlendi)" : "";
            System.out.println(i + 1 + ". " + loc.getName() + status);
        }

        System.out.println("q. Çıkış");
        System.out.print("Seçim: ");
    }

    private Location resolveChoice(String choice) {
        try {
            int index = Integer.parseInt(choice.trim()) - 1;
            if (index >= 0 && index < this.locations.size()) {
                return (Location)this.locations.get(index);
            }
        } catch (NumberFormatException var3) {
        }

        return null;
    }

    private void handleStore(Store store) {
        this.navigate(store);
        System.out.println("Satın almak istersen ürün numarasını gir, çıkmak için 0:");

        for(int i = 0; i < store.getInventory().size(); ++i) {
            System.out.println(i + 1 + ". " + ((Item)store.getInventory().get(i)).getName() + " - " + ((Item)store.getInventory().get(i)).getValue() + " para");
        }

        String input = this.scanner.nextLine();

        try {
            int index = Integer.parseInt(input.trim()) - 1;
            if (index >= 0 && index < store.getInventory().size()) {
                store.sell(this.player, (Item)store.getInventory().get(index));
            }
        } catch (NumberFormatException var4) {
        }

    }

    public void navigate(Location loc) {
        loc.enter(this.player);
    }

    public boolean checkWinCondition() {
        return this.allRewardsCollected();
    }

    public boolean allRewardsCollected() {
        return this.player.getInventory().hasItemType(ItemType.FOOD) && this.player.getInventory().hasItemType(ItemType.FIREWOOD) && this.player.getInventory().hasItemType(ItemType.WATER);
    }
}
