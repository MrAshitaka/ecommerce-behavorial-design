public class PriceObserver implements OrderObserver{

    @Override
    public void update(Order order) {
        if (order.getTotalPrices() > 200){
            order.setDiscount(20); //If the total prices are more than 200$, apply a 20$ discount
        } else {
            order.setDiscount(0); //Otherwhise, don't apply a discount
        }
    }
}
