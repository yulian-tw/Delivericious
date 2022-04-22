package foodordering;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {

    @Test
    void constructorShouldPreventEmptyName() {
        assertThrows(Exception.class, () -> new Food(""));
    }

    @Test
    void constructorWithQuantityShouldPreventEmptyName() {
        assertThrows(Exception.class, () -> new Food("", Price.SGD("2")));
    }

}