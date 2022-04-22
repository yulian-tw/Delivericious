package foodordering;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddFoodToBasketTest {

    @Test
    void shouldAddTomatoSoupToBasket() {
        Basket basket = new Basket();
        Food tomatoSoup = new Food("Tomato Soup");
        basket.addFood(tomatoSoup);

        assertEquals(1, basket.getAllItems().size());
        assertEquals("Tomato Soup", basket.getAllItems().get(0).getFood().getName());
    }

    @Test
    void shouldAddSeafoodSaladWithPriceToBasket() {
        Basket basket = new Basket();
        Food seafoodSalad = new Food("Seafood Salad", Price.SGD("12.00"));
        basket.addFood(seafoodSalad);

        assertEquals(1, basket.getAllItems().size());
        assertEquals("Seafood Salad", basket.getAllItems().get(0).getFood().getName());
        assertEquals(Price.SGD("12.00"), basket.getTotalPrice());
    }

    @Test
    void shouldAddChocolateIceCreamWithQuantityToBasket() {
        Basket basket = new Basket();
        Price iceCreamPrice = Price.SGD("4.00");
        Food chocolateIceCream = new Food("Chocolate Ice Cream", iceCreamPrice);
        basket.addFood(chocolateIceCream, 3);

        assertEquals(1, basket.getAllItems().size());
        assertEquals("Chocolate Ice Cream", basket.getAllItems().get(0).getFood().getName());
        assertEquals(Price.SGD("12.00"), basket.getTotalPrice());
    }

}
