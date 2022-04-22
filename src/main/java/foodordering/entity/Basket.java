package foodordering.entity;

import foodordering.BasketItem;
import foodordering.Price;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

import static foodordering.Currency.SGD;

public class Basket {

    private final UUID uuid = UUID.randomUUID();
    private final List<BasketItem> items = new ArrayList<>();

    public int getBasketSize() {
        return this.items.size();
    }

    public void addItem(MenuItem menuItem) {
        checkFoodPresent(menuItem);
        this.items.add(BasketItem.createNew(menuItem, 1));
    }

    public void addItem(MenuItem menuItem, int quantity) {
        checkFoodPresent(menuItem);
        this.items.add(BasketItem.createNew(menuItem, quantity));
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
                .ifPresentOrElse(
                        basketItem -> basketItem.reduceQuantity(quantity),
                        () -> {
                            throw new NoSuchElementException();
                        }
                );
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

    public UUID getBasketId() {
        return this.uuid;
    }

    public Basket duplicate() {
        return Basket.copyOf(this);
    }

    private static Basket copyOf(Basket existing) {
        List<BasketItem> clonedBasketItems = existing.items.stream()
                .map(BasketItem::copyOf)
                .collect(Collectors.toUnmodifiableList());

        Basket newBasket = new Basket();
        newBasket.items.addAll(clonedBasketItems);

        return newBasket;
    }
}
