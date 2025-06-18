public class Main {
    public static void main(String[] args) {
        PriceObserver priceObserver = new PriceObserver();
        QuantityObserver quantityObserver = new QuantityObserver();

        Order order = new Order(1);
        order.attach(priceObserver);
        order.attach(quantityObserver);

        order.addItem(49.99);
        order.addItem(17.50);
        order.addItem(17.50);
        order.addItem(17.50);
        System.out.print(order.toString());

        order.addItem(5.65);
        order.addItem(5.65);
        System.out.print(order.toString());

        order.addItem(59.99);
        order.addItem(59.99);
        System.out.print(order.toString());
    }
}
