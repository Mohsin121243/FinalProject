import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Order{

    private int orderNumber;
    private ArrayList<String[]> orderNumberList;

    private double totalPrice;


    public ArrayList<Item> getOrderList() {
        return orderList;
    }

    private ArrayList<Item> orderList;

    public Order(Item i){
        totalPrice = 0;
        orderList = new ArrayList<>();
        orderList.add(i);
        orderNumberList = new ArrayList<>();
        boolean check = false;
        orderNumber = (int)(Math.random()*5000);
    }
    public Order(){
        orderList = new ArrayList<>();
        orderNumberList = new ArrayList<>();
        boolean check = false;
        orderNumber = (int)(Math.random()*5000);
    }

    public void getFullOrder(){
        System.out.print("Order Number "+ orderNumber+": ");
        for(Item i : orderList){
            System.out.print(i.getName()+" for " + i.getPrice() + ", ");
        }
    }

    public void addItem(Item i){
        totalPrice+= Double.parseDouble(i.getPrice().substring(1));
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
                pw.print(orderList.get(z).getName()+ ",");

            }

            fw.close();
        }
        catch(IOException e) {
        }

    }
    public void menuReader(){
        System.out.println("Welcome to Chick Fil A! How may I help you?");
        System.out.println("A. Breakfast");
        System.out.println("B. Entrees ");
        System.out.println("C. Sides");
        System.out.println("D. Beverages");
        System.out.println("E. Retrieve previous order");
        System.out.println("Type the letter of the food choice you would like!");
        Menu m = new Menu();
        Scanner s = new Scanner(System.in);
        String n = s.nextLine();
        if (n.toLowerCase().equals("a")) {
            for (int i = 0; i < m.getBreakFast().size(); i++) {
                System.out.println(i + ": " + m.getBreakFast().get(i).getName() + " for " + m.getBreakFast().get(i).getPrice());
            }
            System.out.println("Choose the item you want. Press 200 to exit back to main menu. Press 300 to recap your order. Press 400 to finish your order.");
            Scanner c = new Scanner(System.in);
            int y = c.nextInt();
            if (y < m.getBreakFast().size()) {
                addItem(m.getBreakFast().get((y)));
                System.out.println("Item Added!");
            } else {
                System.out.println("Item Not Found.");
            }

            while (y != 200&& y!=400) {
                System.out.println("Choose the item you want. Press 200 to exit back to main menu. Press 300 to recap your order. Press 400 to finish your order");
                y = c.nextInt();
                if (y == 300) {
                    if (getOrderList().size() > 0) {
                        getFullOrder();
                    }
                }
                if (y < m.getBreakFast().size()) {
                    addItem(m.getBreakFast().get((y)));
                    System.out.println("Item Added!");
                } else {
                    System.out.println("Item Not Found.");
                }


            }
            if(y== 200){
                menuReader();
            }
            if (y == 300) {
                if (getOrderList().size() > 0) {
                    getFullOrder();
                }
            } else {
                if (y < m.getBreakFast().size()&&y!= 300) {
                    addItem(m.getBreakFast().get((y)));
                    System.out.println("Item Added!");
                } else {
                    System.out.println("Item Not Found.");
                }
            }
            if(y==400){
                getFullOrder();
                finishOrder();
            }


        }
        if (n.toLowerCase().equals("b")) {
            for (int i = 0; i < m.getEntrees().size(); i++) {
                System.out.println(i + ": " + m.getEntrees().get(i).getName() + " for " + m.getEntrees().get(i).getPrice());
            }
            System.out.println("Choose the item you want. Press 200 to exit back to main menu. Press 300 to recap your order. Press 400 to finish your order");
            Scanner c = new Scanner(System.in);
            int y = c.nextInt();
            if (y < m.getEntrees().size()) {
                addItem(m.getEntrees().get((y)));
                System.out.println("Item Added!");
            } else {
                System.out.println("Item Not Found.");
            }

            while (y != 200&& y!=400) {
                System.out.println("Choose the item you want. Press 200 to exit back to main menu. Press 300 to recap your order. Press 400 to finish your order");
                y = c.nextInt();
                if (y == 300) {
                    if (getOrderList().size() > 0) {
                        getFullOrder();
                    }
                }
                if (y < m.getEntrees().size()) {
                    addItem(m.getEntrees().get((y)));
                    System.out.println("Item Added!");
                } else {
                    System.out.println("Item Not Found.");
                }


            }
            if(y== 200){
                menuReader();
            }
            if (y == 300) {
                if (getOrderList().size() > 0) {
                    getFullOrder();
                }
            } else {
                if (y < m.getEntrees().size()&& y!= 300) {
                    addItem(m.getEntrees().get((y)));
                    System.out.println("Item Added!");
                } else {
                    System.out.println("Item Not Found.");
                }
            }
            if(y==400){
                getFullOrder();
                finishOrder();
            }

        }
        if (n.toLowerCase().equals("c")) {
            for (int i = 0; i < m.getSides().size(); i++) {
                System.out.println(i + ": " + m.getSides().get(i).getName() + " for " + m.getSides().get(i).getPrice());
            }
            System.out.println("Choose the item you want. Press 200 to exit back to main menu. Press 300 to recap your order. Press 400 to finish your order.");
            Scanner c = new Scanner(System.in);
            int y = c.nextInt();
            if (y < m.getSides().size()) {
                addItem(m.getSides().get((y)));
                System.out.println("Item Added!");
            } else {
                System.out.println("Item Not Found.");
            }


            while (y != 200&&y!=400) {
                System.out.println("Choose the item you want. Press 200 to exit back to main menu. Press 300 to recap your order. Press 400 to finish your order");
                y = c.nextInt();
                if (y == 300) {
                    if (getOrderList().size() > 0) {
                        getFullOrder();
                    }
                }
                if (y < m.getSides().size()) {
                    addItem(m.getSides().get((y)));
                    System.out.println("Item Added!");
                } else {
                    System.out.println("Item Not Found.");
                }


            }
            if(y== 200){
                menuReader();
            }

            if (y == 300) {
                if (getOrderList().size() > 0) {
                    getFullOrder();
                }
            } else {
                if (y < m.getSides().size()&&y!= 300) {
                    addItem(m.getSides().get((y)));
                    System.out.println("Item Added!");
                } else {
                    System.out.println("Item Not Found.");
                }
            }
            if(y==400){
                getFullOrder();
                finishOrder();
            }


        }
        if (n.toLowerCase().equals("d")) {
            for (int i = 0; i < m.getBeverages().size(); i++) {
                System.out.println(i + ": " + m.getBeverages().get(i).getName() + " for " + m.getBeverages().get(i).getPrice());
            }
            System.out.println("Choose the item you want. Press 200 to exit back to main menu. Press 300 to recap your order");
            Scanner c = new Scanner(System.in);
            int y = c.nextInt();
            if (y < m.getBeverages().size()) {
                addItem(m.getBeverages().get((y)));
                System.out.println("Item Added!");
            } else {
                System.out.println("Item Not Found.");
            }

            while (y != 200 && y!=400) {
                System.out.println("Choose the item you want. Press 200 to exit back to main menu. Press 300 to recap your order");
                y = c.nextInt();
                if (y == 300) {
                    if (getOrderList().size() > 0) {
                        getFullOrder();
                    }
                }
                if (y < m.getBeverages().size()) {
                    addItem(m.getBeverages().get((y)));
                    System.out.println("Item Added!");
                } else {
                    System.out.println("Item Not Found.");
                }


            }
            if(y== 200){
                menuReader();
            }
            if (y == 300) {
                if (getOrderList().size() > 0) {
                    getFullOrder();
                }
            } else {
                if (y < m.getBeverages().size()&& y!=300) {
                    addItem(m.getBeverages().get((y)));
                    System.out.println("Item Added!");
                } else {
                    System.out.println("Item Not Found.");
                }
            }
            if(y==400){
                getFullOrder();
                finishOrder();
            }
        }
        if (n.toLowerCase().equals("e")){
            System.out.println("Type in your order number.");
            Scanner c = new Scanner(System.in);
            int y = c.nextInt();
            readOrders();
            retrieveOrderForFood(y);
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