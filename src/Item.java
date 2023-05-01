public class Item {
    private String name;
    private double price;


    public Item(double price, String name){
        this.name = name;
        this.price = price;
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
