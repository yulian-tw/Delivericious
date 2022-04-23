package foodordering;

import foodordering.entity.MenuItem;
import foodordering.entity.basket.Basket;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketStorageTest {

    @Test
    void saveABasket() throws BasketQuantityExceedException {

        Price seafoodPrice = Price.SGD("20.00");
        MenuItem seafoodPlatter = new MenuItem("Seafood Platter", seafoodPrice);

        Basket basket = new Basket();
        basket.addItem(seafoodPlatter, 100);

        UUID basketID = basket.getBasketId();
        BasketStorage basketStorage = new BasketStorage();
        basketStorage.save(basket);

        assertEquals(1, basketStorage.getBaskets().size());
        assertEquals(basket, basketStorage.getBaskets().get(basketID));
    }

}