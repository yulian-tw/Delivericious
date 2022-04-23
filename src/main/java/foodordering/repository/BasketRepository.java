package foodordering.repository;

import foodordering.domain.entity.basket.Basket;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BasketRepository {

    private final Map<UUID, Basket> baskets = new HashMap<>();

    public void save(Basket basket) {
        this.baskets.put(basket.getBasketId(), basket);
    }

    public Map<UUID, Basket> getBaskets() {
        return baskets;
    }

}
