public class Kitchen extends Restaurant {

    private Queue<Order> waitingLine = new Queue<>(100);
    private SinglyLinkedList<Order> ordersInProgress = new SinglyLinkedList<>();

    public void receiveOrder(Order o) {
        waitingLine.enQueue(o);
        System.out.println("[LOG] " + o.getCustomerName() + "'s order is in queue.");
    }

    public void processNextOrder() {
        if (!waitingLine.isEmtpy()) {
            Order nextToCook = waitingLine.deQueue();
            if (nextToCook != null) {
                ordersInProgress.append(nextToCook);
                System.out.println("[LOG] " + nextToCook.getCustomerName() + "'s order was moved to the kitchen list.");
            }
        }
    }

    public Order prepareOrder() {
        if (ordersInProgress.isEmpty()) {
            return null;
        }

        Order preparing = ordersInProgress.head.data;
        ordersInProgress.removeValue(preparing);

        System.out.println("[LOG] " + preparing.getCustomerName() + "'s order is now being prepared.\n");

        while (!preparing.preparations.isEmpty()) {
            String task = preparing.preparations.pop();
            System.out.println(preparing.getCustomerName() + "'s Order Prep Steps: " + task + "\n");
            
        }

        System.out.println("[LOG] " + preparing.getCustomerName() + "'s order is now ready. \n");

        return preparing;
    }

    public int getQueueSize() {
        return waitingLine.size();
    }

    public int getKitchenCount() {
        return ordersInProgress.getLength();
    }
}
