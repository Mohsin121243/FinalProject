import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Order extends JFrame{

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

    public void getFullOrder(JTextArea outliner){
        outliner.append("\n"+"Order Number "+ orderNumber+": ");
        double total =0;
        for(Item i : orderList){
            total+= Double.parseDouble(i.getPrice().substring(1));
            outliner.append("\n"+i.getName()+" for " + i.getPrice() + ", ");
        }
        outliner.append("\n"+total);

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

    public void menuReader(JTextArea outliner,JTextField reader,JButton menu, JButton submit, JButton finish,JLabel pic){
        outliner.setText("Welcome to Chick Fil A! How may I help you?"
                        +"\nA. Breakfast"
                        +"\nB. Entrees "
                        +"\nC. Sides"
                        +"\nD. Beverages"
                        +"\nE. Retrieve previous order"
                        +"\nType the letter of the food choice you would like!");
        Menu m = new Menu();
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n = reader.getText();
                if (n.toLowerCase().equals("a")) {
                    for (int i = 0; i < m.getBreakFast().size(); i++) {
                        if(i==0){
                            outliner.setText(i + ": " + m.getBreakFast().get(i).getName() + " for " + m.getBreakFast().get(i).getPrice());
                        }
                        outliner.append("\n"+ i + ": " + m.getBreakFast().get(i).getName() + " for " + m.getBreakFast().get(i).getPrice());
                    }
                    outliner.append("\n"+"Choose the item you want. Press 'Return to main menu' to exit back to main menu. Press 300 to recap your order. Press 'Finish Order' to finish your order.");
                    submit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                int y = Integer.parseInt(reader.getText());
                                if (y < m.getBreakFast().size()) {
                                    addItem(m.getBreakFast().get((y)));
                                    outliner.append("\n"+"Item Added!");
                                } else {
                                    outliner.append("\n"+"Item Not Found.");
                                }
                                outliner.append("\n"+"Choose the item you want. Press 'Return to main menu' to exit back to main menu. Press 300 to recap your order. Press 'Finish Order' to finish your order.");
                            ImageIcon Cashier = new ImageIcon("src/SquidGif.gif");
                            Image Cash = Cashier.getImage().getScaledInstance(290,210,Image.SCALE_DEFAULT);
                            pic.setIcon(Cashier);
                            menu.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    menuReader(outliner, reader, menu, submit, finish,pic);
                                }
                            });
                            if (y == 300) {
                                if (getOrderList().size() > 0) {
                                    getFullOrder(outliner);
                                }
                            }
                            finish.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    finishOrder();
                                }
                            });

                        }
                    });


                }
                if (n.toLowerCase().equals("b")) {
                    for (int i = 0; i < m.getEntrees().size(); i++) {
                        if(i==0){
                            outliner.setText(i + ": " + m.getEntrees().get(i).getName() + " for " + m.getEntrees().get(i).getPrice());
                        }
                        outliner.append("\n"+ i + ": " + m.getEntrees().get(i).getName() + " for " + m.getEntrees().get(i).getPrice());
                    }
                    outliner.append("\n"+"Choose the item you want. Press 'Return to main menu' to exit back to main menu. Press 300 to recap your order. Press 'Finish Order' to finish your order.");
                    submit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int y = Integer.parseInt(reader.getText());
                            if (y < m.getEntrees().size()) {
                                addItem(m.getEntrees().get((y)));
                                outliner.append("\n"+"Item Added!");
                            } else {
                                outliner.append("\n"+"Item Not Found.");
                            }
                            outliner.append("\n"+"Choose the item you want. Press 'Return to main menu' to exit back to main menu. Press 300 to recap your order. Press 'Finish Order' to finish your order.");
                            ImageIcon Cashier = new ImageIcon("src/SquidGif.gif");
                            Image Cash = Cashier.getImage().getScaledInstance(290,210,Image.SCALE_DEFAULT);
                            pic.setIcon(Cashier);
                            menu.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    menuReader(outliner, reader, menu, submit, finish,pic);
                                }
                            });
                            if (y == 300) {
                                if (getOrderList().size() > 0) {
                                    getFullOrder(outliner);
                                }
                            }
                            finish.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    finishOrder();
                                }
                            });

                        }
                    });

                }
                if (n.toLowerCase().equals("c")) {
                    for (int i = 0; i < m.getSides().size(); i++) {
                        if(i==0){
                            outliner.setText(i + ": " + m.getSides().get(i).getName() + " for " + m.getSides().get(i).getPrice());
                        }
                        outliner.append("\n"+ i + ": " + m.getSides().get(i).getName() + " for " + m.getSides().get(i).getPrice());
                    }
                    outliner.append("\n"+"Choose the item you want. Press 'Return to main menu' to exit back to main menu. Press 300 to recap your order. Press 'Finish Order' to finish your order.");
                    submit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int y = Integer.parseInt(reader.getText());
                            if (y < m.getSides().size()) {
                                addItem(m.getSides().get((y)));
                                outliner.append("\n"+"Item Added!");
                            } else {
                                outliner.append("\n"+"Item Not Found.");
                            }
                            outliner.append("\n"+"Choose the item you want. Press 'Return to main menu' to exit back to main menu. Press 300 to recap your order. Press 'Finish Order' to finish your order.");
                            ImageIcon Cashier = new ImageIcon("src/SquidGif.gif");
                            Image Cash = Cashier.getImage().getScaledInstance(290,210,Image.SCALE_DEFAULT);
                            pic.setIcon(Cashier);
                            menu.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    menuReader(outliner, reader, menu, submit, finish,pic);
                                }
                            });
                            if (y == 300) {
                                if (getOrderList().size() > 0) {
                                    getFullOrder(outliner);
                                }
                            }
                            finish.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    finishOrder();
                                }
                            });

                        }
                    });

                }
                if (n.toLowerCase().equals("d")) {
                    for (int i = 0; i < m.getBeverages().size(); i++) {
                        if(i==0){
                            outliner.setText(i + ": " + m.getBeverages().get(i).getName() + " for " + m.getBeverages().get(i).getPrice());
                        }
                        outliner.append("\n"+ i + ": " + m.getBeverages().get(i).getName() + " for " + m.getBeverages().get(i).getPrice());
                    }
                    outliner.append("\n"+"Choose the item you want. Press 'Return to main menu' to exit back to main menu. Press 300 to recap your order. Press 'Finish Order' to finish your order.");
                    submit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int y = Integer.parseInt(reader.getText());
                            if (y < m.getBeverages().size()) {
                                addItem(m.getBeverages().get((y)));
                                outliner.append("\n"+"Item Added!");
                            } else {
                                outliner.append("\n"+"Item Not Found.");
                            }
                            outliner.append("\n"+"Choose the item you want. Press 'Return to main menu' to exit back to main menu. Press 300 to recap your order. Press 'Finish Order' to finish your order.");
                            ImageIcon Cashier = new ImageIcon("src/SquidGif.gif");
                            Image Cash = Cashier.getImage().getScaledInstance(290,210,Image.SCALE_DEFAULT);
                            pic.setIcon(Cashier);
                            menu.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    menuReader(outliner, reader, menu, submit, finish,pic);
                                }
                            });
                            if (y == 300) {
                                if (getOrderList().size() > 0) {
                                    getFullOrder(outliner);
                                }
                            }
                            finish.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    finishOrder();
                                }
                            });

                        }
                    });
                }
                if (n.toLowerCase().equals("e")){
                    outliner.append("Type in your order number.");
                    submit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int orderNumber = Integer.parseInt(reader.getText());
                            readOrders();
                            retrieveOrderForFood(orderNumber,outliner);
                        }
                    });

                }
            }
        });


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
    public void retrieveOrderForFood(int orderNumberr, JTextArea outliner){
        boolean value = false;
        if(orderNumberList!= null){
            for (String[] strings : orderNumberList) {
                if (Integer.parseInt(strings[0].substring(13)) == orderNumberr&& value == false) {
                    outliner.append("\n"+strings[0] +": "+ strings[1] + "\n" + "Order Retrieved!");
                    value= true;

                }
            }}
        if(!value){outliner.append("\n"+"Order Not Found");}
    }
}