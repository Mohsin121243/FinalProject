import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Order{
    private String itemType;
    private int index;
    private double cost;
    private int orderNumber;
    private ArrayList<Integer> orderNumberList;
    private ArrayList<Item> orderList;

    public Order(Item i){
        orderList = new ArrayList<>();
        orderList.add(i);
        orderNumberList = new ArrayList<>();
        boolean check = false;
        orderNumber = (int)(Math.random()*500);
        while(check == false){
            if(orderNumberList.size()>0){
                for(int p = 0;p<orderNumberList.size();p++){
                    if(orderNumber == orderNumberList.get(p)){
                        orderNumber = (int) (Math.random()*500);
                        check = true;

                    }
                }
            }
        }
    }

    public void addItem(Item i){
        orderList.add(i);
    }
    public void finishOrder()
    {String path = System.getProperty("user.dir") + "\\src\\Orders.txt";
            String text = "Hello";
        try {
            FileWriter fw = new FileWriter(path, true);
            fw.write("Order number "+orderNumber+": ");
            for(int z = 0 ;z< orderList.size();z++)
            {
                fw.write(orderList.get(z).getName()+ ":");
            }

            fw.close();
        }
        catch(IOException e) {
        }

    }
}