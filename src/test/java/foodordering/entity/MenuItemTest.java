package foodordering.entity;

import foodordering.Price;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MenuItemTest {

    @Test
    void constructorShouldPreventEmptyName() {
        assertThrows(Exception.class, () -> new MenuItem(""));
    }

    @Test
    void constructorWithQuantityShouldPreventEmptyName() {
        assertThrows(Exception.class, () -> new MenuItem("", Price.SGD("2")));
    }

}