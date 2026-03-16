import java.util.ArrayList;

public class OrderManager {

    private ArrayList<Order> ordersCompleted = new ArrayList<>();
    
    private int dineInCount = 0;
    private int takeOutCount = 0;

    public void addCompletedOrder(Order order) {
        if (order != null) {
            ordersCompleted.add(order);
            
            if (order instanceof DineInOrder) {
                dineInCount++;

            } else if (order instanceof TakeOutOrder) {
                takeOutCount++;
            }
        }
    }

    public void printSummary() {
        double totalRevenue = 0.0;

        System.out.println("\n--Summary Of The Shift--");
        
        for (Order price : ordersCompleted) {
            double revenue = price.calculateRevenue();
            totalRevenue += revenue;
        }

        System.out.println("Total Completed Orders: " + ordersCompleted.size());
        System.out.println("Dine-in total: " + dineInCount);
        System.out.println("To-go total: " + takeOutCount);
        System.out.printf("The Total Revenue is: $%.2f\n", totalRevenue);
    }
}
