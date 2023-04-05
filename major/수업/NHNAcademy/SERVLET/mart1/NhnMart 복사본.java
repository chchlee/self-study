import com.nhnacademy.Basket;
import com.nhnacademy.Counter;
import com.nhnacademy.Food;
import com.nhnacademy.FoodStand;

public class NhnMart {
    private final FoodStand foodStand = new FoodStand();
    private final Counter counter = new Counter();

    public void prepareMart() {
        fillFoodStand();
    }

    private void fillFoodStand() {
        foodStand.add(new Food("양파", 1_000));
        foodStand.add(new Food("양파", 1_000)); // 추가
        for (int i = 0; i < 5; i++) {
            foodStand.add(new Food("계란(30개)", 5_000));
        }
        for (int i = 0; i < 10; i++) {
            foodStand.add(new Food("파", 500));
        }
        for (int i = 0; i < 20; i++) {
            foodStand.add(new Food("사과", 2_000));
        }
    }

    public Basket provideBasket() {
        return new Basket();
    }

    public FoodStand getFoodStand() {
        return foodStand;
    }

    public Counter getCounter() {
        return counter;
    }
}
