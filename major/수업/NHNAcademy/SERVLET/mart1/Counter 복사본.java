package com.nhnacademy;

public class Counter {
    private int totalPrice;

    public void calculatePrice(Basket basket) {
        for (Food food : basket.getFoods()) {
            totalPrice += food.getPrice();
        }
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
