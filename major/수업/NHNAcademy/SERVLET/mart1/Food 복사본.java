package com.nhnacademy;

public class Food {
    private final String name;
    private final int price;

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "음식: " + name + ", 가격: " + price + "원";
    }
}
