import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class MenuList {
    //Static method so it can be called from Restaurant
    public static void displayMenu() throws Exception {
        System.out.println("-----------------THE RESTAURANT'S MENU----------------");
        Path path = Path.of("menu.csv");

        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");

                int id = Integer.parseInt(columns[0].trim());
                String product = columns[1];
                String price = columns[2];

                System.out.printf("Product Number: %-2d  | Name:%-11s  | Price: $%s\n", id, product, price);
            }
            System.out.println("");
        } 
    }
}

/*
Connected to Menu.CSV Containing:
1, Burger,8.50
2, Pizza,6.50
3, Hot Dog,5.50
4, Empanada,9.50
5, Arepas,7.50
6, Tacos,6.50
7, Burritos,7.50
8, Coffee,6.00
9, Lemonade,3.50
10, Matcha,5.00
11, Green Tea,3.00
12, Coca-Cola,3.00
13, Dr. Pepper,3.00
*/
