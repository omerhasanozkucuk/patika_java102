package advantureGame.item;

public abstract class Item {
    private String name;
    private ItemType type;
    private int value;

    public Item(String name, ItemType type, int value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemType getType() {
        return this.type;
    }

    public int getValue() {
        return this.value;

