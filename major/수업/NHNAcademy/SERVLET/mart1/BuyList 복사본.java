package com.nhnacademy;

import java.util.ArrayList;

public class BuyList {
    private final ArrayList<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public int getSize() {
        return items.size();
    }

    public Item getItem(int index) {
        return items.get(index);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public static class Item {
        private final String name;
        private final int quantity;

        public Item(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }
    }
}

