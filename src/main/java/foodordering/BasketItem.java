package foodordering;

public class BasketItem {

    private static final int EMPTY_QUANTITY = 0;

    private final Food food;
    private int quantity;

    public BasketItem(Food food, int quantity) {
        this.food = food;
        this.quantity = quantity;
    }

    public String getFoodName() {
        return this.food.getName();
    }

    public Price getPrice() {
        return this.food.getPrice().multiply(quantity);
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
