package foodordering;

import java.math.BigDecimal;
import java.util.Objects;

public class Price {

    private final BigDecimal value;
    private final Currency currency;

    public Price(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public static Price SGD(String value) {
        return new Price(
                new BigDecimal(value),
                Currency.SGD
        );
    }

    public BigDecimal getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return value.equals(price.value) && currency == price.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, currency);
    }

    @Override
    public String toString() {
        return "Price{" +
                "value=" + value +
                ", currency=" + currency +
                '}';
    }
}
