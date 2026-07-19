package advantureGame.location;

import advantureGame.entity.Player;

public class SafeHouse extends Location {
    private int healAmount = 9999;

    public SafeHouse() {
        super("Güvenli Ev", "Can yenileyebileceğin güvenli bir alan.");
    }

    public void enter(Player player) {
        this.setVisited(true);
        this.healPlayer(player);
        System.out.println(player.getName() + " Güvenli Ev'e girdi ve tamamen iyileşti.");
    }

    public void healPlayer(Player player) {
        player.heal(this.healAmount);
    }
}
