package foodordering;

public class BasketItem {

    private static final int EMPTY_QUANTITY = 0;

    private final MenuItem menuItem;
    private int quantity;

    public BasketItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public String getFoodName() {
        return this.menuItem.getName();
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
