package advantureGame.location;

import advantureGame.entity.Player;

public abstract class Location {
    private String name;
    private String description;
    private boolean isVisited;
    private boolean isCleared;

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public abstract void enter(Player var1);

    public boolean isCleared() {
        return this.isCleared;
    }

    protected void setCleared(boolean cleared) {
        this.isCleared = cleared;
    }

    public void giveReward(Player player) {
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isVisited() {
        return this.isVisited;
    }

    public void setVisited(boolean visited) {
        this.isVisited = visited;
    }
}
