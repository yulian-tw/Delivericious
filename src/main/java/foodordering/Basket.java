package foodordering;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static foodordering.Currency.SGD;

public class Basket {

    private final List<BasketItem> items = new ArrayList<>();

    public List<BasketItem> getAllItems() {
        return this.items;
    }

    public void addFood(Food food) {
        this.items.add(new BasketItem(food, 1));
    }

    public void addFood(Food food, int quantity) {
        this.items.add(new BasketItem(food, quantity));
    }

    public Price getTotalPrice() {
        return getPriceInSGD();
    }

    private Price getPriceInSGD() {
        return new Price(
                BigDecimal.valueOf(this.items.stream()
                        .map(BasketItem::getPrice)
                        .filter(price -> SGD.equals(price.getCurrency()))
                        .mapToDouble(price -> price.getValue().doubleValue())
                        .sum()).setScale(2, RoundingMode.HALF_UP)
                , SGD
        );
    }
}
