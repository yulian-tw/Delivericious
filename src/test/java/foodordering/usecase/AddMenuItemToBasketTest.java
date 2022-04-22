package foodordering.usecase;

import foodordering.Basket;
import foodordering.MenuItem;
import foodordering.Price;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AddMenuItemToBasketTest {

    private static final String TOMATO_SOUP = "Tomato Soup";
    private static final String SEAFOOD_SALAD = "Seafood Salad";
    private static final String CHOCOLATE_ICE_CREAM = "Chocolate Ice Cream";

    @Test
    void shouldAddTomatoSoupToBasket() {
        Basket basket = new Basket();
        MenuItem tomatoSoup = new MenuItem(TOMATO_SOUP);
        basket.addItem(tomatoSoup);

        assertEquals(1, basket.getAllItems().size());
        assertEquals(TOMATO_SOUP, basket.getAllItems().get(0).getFoodName());
    }

    @Test
    void shouldAddSeafoodSaladWithPriceToBasket() {
        Basket basket = new Basket();
        MenuItem seafoodSalad = new MenuItem(SEAFOOD_SALAD, Price.SGD("12.00"));
        basket.addItem(seafoodSalad);

        assertEquals(1, basket.getAllItems().size());
        assertEquals(SEAFOOD_SALAD, basket.getAllItems().get(0).getFoodName());
        assertEquals(Price.SGD("12.00"), basket.getTotalPrice());
    }

    @Test
    void shouldAddChocolateIceCreamWithQuantityToBasket() {
        Basket basket = new Basket();
        Price iceCreamPrice = Price.SGD("4.00");
        MenuItem chocolateIceCream = new MenuItem(CHOCOLATE_ICE_CREAM, iceCreamPrice);
        basket.addItem(chocolateIceCream, 3);

        assertEquals(1, basket.getAllItems().size());
        assertEquals(3, basket.getQuantityByFoodName(CHOCOLATE_ICE_CREAM));
        assertEquals(Price.SGD("12.00"), basket.getTotalPrice());
    }

    @Test
    void shouldPreventAddingTheFoodWithSameNameAgain() {
        Basket basket = new Basket();
        Price iceCreamPrice = Price.SGD("4.00");
        MenuItem chocolateIceCream = new MenuItem(CHOCOLATE_ICE_CREAM, iceCreamPrice);
        basket.addItem(chocolateIceCream, 3);

        assertThrows(UnsupportedOperationException.class, () -> basket.addItem(chocolateIceCream, 4));
    }

}
