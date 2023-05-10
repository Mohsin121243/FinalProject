import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Menu {
    private ArrayList<Item> total;
    private ArrayList<String> tester;
    private ArrayList<Item> breakFast;
    private ArrayList<Item> entrees;
    private ArrayList<Item> sides;
    private ArrayList<Item> beverages;



    public Menu(){
        importMenuList("src/AllItems.txt");
        ArrayList<String> itemsSplit= new ArrayList<String>();
        for(int i =0; i < total.size(); i++){
            String newItem = total.get(i).getItemType();
            if(newItem.equals(" Breakfast")){
                breakFast.add(total.get(i));
            }
            if(newItem.equals("Entrees")){
                entrees.add(total.get(i));
            }
            if(newItem.equals("Sides")){
                sides.add(total.get(i));
            }
            if(newItem.equals(" Beverages")){
                beverages.add(total.get(i));
            }
        }
    }

    public ArrayList<String> getTester() {
        return tester;
    }

    private void importMenuList(String fileName)
    {
        try
        {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            total = new ArrayList<Item>();
            tester = new ArrayList<String>();

            while ((line = bufferedReader.readLine()) != null)
            {
                tester.add(line);
                String[] menuFromCSV = line.split(": ");

                if(menuFromCSV.length>=4){
                String price = menuFromCSV[0];
                String name = menuFromCSV[1];
                String description = menuFromCSV[2];
                String itemType= menuFromCSV[3];

                 Item a = new Item(price, name,description,itemType);
                total.add(a);}
            }
            bufferedReader.close();
        }
        catch(IOException exception)
        {
            // Print out the exception that occurred
            System.out.println("Unable to access " + exception.getMessage());
        }
    }

    public ArrayList<Item> getTotal() {
        return total;
    }

    public ArrayList<Item> getBreakFast() {
        return breakFast;
    }

    public ArrayList<Item> getEntrees() {
        return entrees;
    }

    public ArrayList<Item> getSides() {
        return sides;
    }

    public ArrayList<Item> getBeverages() {
        return beverages;
    }
}
