package foodordering;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class BasketItemTest {

    BasketItem underTest;

    @Test
    void getPriceShouldPassTheQuantityToFood() {
        int quantity = 3;
        Food mockFood = mock(Food.class);
        Price mockPrice = mock(Price.class);

        when(mockFood.getPrice()).thenReturn(mockPrice);

        underTest = new BasketItem(mockFood, quantity);
        underTest.getPrice();

        verify(mockPrice, times(1)).multiply(quantity);
    }

}