public class Item {
    private String name;
    private String price;
    private String description;

    private String itemType;


    public Item(String price, String name){
        this.name = name;
        this.price = price;
    }
    public Item(String price,String name, String description, String ItemType){
        this.name = name;
        this.price = price;
        this.description = description;
        this.itemType = ItemType;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String toString()
    {
        return name +" - " + price;

    }
    public String getItemType(){return itemType;}
    public void finder(){System.out.println( "Hello");}

}
