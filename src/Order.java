import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private List<OrderObserver> observers = new ArrayList<>();
    private double itemCost;
    private int itemCount;
    private double shippingCost = 10;
    private double discount = 0;

    public Order(int id) {
        this.id = id;
    }

    public void attach(OrderObserver observer){
        observers.add(observer);
    }

    public void detach(OrderObserver observer){
        observers.remove(observer);
    }

    public double getTotalPrices(){
        return this.itemCost;
    }

    public int getCount(){
        return this.itemCount;
    }

    public void addItem(double price){
        this.itemCost += price;
        this.itemCount += 1;
        notifyObservers(); //For each item added, notify the observers
    }

    public void setDiscount(double discount){
        this.discount = discount;
    }

    public void setShippingCost(double shippingCost){
        this.shippingCost = shippingCost;
    }

    public void notifyObservers(){
        for(OrderObserver observer : observers){
            observer.update(this);
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("---[Order ID " + this.id + "]---\n");
        sb.append("Total of items: " + this.itemCount + "\n");
        sb.append("Total prices: $" + String.format("%.2f", this.itemCost) + "\n");
        sb.append("Shipping cost: $" + this.shippingCost + "\n");
        if (discount > 0) {
            sb.append("Discount applied: -$" + this.discount + "\n");
        }
        double total =  this.itemCost + this.shippingCost - this.discount;
        sb.append("Total: $" + String.format("%.2f", total) + "\n");
        sb.append("------------------\n\n");
        return sb.toString();
    }
}
