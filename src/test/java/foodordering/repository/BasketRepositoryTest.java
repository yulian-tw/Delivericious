package foodordering.repository;

import foodordering.domain.BasketQuantityExceedException;
import foodordering.domain.Price;
import foodordering.domain.entity.MenuItem;
import foodordering.domain.entity.basket.Basket;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketRepositoryTest {

    @Test
    void saveABasket() throws BasketQuantityExceedException {

        Price seafoodPrice = Price.SGD("20.00");
        MenuItem seafoodPlatter = new MenuItem("Seafood Platter", seafoodPrice);

        Basket basket = new Basket();
        basket.addItem(seafoodPlatter, 100);

        UUID basketID = basket.getBasketId();
        BasketRepository basketRepository = new BasketRepository();
        basketRepository.save(basket);

        assertEquals(1, basketRepository.getBaskets().size());
        assertEquals(basket, basketRepository.getBaskets().get(basketID));
    }

}