package foodordering;

import java.util.UUID;

public class MenuItem {

    private final UUID uuid = UUID.randomUUID();
    private final String foodName;
    private final Price price;

    public MenuItem(String foodName) {
        checkFoodName(foodName);
        this.foodName = foodName;
        this.price = null;
    }

    public MenuItem(String foodName, Price price) {
        checkFoodName(foodName);
        this.foodName = foodName;
        this.price = price;
    }

    private void checkFoodName(String name) {
        if (name.isBlank()) {
            throw new UnsupportedOperationException("Food should have name");
        }
    }

    public Price getPrice() {
        return price;
    }

    public UUID getUuid() {
        return uuid;
    }

    @SuppressWarnings("unused")
    public String getFoodName() {
        return foodName;
    }
}
