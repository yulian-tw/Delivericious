package foodordering.domain.entity.basket;

import foodordering.domain.Price;
import foodordering.domain.entity.MenuItem;

import java.util.UUID;

class BasketItem {

    private static final int EMPTY_QUANTITY = 0;

    private final MenuItem menuItem;
    private int quantity;

    private BasketItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    static BasketItem createNew(MenuItem menuItem, int quantity) {
        return new BasketItem(menuItem, quantity);
    }

    static BasketItem copyOf(BasketItem existing) {
        return new BasketItem(existing.menuItem, existing.quantity);
    }

    UUID getMenuItemUuid() {
        return this.menuItem.getUuid();
    }

    Price getPrice() {
        return this.menuItem.getPrice().multiply(quantity);
    }

    int getQuantity() {
        return quantity;
    }

    static Integer getEmptyQuantity() {
        return EMPTY_QUANTITY;
    }

    void reduceQuantity(int quantity) {
        this.quantity = this.quantity - quantity;
    }
}
