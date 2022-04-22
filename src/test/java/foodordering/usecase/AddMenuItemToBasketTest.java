package foodordering.usecase;

import foodordering.Basket;
import foodordering.entity.MenuItem;
import foodordering.Price;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AddMenuItemToBasketTest {

    @Test
    void shouldAddTomatoSoupToBasketWithDefaultQuantityEqualsOne() {
        Basket basket = new Basket();
        MenuItem tomatoSoup = new MenuItem("Tomato Soup");
        basket.addItem(tomatoSoup);

        assertEquals(1, basket.getBasketSize());
        assertEquals(1, basket.getQuantityByMenuItemId(tomatoSoup.getUuid()));
    }

    @Test
    void shouldAddSeafoodSaladWithPriceToBasketWithDefaultQuantityEqualsOne() {
        Basket basket = new Basket();
        MenuItem seafoodSalad = new MenuItem("Seafood Salad", Price.SGD("12.00"));
        basket.addItem(seafoodSalad);

        assertEquals(1, basket.getBasketSize());
        assertEquals(1, basket.getQuantityByMenuItemId(seafoodSalad.getUuid()));
        assertEquals(Price.SGD("12.00"), basket.getTotalPrice());
    }

    @Test
    void shouldAddChocolateIceCreamWithQuantityToBasket() {
        Basket basket = new Basket();
        Price iceCreamPrice = Price.SGD("4.00");
        MenuItem chocolateIceCream = new MenuItem("Chocolate Ice Cream", iceCreamPrice);
        basket.addItem(chocolateIceCream, 3);

        assertEquals(1, basket.getBasketSize());
        assertEquals(3, basket.getQuantityByMenuItemId(chocolateIceCream.getUuid()));
        assertEquals(Price.SGD("12.00"), basket.getTotalPrice());
    }

    @Test
    void shouldPreventAddingTheFoodWithSameNameAgain() {
        Basket basket = new Basket();
        Price iceCreamPrice = Price.SGD("4.00");
        MenuItem chocolateIceCream = new MenuItem("Chocolate Ice Cream", iceCreamPrice);
        basket.addItem(chocolateIceCream, 3);

        assertThrows(UnsupportedOperationException.class, () -> basket.addItem(chocolateIceCream, 4));
    }

}
