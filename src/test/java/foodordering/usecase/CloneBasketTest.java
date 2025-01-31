package foodordering.usecase;

import foodordering.domain.BasketQuantityExceedException;
import foodordering.domain.Price;
import foodordering.domain.entity.basket.Basket;
import foodordering.domain.entity.MenuItem;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CloneBasketTest {

    @Test
    void shouldCloneBasketIntoBasketWithDifferentBasketIdAndAlsoDifferentBasketItem() throws BasketQuantityExceedException {

        Basket existing = new Basket();
        MenuItem seafoodSalad = new MenuItem("Seafood Salad", Price.SGD("10"));
        UUID seafoodSaladUuid = seafoodSalad.getUuid();
        existing.addItem(seafoodSalad, 4);
        assertEquals(4, existing.getQuantityByMenuItemId(seafoodSaladUuid));

        Basket resultingBasket = existing.duplicate();
        resultingBasket.removeItemByMenuItemId(seafoodSaladUuid, 1);

        assertNotEquals(existing.getBasketId(), resultingBasket.getBasketId());
        assertEquals(4, existing.getQuantityByMenuItemId(seafoodSaladUuid));
        assertEquals(3, resultingBasket.getQuantityByMenuItemId(seafoodSaladUuid));

    }

}
