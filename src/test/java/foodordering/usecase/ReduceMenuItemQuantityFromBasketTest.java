package foodordering.usecase;

import foodordering.domain.BasketQuantityExceedException;
import foodordering.domain.entity.basket.Basket;
import foodordering.domain.entity.MenuItem;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ReduceMenuItemQuantityFromBasketTest {

    private static final String TOMATO_SOUP = "Tomato Soup";
    private static final String CHOCOLATE = "Chocolate";

    @Test
    void shouldReduceTheQuantityOfTheRightFoodFromBasket() throws BasketQuantityExceedException {

        Basket basket = new Basket();
        MenuItem tomatoSoup = new MenuItem(TOMATO_SOUP);
        UUID tomatoSoupUuid = tomatoSoup.getUuid();

        MenuItem chocolate = new MenuItem(CHOCOLATE);
        UUID chocolateUuid = chocolate.getUuid();

        basket.addItem(tomatoSoup, 2);
        basket.addItem(chocolate, 4);
        assertEquals(2, basket.getQuantityByMenuItemId(tomatoSoupUuid));
        assertEquals(4, basket.getQuantityByMenuItemId(chocolateUuid));

        basket.removeItemByMenuItemId(chocolateUuid, 1);
        assertEquals(2, basket.getQuantityByMenuItemId(tomatoSoupUuid));
        assertEquals(3, basket.getQuantityByMenuItemId(chocolateUuid));

    }

    @Test
    void shouldThrowWhenReducingTheQuantityOfUnknownFoodFromBasket() {

        UUID unknown = UUID.randomUUID();

        Basket basket = new Basket();
        assertThrows(
                NoSuchElementException.class,
                () -> basket.removeItemByMenuItemId(unknown, 1)
        );

    }

}
