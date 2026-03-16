public abstract class Order {
    protected int orderID;
    protected String customerName;
    protected String itemName;
    protected double price;
    protected StackLinkedList<String> preparations;

    public Order(int orderID, String customerName, String itemName, double price) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.itemName = itemName;
        this.price = price;
        this.preparations = new StackLinkedList<>();
    }

    public abstract double calculateRevenue();

    public String getCustomerName() {
        return customerName;
    }

    public String getitemName() {
        return itemName;
    }
}

class DineInOrder extends Order {

    public DineInOrder(int orderID, String customerName, String itemName, double price) {
        super(orderID, customerName, itemName, price);
    }

    @Override
    public double calculateRevenue() {
        return price * 1.25; // Taxed revenue
    }
}


class TakeOutOrder extends Order {
    public TakeOutOrder(int orderID, String customerName, String itemName, double price) {
        super(orderID, customerName, itemName, price);
    }

    @Override
    public double calculateRevenue() {
        return price * 1;
    }
}
