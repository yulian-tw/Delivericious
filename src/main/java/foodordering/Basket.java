package foodordering;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private final List<Food> foodList = new ArrayList<>();

    public void addFood(Food food) {
        this.foodList.add(food);
    }

    public List<Food> getAllItems() {
        return this.foodList;
    }
}
