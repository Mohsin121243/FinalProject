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
        Scanner s = new Scanner(System.in);
        String n = s.nextLine();
        if(n.toLowerCase().equals("a")){
            for(int i = 0; i < m.getBreakFast().size(); i++){
                System.out.println(m.getBreakFast().get(i).getName() +" for "+ m.getBreakFast().get(i).getPrice());
            }
        }
        if(n.toLowerCase().equals("b")){
            for(int i = 0; i < m.getEntrees().size(); i++){
                System.out.println(m.getEntrees().get(i).getName() +" for "+ m.getEntrees().get(i).getPrice());
            }
        }
        if(n.toLowerCase().equals("c")){
            for(int i = 0; i < m.getSides().size(); i++){
                System.out.println(m.getSides().get(i).getName() +" for "+ m.getSides().get(i).getPrice());
            }
        }
        if(n.toLowerCase().equals("d")){
            for(int i = 0; i < m.getBeverages().size(); i++){
                System.out.println(m.getBeverages().get(i).getName() +" for "+ m.getBeverages().get(i).getPrice());
            }
        }




    }
}
