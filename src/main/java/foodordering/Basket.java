package foodordering;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Basket {

    private final List<Food> foodList = new ArrayList<>();

    public void addFood(Food food) {
        this.foodList.add(food);
    }

    public BigDecimal getTotalPrice() {
        return BigDecimal
                .valueOf(this.foodList.stream()
                        .mapToDouble(food -> food.getPrice().doubleValue())
                        .sum())
                .setScale(2, RoundingMode.HALF_UP);
    }

    public List<Food> getAllItems() {
        return this.foodList;
    }
}
