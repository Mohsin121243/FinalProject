import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Chick Fil A! How may i help you?");
        System.out.println("A. Breakfast");
        System.out.println("B. Entrees ");
        System.out.println("C. Sides");
        System.out.println("D. Beverages");
        System.out.println("Type the letter of the food choice you would like!");
        Menu m = new Menu();
        ArrayList<Item> totals = m.getTotal();
        for(int i = 0; i < totals.size();i++){
            System.out.println(totals.get(i).getName());
        }




    }
}
