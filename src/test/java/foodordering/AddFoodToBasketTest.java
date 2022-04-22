package foodordering;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddFoodToBasketTest {

    private static final String TOMATO_SOUP = "Tomato Soup";
    private static final String SEAFOOD_SALAD = "Seafood Salad";
    private static final String CHOCOLATE_ICE_CREAM = "Chocolate Ice Cream";

    @Test
    void shouldAddTomatoSoupToBasket() {
        Basket basket = new Basket();
        Food tomatoSoup = new Food(TOMATO_SOUP);
        basket.addFood(tomatoSoup);

        assertEquals(1, basket.getAllItems().size());
        assertEquals(TOMATO_SOUP, basket.getAllItems().get(0).getFood().getName());
    }

    @Test
    void shouldAddSeafoodSaladWithPriceToBasket() {
        Basket basket = new Basket();
        Food seafoodSalad = new Food(SEAFOOD_SALAD, Price.SGD("12.00"));
        basket.addFood(seafoodSalad);

        assertEquals(1, basket.getAllItems().size());
        assertEquals(SEAFOOD_SALAD, basket.getAllItems().get(0).getFood().getName());
        assertEquals(Price.SGD("12.00"), basket.getTotalPrice());
    }

    @Test
    void shouldAddChocolateIceCreamWithQuantityToBasket() {
        Basket basket = new Basket();
        Price iceCreamPrice = Price.SGD("4.00");
        Food chocolateIceCream = new Food(CHOCOLATE_ICE_CREAM, iceCreamPrice);
        basket.addFood(chocolateIceCream, 3);

        assertEquals(1, basket.getAllItems().size());
        assertEquals(3, basket.getQuantityByFoodName(CHOCOLATE_ICE_CREAM));
        assertEquals(Price.SGD("12.00"), basket.getTotalPrice());
    }

}
