package foodordering;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static foodordering.Currency.SGD;

public class Basket {

    private final List<BasketItem> items = new ArrayList<>();

    public int getBasketSize() {
        return this.items.size();
    }

    public void addItem(MenuItem menuItem) {
        checkFoodPresent(menuItem);
        this.items.add(new BasketItem(menuItem, 1));
    }

    public void addItem(MenuItem menuItem, int quantity) {
        checkFoodPresent(menuItem);
        this.items.add(new BasketItem(menuItem, quantity));
    }

    private void checkFoodPresent(MenuItem menuItem) {
        this.items.stream()
                .filter(item -> item.getMenuItemUuid().equals(menuItem.getUuid()))
                .findFirst()
                .ifPresent(item -> {
                    throw new UnsupportedOperationException(
                            String.format("Food with same name [%s] exists in this basket", item.getMenuItemUuid())
                    );
                });
    }

    public int getQuantityByMenuItemId(UUID uuid) {
        return this.items.stream()
                .filter(item -> item.getMenuItemUuid().equals(uuid))
                .findFirst()
                .map(BasketItem::getQuantity)
                .orElseGet(BasketItem::getEmptyQuantity);
    }

    public void removeItemByMenuItemId(UUID uuid, int quantity) {
        this.items.stream()
                .filter(item -> item.getMenuItemUuid().equals(uuid))
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
