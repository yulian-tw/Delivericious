package foodordering.usecase;

import foodordering.Basket;
import foodordering.MenuItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReduceMenuItemQuantityFromBasketTest {

    private static final String TOMATO_SOUP = "Tomato Soup";
    private static final String CHOCOLATE = "Chocolate";

    @Test
    void shouldReduceTheQuantityOfTheRightFoodFromBasket() {

        Basket basket = new Basket();
        MenuItem tomatoSoup = new MenuItem(TOMATO_SOUP);
        MenuItem chocolate = new MenuItem(CHOCOLATE);
        basket.addItem(tomatoSoup, 2);
        basket.addItem(chocolate, 4);
        assertEquals(2, basket.getQuantityByFoodName(TOMATO_SOUP));
        assertEquals(4, basket.getQuantityByFoodName(CHOCOLATE));

        basket.removeItemByFoodName(CHOCOLATE, 1);
        assertEquals(2, basket.getQuantityByFoodName(TOMATO_SOUP));
        assertEquals(3, basket.getQuantityByFoodName(CHOCOLATE));
    }

}
