import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Menu {
    private ArrayList<Item> total;
    private ArrayList<Item> breakFast;
    private ArrayList<Item> entrees;
    private ArrayList<Item> beverages;



    public Menu(){
        importMenuList("src/All Items.csv");
    }

    private void importMenuList(String fileName)
    {
        try
        {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            total = new ArrayList<Item>();

            while ((line = bufferedReader.readLine()) != null)
            {
                String[] menuFromCSV = line.split(":");

                double price = Double.parseDouble(menuFromCSV[0].substring(1));
                String name = menuFromCSV[1];
                String description = menuFromCSV[2];
                String itemType= menuFromCSV[3];

                 Item a = new Item(price, name,description,itemType);
                total.add(a);
            }
            bufferedReader.close();
        }
        catch(IOException exception)
        {
            // Print out the exception that occurred
            System.out.println("Unable to access " + exception.getMessage());
        }
    }
}
