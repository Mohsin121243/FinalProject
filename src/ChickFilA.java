import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Scanner;

public class ChickFilA extends JFrame implements ActionListener, ItemListener {

    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JLabel welcomeLabel;
    private JTextArea textArea;

    public ChickFilA() {
        super("Frame title");
        init();
    }

    private void init() {
        // setting up the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocation(300, 50);

        // create the MenuBar and menu components
        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("File");
        JMenuItem menuItem1 = new JMenuItem("Open");
        JMenuItem menuItem2 = new JMenuItem("Save as");
        menu1.add(menuItem1);
        menu1.add(menuItem2);
        JMenu menu2 = new JMenu("Help");

        // add "File" and "Help" menus to the MenuBar
        menuBar.add(menu1);
        menuBar.add(menu2);

        // create the big text area located in the middle
        textArea = new JTextArea();

        // create welcome label
        welcomeLabel = new JLabel("Welcome to Chick Fil A");
        welcomeLabel.setFont(new Font("Helvetica", Font.BOLD, 20));

        // create slider and adjust settings
        JSlider slider = new JSlider(0, 40, 20);
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        // create a panel for organizing the label and slider
        JPanel sliderPanel = new JPanel();

        // add label and slider, in left-to-right order
        sliderPanel.add(welcomeLabel);
        sliderPanel.add(slider);

        // create the components at the bottom
        JLabel label = new JLabel("Enter Text");
        JTextField textField = new JTextField(10); // accepts upto 10 characters
        JButton sendButton = new JButton("New Order");
        JButton resetButton = new JButton("Review Order");

        // create checkboxes
        checkBox1 = new JCheckBox("Yes");
        checkBox1.setBounds(100, 100, 50, 50);
        checkBox2 = new JCheckBox("No", true);
        checkBox2.setBounds(100, 150, 50, 50);

        // create a panel for organizing the components at the bottom
        JPanel panel = new JPanel(); // a "panel" is not visible

        // add bottom components to the panel, in left-to-right order
        panel.add(label);
        panel.add(textField);
        panel.add(sendButton);
        panel.add(resetButton);
        panel.add(checkBox1);
        panel.add(checkBox2);

        // creating a third panel to place slider and bottom panels vertically
        // (allows two rows of UI elements to be displayed)
        JPanel combinedPanels = new JPanel();
        combinedPanels.setLayout(new GridLayout(2, 1));
        combinedPanels.add(sliderPanel, BorderLayout.NORTH);
        combinedPanels.add(panel, BorderLayout.SOUTH);

        // add the menu bar to the TOP of the frame, the big white text area
        // to the MIDDLE of the frame, and the "combinedPanels" (which has
        // the label, slider, text box, buttons, and checkboxes) at the BOTTOM
        add(menuBar, BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);
        add(combinedPanels, BorderLayout.SOUTH);

        // --- SETTING UP EVENT HANDLING ----
        //setting up buttons to use ActionListener interface and actionPerformed method
        sendButton.addActionListener(this);
        resetButton.addActionListener(this);

        //setting up checkboxes to use ItemListener interface and itemStateChanged method
        checkBox1.addItemListener(this);
        checkBox2.addItemListener(this);

        // display the frame!
        setVisible(true);
    }

    // ActionListener interface method, called when a button is clicked
    public void actionPerformed(ActionEvent ae) {
        // cast ae to a JButton object since we want to call the getText method on it;
        // casting is needed since getSource() returns Object type, NOT a JButton
        Object source = ae.getSource();
        JButton button = (JButton) source;
        String text = button.getText();

        if (text.equals("New Order")) {;
            textArea.append("Welcome to Chick Fil A! How may I help you?"+"\n");
            textArea.append("A. Breakfast"+"\n");
            textArea.append("B. Entrees "+"\n");
            textArea.append("C. Sides"+"\n");
            textArea.append("D. Beverages"+"\n");
            textArea.append("Type the letter of the food choice you would like!"+"\n");
            Menu m = new Menu();
            Scanner s = new Scanner(System.in);
            String n = s.nextLine();
            Order o = new Order();
            if (n.toLowerCase().equals("a")) {
                for (int i = 0; i < m.getBreakFast().size(); i++) {
                    textArea.append(i + ": " + m.getBreakFast().get(i).getName() + " for " + m.getBreakFast().get(i).getPrice()+"\n");
                }
                textArea.append("Choose the item you want. Press 200 to exit back to main menu. Press 300 to recap your order"+"\n");
                Scanner c = new Scanner(System.in);
                int y = c.nextInt();
                if (y < m.getBreakFast().size()) {
                    o.addItem(m.getBreakFast().get((y)));
                    textArea.append("Item Added!"+"\n");
                } else {
                    textArea.append("Item Not Found."+"\n");
                }
                while (y != 200) {
                    textArea.append("Choose the item you want. Press 200 to exit back to main menu. Press 300 to recap your order"+"\n");
                    y = c.nextInt();
                    if (y == 300) {
                        if (o.getOrderList().size() > 0) {
                            o.getFullOrder();
                        }
                    }
                    if (y < m.getBreakFast().size()) {
                        o.addItem(m.getBreakFast().get((y)));
                        textArea.append("Item Added!"+"\n");
                    } else {
                        textArea.append("Item Not Found."+"\n");
                    }


                }
                if (y == 300) {
                    if (o.getOrderList().size() > 0) {
                        o.getFullOrder();
                    }
                } else {
                    if (y < m.getBreakFast().size()&&y!= 300) {
                        o.addItem(m.getBreakFast().get((y)));
                        textArea.append("Item Added!"+"\n");
                    } else {
                        textArea.append("Item Not Found."+"\n");
                    }
                }


            }
            if (n.toLowerCase().equals("b")) {
                for (int i = 0; i < m.getEntrees().size(); i++) {
                    textArea.append(i + ": " + m.getEntrees().get(i).getName() + " for " + m.getEntrees().get(i).getPrice()+"\n");
                }
                textArea.append("Choose the item you want. Press 200 to exit back to main menu. Press 300 to recap your order"+"\n");
                Scanner c = new Scanner(System.in);
                int y = c.nextInt();
                if (y < m.getEntrees().size()) {
                    o.addItem(m.getEntrees().get((y)));
                    System.out.println("Item Added!"+"\n");
                } else {
                    System.out.println("Item Not Found."+"\n");
                }
                while (y != 200) {
                    System.out.println("Choose the item you want. Press 200 to exit back to main menu. Press 300 to recap your order"+"\n");
                    y = c.nextInt();
                    if (y == 300) {
                        if (o.getOrderList().size() > 0) {
                            o.getFullOrder();
                        }
                    }
                    if (y < m.getEntrees().size()) {
                        o.addItem(m.getEntrees().get((y)));
                        textArea.append("Item Added!"+"\n");
                    } else {
                        textArea.append("Item Not Found."+"\n");
                    }


                }
                if (y == 300) {
                    if (o.getOrderList().size() > 0) {
                        o.getFullOrder();
                    }
                } else {
                    if (y < m.getEntrees().size()&& y!= 300) {
                        o.addItem(m.getEntrees().get((y)));
                        textArea.append("Item Added!"+"\n");
                    } else {
                        textArea.append("Item Not Found."+"\n");
                    }
                }

            }
            if (n.toLowerCase().equals("c")) {
                for (int i = 0; i < m.getSides().size(); i++) {
                    textArea.append(i + ": " + m.getSides().get(i).getName() + " for " + m.getSides().get(i).getPrice());
                }
                textArea.append("Choose the item you want. Press 200 to exit back to main menu. Press 300 to recap your order"+"\n");
                Scanner c = new Scanner(JTextArea.TOOL_TIP_TEXT_KEY);
                int y = c.nextInt();
                if (y < m.getSides().size()) {
                    o.addItem(m.getSides().get((y)));
                    textArea.append("Item Added!"+"\n");
                } else {
                    textArea.append("Item Not Found.");
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
        } else if (text.equals("Review Order")) {
            welcomeLabel.setText("Reset pressed!");
        }
    }

    // ItemListener interface method, called when EITHER check box is toggled!
    public void itemStateChanged(ItemEvent e) {

        // cast e to a JCheckBox object since we want to call the getText method on it;
        // casting is needed since getSource() returns Object type, NOT a JCheckBox
        Object source = e.getSource();
        JCheckBox cb = (JCheckBox) source;
        String cbText = cb.getText();

        int checkBoxOnOrOff = e.getStateChange(); // 1 for selected, 2 for deselected
        if (checkBoxOnOrOff == 1) {
            welcomeLabel.setText(cbText + " box SELECTED!");
        } else if (checkBoxOnOrOff == 2) {
            welcomeLabel.setText(cbText + " box DESELECTED!");
        }

        // we don't "print" with GUI based apps, but printing
        // can still be helpful for testing and debugging!
        System.out.println("Current state: yes = " + checkBox1.isSelected() + ", no = " + checkBox2.isSelected());
    }
}