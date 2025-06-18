public class QuantityObserver implements OrderObserver{
    @Override
    public void update(Order order) {
        if (order.getCount() <= 5){
            order.setShippingCost(10); //Add the 10$ shipping cost when there are less or 5 items
        } else {
            order.setShippingCost(0); //Otherwhise don't apply a shipping cost
        }
    }
}
