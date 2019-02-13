package exercise.com;

import java.util.*;

public class Basket {

    private Map<Item, Integer> itemList = new HashMap<>();

    public void addItem(Item item) {
        if (!itemList.containsKey(item)) {
            itemList.put(item, 1);
        } else {
            itemList.put(item, (itemList.get(item) + 1));
        }
    }

    public void addFew(Item item, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("It is not correct quantity.");
        }
        if (!itemList.containsKey(item)) {
            itemList.put(item, quantity);
        } else {
            itemList.put(item, (itemList.get(item) + quantity));
        }
    }

    public void deleteAllOfThisItems(Item item) {
        if (itemList.containsKey(item)) {
            itemList.remove(item);
        } else {
            throw new NoSuchElementException("There is no such item in the Basket.");
        }
    }

    public void deleteParticularQuantity(Item item, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Incorrect quantity.");
        }
        if (!itemList.containsKey(item)) {
            throw new NoSuchElementException("There is no such item in the Basket.");
        }
        if (itemList.get(item) < quantity) {
            throw new IllegalArgumentException("There is not enough such items in the Basket.");
        }
        if (itemList.get(item) == quantity) {
            deleteAllOfThisItems(item);
        } else {
            itemList.put(item, (itemList.get(item) - quantity));
        }
    }

    public double fullPrice() {
        double fullPrice = 0;
        for (Map.Entry<Item, Integer> entry : itemList.entrySet()) {
            fullPrice += (entry.getKey().getUnitPrice() * entry.getValue());
        }
        System.out.println("Price of all products in the basket: " + fullPrice);
        return fullPrice;
    }

    public Map<Item, Integer> getItemList() {
        return itemList;
    }

    @Override
    public String toString() {
        return "Basket = " + itemList.entrySet();
    }
}
