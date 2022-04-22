package foodordering.entity;

import foodordering.Price;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketTest {

    @Test
    void getTotalPriceShouldReturnZeroWhenBasketIsEmpty() {
        Basket basket = new Basket();
        Price result = basket.getTotalPrice();
        assertEquals(Price.SGD("0.00"), result);
    }

}