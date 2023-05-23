import java.io.*;
import java.util.ArrayList;

public class Order{
    private String itemType;
    private int index;
    private double cost;
    private int orderNumber;
    private ArrayList<String[]> orderNumberList;

    public String getItemType() {
        return itemType;
    }

    public int getIndex() {
        return index;
    }

    public double getCost() {
        return cost;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public ArrayList<String[]> getOrderNumberList() {
        return orderNumberList;
    }

    public ArrayList<Item> getOrderList() {
        return orderList;
    }

    private ArrayList<Item> orderList;

    public Order(Item i){
        orderList = new ArrayList<>();
        orderList.add(i);
        orderNumberList = new ArrayList<>();
        boolean check = false;
        orderNumber = (int)(Math.random()*5000);
    }

    public void addItem(Item i){
        orderList.add(i);
    }
    public void finishOrder()
    {String path = System.getProperty("user.dir") + "\\src\\Orders.txt";
        try {
            System.getProperty("line.separator");
            FileWriter fw = new FileWriter(path, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.print("Order number "+orderNumber+": ");
            for(int z = 0 ;z< orderList.size();z++)
            {
                pw.println(orderList.get(z).getName()+ ",");

            }

            fw.close();
        }
        catch(IOException e) {
        }

    }
    public void readOrders(){
        try
        {
            FileReader fileReader = new FileReader("src/Orders.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();


            while ((line = bufferedReader.readLine()) != null)
            {
                String[] menuFromCSV = line.split(": ");
                if(menuFromCSV.length >=2){
                    orderNumberList.add(menuFromCSV);}
            }
            bufferedReader.close();
        }
        catch(IOException exception)
        {
            // Print out the exception that occurred
            System.out.println("Unable to access " + exception.getMessage());
        }
    }
    public void retrieveOrderForFood(int orderNumberr){
        boolean value = false;
        if(orderNumberList!= null){
            for (String[] strings : orderNumberList) {
                if (Integer.parseInt(strings[0].substring(13)) == orderNumberr&& value == false) {
                    System.out.println(strings[0] +": "+ strings[1] + "\n" + "Order Retrieved!");
                    value= true;

                }
            }}
        if(!value){System.out.println("Order Not Found");}
    }
}