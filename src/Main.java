import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("What day is it?");
        Scanner p = new Scanner(System.in);
        String f = p.nextLine();
        if (!f.toLowerCase().equals("sunday")) {

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
            Order o = new Order();
            if (n.toLowerCase().equals("a")) {
                for (int i = 0; i < m.getBreakFast().size(); i++) {
                    System.out.println(i + ": " + m.getBreakFast().get(i).getName() + " for " + m.getBreakFast().get(i).getPrice());
                }
                System.out.println("Choose the item you want. Press 200 to exit back to main menu. Press 300 to recap your order");
                Scanner c = new Scanner(System.in);
                int y = c.nextInt();
                if (y < m.getBreakFast().size()) {
                    o.addItem(m.getBreakFast().get((y)));
                    System.out.println("Item Added!");
                } else {
                    System.out.println("Item Not Found.");
                }
                if(y== 200){
                    o.menuReader();
                }
                while (y != 200) {
                    System.out.println("Choose the item you want. Press 200 to exit back to main menu. Press 300 to recap your order");
                    y = c.nextInt();
                    if (y == 300) {
                        if (o.getOrderList().size() > 0) {
                            o.getFullOrder();
                        }
                    }
                    if (y < m.getBreakFast().size()) {
                        o.addItem(m.getBreakFast().get((y)));
                        System.out.println("Item Added!");
                    } else {
                        System.out.println("Item Not Found.");
                    }


                }
                if(y== 200){
                    o.menuReader();
                }
                if(y== 200){
                    o.menuReader();
                }
                if (y == 300) {
                    if (o.getOrderList().size() > 0) {
                        o.getFullOrder();
                    }
                } else {
                    if (y < m.getBreakFast().size()&&y!= 300) {
                        o.addItem(m.getBreakFast().get((y)));
                        System.out.println("Item Added!");
                    } else {
                        System.out.println("Item Not Found.");
                    }
                }


            }
            if (n.toLowerCase().equals("b")) {
                for (int i = 0; i < m.getEntrees().size(); i++) {
                    System.out.println(i + ": " + m.getEntrees().get(i).getName() + " for " + m.getEntrees().get(i).getPrice());
                }
                System.out.println("Choose the item you want. Press 200 to exit back to main menu. Press 300 to recap your order");
                Scanner c = new Scanner(System.in);
                int y = c.nextInt();
                if (y < m.getEntrees().size()) {
                    o.addItem(m.getEntrees().get((y)));
                    System.out.println("Item Added!");
                } else {
                    System.out.println("Item Not Found.");
                }
                if(y== 200){
                    o.menuReader();
                }
                while (y != 200) {
                    System.out.println("Choose the item you want. Press 200 to exit back to main menu. Press 300 to recap your order");
                    y = c.nextInt();
                    if (y == 300) {
                        if (o.getOrderList().size() > 0) {
                            o.getFullOrder();
                        }
                    }
                    if (y < m.getEntrees().size()) {
                        o.addItem(m.getEntrees().get((y)));
                        System.out.println("Item Added!");
                    } else {
                        System.out.println("Item Not Found.");
                    }


                }
                if(y== 200){
                    o.menuReader();
                }
                if (y == 300) {
                    if (o.getOrderList().size() > 0) {
                        o.getFullOrder();
                    }
                } else {
                    if (y < m.getEntrees().size()&& y!= 300) {
                        o.addItem(m.getEntrees().get((y)));
                        System.out.println("Item Added!");
                    } else {
                        System.out.println("Item Not Found.");
                    }
                }

            }
            if (n.toLowerCase().equals("c")) {
                for (int i = 0; i < m.getSides().size(); i++) {
                    System.out.println(i + ": " + m.getSides().get(i).getName() + " for " + m.getSides().get(i).getPrice());
                }
                System.out.println("Choose the item you want. Press 200 to exit back to main menu. Press 300 to recap your order");
                Scanner c = new Scanner(System.in);
                int y = c.nextInt();
                if (y < m.getSides().size()) {
                    o.addItem(m.getSides().get((y)));
                    System.out.println("Item Added!");
                } else {
                    System.out.println("Item Not Found.");
                }

                while (y != 200) {
                    System.out.println("Choose the item you want. Press 200 to exit back to main menu. Press 300 to recap your order");
                    y = c.nextInt();
                    if (y == 300) {
                        if (o.getOrderList().size() > 0) {
                            o.getFullOrder();
                        }
                    }
                    if (y < m.getSides().size()) {
                        o.addItem(m.getSides().get((y)));
                        System.out.println("Item Added!");
                    } else {
                        System.out.println("Item Not Found.");
                    }


                }
                if(y== 200){
                    o.menuReader();
                }
                if (y == 300) {
                    if (o.getOrderList().size() > 0) {
                        o.getFullOrder();
                    }
                } else {
                    if (y < m.getSides().size()&&y!= 300) {
                        o.addItem(m.getSides().get((y)));
                        System.out.println("Item Added!");
                    } else {
                        System.out.println("Item Not Found.");
                    }
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
                    o.addItem(m.getBeverages().get((y)));
                    System.out.println("Item Added!");
                } else {
                    System.out.println("Item Not Found.");
                }

                while (y != 200) {
                    System.out.println("Choose the item you want. Press 200 to exit back to main menu. Press 300 to recap your order");
                    y = c.nextInt();
                    if (y == 300) {
                        if (o.getOrderList().size() > 0) {
                            o.getFullOrder();
                        }
                    }
                    if (y < m.getBeverages().size()) {
                        o.addItem(m.getBeverages().get((y)));
                        System.out.println("Item Added!");
                    } else {
                        System.out.println("Item Not Found.");
                    }


                }
                if(y== 200){
                    o.menuReader();
                }

                if (y == 300) {
                    if (o.getOrderList().size() > 0) {
                        o.getFullOrder();
                    }
                } else {
                    if (y < m.getBeverages().size()&& y!=300) {
                        o.addItem(m.getBeverages().get((y)));
                        System.out.println("Item Added!");
                    } else {
                        System.out.println("Item Not Found.");
                    }
                }
            }


        }
        else{System.out.println("Go to Church Dummy!");}
    }

}
