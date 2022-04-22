package foodordering;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PriceTest {

    @Test
    void shouldCompare2PricesCorrectly() {
        Price underTest = Price.SGD("3");
        Price another = Price.SGD("3");
        assertEquals(underTest, another);
    }

    @Test
    void shouldMultiplyCorrectly() {
        Price underTest = Price.SGD("3");

        Price result = underTest.multiply(3);
        assertEquals(Price.SGD("9"), result);
    }

    @Test
    void shouldAddWhenCurrencyIsSame() {
        Price underTest = Price.SGD("3");
        Price another = Price.SGD("4");

        Price result = underTest.add(another);
        assertEquals(Price.SGD("7"), result);
    }

    @Test
    void shouldThrowWhenCurrencyIsNotSame() {
        Price underTest = Price.SGD("3");
        Price another = Price.USD("4");

        assertThrows(UnsupportedOperationException.class, () -> underTest.add(another));
    }
}