package foodordering;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static foodordering.Currency.SGD;

public class Basket {

    private final List<Food> foodList = new ArrayList<>();

    public void addFood(Food food) {
        this.foodList.add(food);
    }

    public Price getTotalPrice() {
        return getPriceInSGD();
    }

    private Price getPriceInSGD() {
        return new Price(
                BigDecimal.valueOf(this.foodList.stream()
                        .filter(food -> SGD.equals(food.getPrice().getCurrency()))
                        .mapToDouble(food -> food.getPrice().getValue().doubleValue())
                        .sum()).setScale(2, RoundingMode.HALF_UP)
                , SGD
        );
    }

    public List<Food> getAllItems() {
        return this.foodList;
    }
}
