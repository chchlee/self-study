import com.nhnacademy.*;

public class Customer {
    private final BuyList buyList;
    private Basket basket;
    private int money;

    public Customer(BuyList buyList, int money) {
        this.buyList = buyList;
        this.money = money;
    }

    public void bring(Basket basket) {
        this.basket = basket;
    }

    public void pickFoods(FoodStand foodStand) {
        for (Food food : foodStand.getFoods()) {
            for (BuyList.Item item : buyList.getItems()) {
                if (food.getName().equals(item.getName())) {
                    for (int i = 0; i < item.getQuantity(); i++) {
                        basket.add(food);
                        foodStand.remove(food);
                    }
                }
            }
        }
    }

    public void payTo(Counter counter) {
        counter.calculatePrice(basket);
        int totalPrice = counter.getTotalPrice();
        if (money < totalPrice) {
            throw new IllegalArgumentException("고객님의 돈이 부족합니다.");
        } else {
            money -= totalPrice;
        }
    }

    public int getMoney() {
        return money;
    }
}
