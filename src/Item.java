public class Item {
    private String name;
    private double price;
    private String description;

    private String itemType;


    public Item(double price, String name){
        this.name = name;
        this.price = price;
    }
    public Item(double price,String name, String description, String ItemType){
        this.name = name;
        this.price = price;
        this.description = description;
        this.itemType = ItemType;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String toString()
    {
        return name +" - " + price;

    }

}
