import java.util.Scanner;

public class Restaurant {

    public static void main(String[] args) throws Exception {

        Kitchen kitchen = new Kitchen();
        OrderManager orderManager = new OrderManager();
        Scanner input = new Scanner(System.in);
        MenuList.displayMenu();

        String goOrder;
        int random = (int) (Math.random() * 100);

        while (true) {
            System.out.print("New Customer? (Enter the name or type exit to finish): ");
            String name = input.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            if (name.isEmpty()) {
                System.err.println("ERROR: Name was not entered.");
                continue;
            }

            Order currentOrder = null;
            while (true) {
                System.out.print("Is the order to Go or Dine In? (Go/In): ");
                goOrder = input.nextLine().toLowerCase();

                if (goOrder.equals("in")) {
                    System.out.print("What Product do you want? (Number): ");
                    int choice = input.nextInt();
                    input.nextLine();

                    currentOrder = new DineInOrder(choice, name, "Burger", 8.50);
                    System.out.println("Order for Dine in registered, table #" + random);
                    PreparationSteps(currentOrder, choice);
                    break;

                } else if (goOrder.equals("go")) {
                    System.out.print("What Product do you want? (Number): ");
                    int choice = input.nextInt();
                    input.nextLine();

                    currentOrder = new TakeOutOrder(choice, name, "Burger", 8.50);
                    System.out.println("Order to go registered, number #" + random);
                    PreparationSteps(currentOrder, choice);
                    break;

                } else {
                    System.err.println("INVALID: Please enter Go or In.");
                }
            }

            kitchen.receiveOrder(currentOrder);

            System.out.println("");
            System.out.println("--Current Lobby Status of Orders--");
            System.out.println("[LOG] Lobby: " + kitchen.getQueueSize() + " orders pending.\n");

            System.out.println("--Kitchen Preparation and Status of Orders--");

            kitchen.processNextOrder();
            System.out.println("[LOG] Kitchen: " + kitchen.getKitchenCount() + " orders pending.");

            Order finished = kitchen.prepareOrder();
            if (finished != null) {
                orderManager.addCompletedOrder(finished);
            }
        }

        orderManager.printSummary();

    }

    private static void PreparationSteps(Order order, int productNumber) {
        switch (productNumber) {
            case 1: // Burger
                order.preparations.push("5. Assemble Burger");
                order.preparations.push("4. Put Lettuce");
                order.preparations.push("3. Put Cheese");
                order.preparations.push("2. Cook The Patty");
                order.preparations.push("1. Take Frozen Patty");
                break;
            case 2: // Pizza
                order.preparations.push("5. Serve the Pizza");
                order.preparations.push("4. Cook Pizza in Oven");
                order.preparations.push("3. Put pineapple");
                order.preparations.push("2. Put tomato sauce");
                order.preparations.push("1. Prepare Base of Pizza");
                break;
            case 3: // Hot Dog
                order.preparations.push("5. Serve the hot dog");
                order.preparations.push("4. Put mayo and ketchup on top");
                order.preparations.push("3. Put sausage and onions in bread");
                order.preparations.push("2. Grill onions");
                order.preparations.push("1. Cook Sausage");
                break;
        }
    }
}
