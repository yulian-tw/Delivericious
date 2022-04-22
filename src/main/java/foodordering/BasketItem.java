package foodordering;

import foodordering.entity.MenuItem;

import java.util.UUID;

public class BasketItem {

    private static final int EMPTY_QUANTITY = 0;

    private final MenuItem menuItem;
    private int quantity;

    private BasketItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public static BasketItem createNew(MenuItem menuItem, int quantity) {
        return new BasketItem(menuItem, quantity);
    }

    public static BasketItem copyOf(BasketItem existing) {
        return new BasketItem(existing.menuItem, existing.quantity);
    }

    public UUID getMenuItemUuid() {
        return this.menuItem.getUuid();
    }

    public Price getPrice() {
        return this.menuItem.getPrice().multiply(quantity);
    }

    public int getQuantity() {
        return quantity;
    }

    public static Integer getEmptyQuantity() {
        return EMPTY_QUANTITY;
    }

    public void reduceQuantity(int quantity) {
        this.quantity = this.quantity - quantity;
    }
}
