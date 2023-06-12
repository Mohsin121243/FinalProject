import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ChickFilA extends JFrame {
    private JButton orderButton;
    private JPanel Panel;
    private JLabel Starter;
    private JTextArea orders;
    private JTextField textField1;
    private JButton returnToMainMenuButton;
    private JButton finishOrderButton;
    private JButton submitRequestButton;
    private JScrollPane scroller;


    private ImageIcon logo;

    public ChickFilA(){
        setContentPane(Panel);
        setTitle("ChickFilA");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200,800);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setBackground(Color.RED);
        orders.setVisible(false);
        scroller.setVisible(false);
        returnToMainMenuButton.setVisible(false);
        finishOrderButton.setVisible(false);
        submitRequestButton.setVisible(false);
        textField1.setVisible(false);
        logo = new ImageIcon("src/Welcome.png");
        Image im = logo.getImage().getScaledInstance(950,250,Image.SCALE_SMOOTH);
        logo = new ImageIcon(im);
        Starter.setIcon(logo);


        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderButton.setVisible(false);
                ImageIcon Cashier = new ImageIcon("src/Squidward.jpg");
                Image Cash = Cashier.getImage().getScaledInstance(290,210,Image.SCALE_DEFAULT);
                Starter.setIcon(Cashier);
                Point p = Starter.getLocationOnScreen();
                setSize(1200,1040);
                orders.setVisible(true);
                orders.setEditable(false);
                textField1.setVisible(true);
                scroller.setVisible(true);
                scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                orders.setBackground(Color.RED);
                Order o = new Order();
                returnToMainMenuButton.setVisible(true);
                finishOrderButton.setVisible(true);
                submitRequestButton.setVisible(true);
                o.menuReader(orders,textField1,returnToMainMenuButton,submitRequestButton,finishOrderButton,Starter);

            }
        });



    }

    public static void main(String[] args) {
        new ChickFilA();
    }


}

