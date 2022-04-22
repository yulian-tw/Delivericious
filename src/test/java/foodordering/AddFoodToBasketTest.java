package foodordering;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddFoodToBasketTest {

    @Test
    void shouldAddTomatoSoupToBasket() {
        Basket basket = new Basket();
        Food tomatoSoup = new Food("Tomato Soup");
        basket.addFood(tomatoSoup);

        assertEquals(1, basket.getAllItems().size());
        assertEquals("Tomato Soup", basket.getAllItems().get(0).getName());
    }
}
