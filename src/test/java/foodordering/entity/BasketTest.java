package foodordering.entity;

import foodordering.BasketQuantityExceedException;
import foodordering.Price;
import foodordering.entity.basket.Basket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BasketTest {

    Basket underTest;

    @Test
    void getTotalPriceShouldReturnZeroWhenBasketIsEmpty() {
        underTest = new Basket();
        Price result = underTest.getTotalPrice();
        assertEquals(Price.SGD("0.00"), result);
    }

    @Test
    void getTotalPriceShouldDelegateToMenuItemPrice() throws BasketQuantityExceedException {
        int quantity = 3;
        MenuItem mockMenuItem = mock(MenuItem.class);
        Price priceSpy = spy(Price.SGD("2"));

        when(mockMenuItem.getPrice()).thenReturn(priceSpy);

        underTest = new Basket();
        underTest.addItem(mockMenuItem, quantity);
        underTest.getTotalPrice();

        verify(priceSpy, times(1)).multiply(quantity);
    }

}