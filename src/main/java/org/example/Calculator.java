package org.example;

import java.util.ArrayList;

class Calculator {
    ArrayList<Item> itemsList = new ArrayList<>();

    // проверяю все товары и суммирую
    public void addMyItem(String itemName, double itemPrice) {
        itemsList.add(new Item(itemName, itemPrice));
    }

    public double calculateMyTotal() {
        double totalSumIs = 0.0;
        for (Item myItem : itemsList) {
            totalSumIs += myItem.itemPrice;
        }
        return totalSumIs;
    }

    public void showItems() {
        for (Item myItem : itemsList) {
            System.out.println(myItem.itemName);
        }
    }
}