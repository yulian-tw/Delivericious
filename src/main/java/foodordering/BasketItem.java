package foodordering;

public class BasketItem {

    private final Food food;
    private final int quantity;

    public BasketItem(Food food, int quantity) {
        this.food = food;
        this.quantity = quantity;
    }

    public Food getFood() {
        return this.food;
    }

    public Price getPrice() {
        return this.food.getPrice().multiply(quantity);
    }
}
