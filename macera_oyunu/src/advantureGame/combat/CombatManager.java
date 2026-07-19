
package advantureGame.combat;

import advantureGame.entity.Player;
import advantureGame.monster.Monster;
import java.io.PrintStream;

public class CombatManager {
    public CombatManager() {
    }

    public void startCombat(Player player, Monster monster) {
        boolean playerStarts = this.firstStrikeRoll();
        PrintStream var10000 = System.out;
        String var10001 = playerStarts ? player.getName() : monster.getName();
        var10000.println(var10001 + " ilk hamleyi yapıyor!");

        while(player.isAlive() && monster.isAlive()) {
            if (playerStarts) {
                this.playerTurn(player, monster);
                if (monster.isAlive()) {
                    this.monsterTurn(player, monster);
                }
            } else {
                this.monsterTurn(player, monster);
                if (player.isAlive()) {
                    this.playerTurn(player, monster);
                }
            }
        }

        if (player.isAlive()) {
            System.out.println(monster.getName() + " yenildi!");
            int money = monster.getMoney();
            if (money > 0) {
                player.getInventory().addMoney(money);
                System.out.println(money + " para kazandın.");
            }
        } else {
            System.out.println(player.getName() + " yenildi...");
        }

    }

    public boolean firstStrikeRoll() {
        return Math.random() < (double)0.5F;
    }

    public void playerTurn(Player player, Monster monster) {
        int dmg = player.attack();
        monster.takeDamage(dmg);
        PrintStream var10000 = System.out;
        String var10001 = player.getName();
        var10000.println(var10001 + " " + dmg + " hasar verdi. (" + monster.getName() + " can: " + monster.getHealth() + ")");
    }

    public void monsterTurn(Player player, Monster monster) {
        int dmg = monster.attack();
        player.takeDamage(dmg);
        PrintStream var10000 = System.out;
        String var10001 = monster.getName();
        var10000.println(var10001 + " " + dmg + " hasar verdi. (" + player.getName() + " can: " + player.getHealth() + ")");
    }
}

