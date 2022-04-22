package foodordering;

import java.util.ArrayList;
import java.util.List;

import static foodordering.Currency.SGD;

public class Basket {

    private final List<BasketItem> items = new ArrayList<>();

    public List<BasketItem> getAllItems() {
        return this.items;
    }

    public void addFood(Food food) {
        this.items.add(new BasketItem(food, 1));
    }

    public void addFood(Food food, int quantity) {
        this.items.add(new BasketItem(food, quantity));
    }

    public int getQuantityByFoodName(String foodName) {
        return this.items.stream()
                .filter(item -> item.getFood().getName().equals(foodName))
                .findFirst()
                .map(BasketItem::getQuantity)
                .orElseGet(BasketItem::getEmptyQuantity);
    }

    public void removeFoodByFoodName(String foodName, int quantity) {
        this.items.stream()
                .filter(item -> item.getFood().getName().equals(foodName))
                .findFirst()
                .ifPresent(basketItem -> basketItem.reduceQuantity(quantity));
    }

    public Price getTotalPrice() {
        return getTotalPriceInSGD();
    }

    private Price getTotalPriceInSGD() {
        return this.items.stream()
                .map(BasketItem::getPrice)
                .filter(price -> SGD.equals(price.getCurrency()))
                .reduce(Price::add)
                .orElse(Price.SGD("0.00"));
    }
}
