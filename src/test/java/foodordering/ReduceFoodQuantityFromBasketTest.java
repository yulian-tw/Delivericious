package foodordering;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReduceFoodQuantityFromBasketTest {

    private static final String TOMATO_SOUP = "Tomato Soup";
    private static final String CHOCOLATE = "Chocolate";

    @Test
    void shouldReduceTheQuantityOfTheRightFoodFromBasket() {

        Basket basket = new Basket();
        Food tomatoSoup = new Food(TOMATO_SOUP);
        Food chocolate = new Food(CHOCOLATE);
        basket.addFood(tomatoSoup, 2);
        basket.addFood(chocolate, 4);
        assertEquals(2, basket.getQuantityByFoodName(TOMATO_SOUP));
        assertEquals(4, basket.getQuantityByFoodName(CHOCOLATE));

        basket.removeFoodByFoodName(CHOCOLATE, 1);
        assertEquals(2, basket.getQuantityByFoodName(TOMATO_SOUP));
        assertEquals(3, basket.getQuantityByFoodName(CHOCOLATE));
    }

    @Test
    @Disabled("Maybe blocked at addFood use case")
    void shouldHandleWhenMultipleFoodWithSameNamePresent() {
    }

}
