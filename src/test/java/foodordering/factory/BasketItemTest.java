package foodordering.factory;

import foodordering.Price;
import foodordering.entity.MenuItem;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class BasketItemTest {

    BasketItem underTest;

    @Test
    void getPriceShouldPassTheQuantityToFood() {
        int quantity = 3;
        MenuItem mockMenuItem = mock(MenuItem.class);
        Price mockPrice = mock(Price.class);

        when(mockMenuItem.getPrice()).thenReturn(mockPrice);

        underTest = BasketItem.createNew(mockMenuItem, quantity);
        underTest.getPrice();

        verify(mockPrice, times(1)).multiply(quantity);
    }

}