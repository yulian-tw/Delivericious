package foodordering;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddFoodToBasketTest {

    @Test
    void shouldAddTomatoSoupToBasket() {
        Basket basket = new Basket();
        Food tomatoSoup = new Food("Tomato Soup");
        basket.addFood(tomatoSoup);

        assertEquals(1, basket.getAllItems().size());
        assertEquals("Tomato Soup", basket.getAllItems().get(0).getName());
    }

    @Test
    void shouldAddSeafoodSaladWithPriceToBasket() {
        Basket basket = new Basket();
        Food tomatoSoup = new Food("Seafood Salad", new BigDecimal("12.00"));
        basket.addFood(tomatoSoup);

        assertEquals(1, basket.getAllItems().size());
        assertEquals("Seafood Salad", basket.getAllItems().get(0).getName());
        assertEquals(new BigDecimal("12.00"), basket.getTotalPrice());
    }

}
