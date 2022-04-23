package foodordering.usecase;

import foodordering.domain.BasketQuantityExceedException;
import foodordering.domain.Price;
import foodordering.domain.entity.basket.Basket;
import foodordering.domain.entity.MenuItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AddMenuItemToBasketTest {

    @Test
    void shouldAddTomatoSoupToBasketWithDefaultQuantityEqualsOne() throws BasketQuantityExceedException {
        Basket basket = new Basket();
        MenuItem tomatoSoup = new MenuItem("Tomato Soup");
        basket.addItem(tomatoSoup);

        assertEquals(1, basket.getBasketSize());
        assertEquals(1, basket.getQuantityByMenuItemId(tomatoSoup.getUuid()));
    }

    @Test
    void shouldAddSeafoodSaladWithPriceToBasketWithDefaultQuantityEqualsOne() throws BasketQuantityExceedException {
        Basket basket = new Basket();
        MenuItem seafoodSalad = new MenuItem("Seafood Salad", Price.SGD("12.00"));
        basket.addItem(seafoodSalad);

        assertEquals(1, basket.getBasketSize());
        assertEquals(1, basket.getQuantityByMenuItemId(seafoodSalad.getUuid()));
        assertEquals(Price.SGD("12.00"), basket.getTotalPrice());
    }

    @Test
    void shouldAddChocolateIceCreamWithQuantityToBasket() throws BasketQuantityExceedException {
        Basket basket = new Basket();
        Price iceCreamPrice = Price.SGD("4.00");
        MenuItem chocolateIceCream = new MenuItem("Chocolate Ice Cream", iceCreamPrice);
        basket.addItem(chocolateIceCream, 3);

        assertEquals(1, basket.getBasketSize());
        assertEquals(3, basket.getQuantityByMenuItemId(chocolateIceCream.getUuid()));
        assertEquals(Price.SGD("12.00"), basket.getTotalPrice());
    }

    @Test
    void shouldPreventAddingTheFoodWithSameNameAgain() throws BasketQuantityExceedException {
        Basket basket = new Basket();
        Price iceCreamPrice = Price.SGD("4.00");
        MenuItem chocolateIceCream = new MenuItem("Chocolate Ice Cream", iceCreamPrice);
        basket.addItem(chocolateIceCream, 3);

        assertThrows(UnsupportedOperationException.class, () -> basket.addItem(chocolateIceCream, 4));
    }

    @Test
    void shouldPreventAddingTheFoodExceedingLimitOf100() throws BasketQuantityExceedException {
        Price seafoodPrice = Price.SGD("20.00");
        MenuItem seafoodPlatter = new MenuItem("Seafood Platter", seafoodPrice);
        Price iceCreamPrice = Price.SGD("4.00");
        MenuItem chocolateIceCream = new MenuItem("Chocolate Ice Cream", iceCreamPrice);

        Basket basket = new Basket();
        basket.addItem(seafoodPlatter, 98);

        assertThrows(
                BasketQuantityExceedException.class,
                () -> basket.addItem(chocolateIceCream, 3)
        );
    }

    @Test
    void shouldPreventAddingTheFoodExceedingLimitOf100AfterAddWithDefaultQuantity1() throws BasketQuantityExceedException {
        Price seafoodPrice = Price.SGD("20.00");
        MenuItem seafoodPlatter = new MenuItem("Seafood Platter", seafoodPrice);
        Price iceCreamPrice = Price.SGD("4.00");
        MenuItem chocolateIceCream = new MenuItem("Chocolate Ice Cream", iceCreamPrice);

        Basket basket = new Basket();
        basket.addItem(seafoodPlatter, 100);

        assertThrows(
                BasketQuantityExceedException.class,
                () -> basket.addItem(chocolateIceCream)
        );
    }

}