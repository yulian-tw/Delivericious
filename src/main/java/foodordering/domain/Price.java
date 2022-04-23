package foodordering.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Price {

    private final BigDecimal value;
    private final Currency currency;

    private Price(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public static Price SGD(String value) {
        return new Price(
                new BigDecimal(value),
                Currency.SGD
        );
    }

    public static Price USD(String value) {
        return new Price(
                new BigDecimal(value),
                Currency.USD
        );
    }

    public Currency getCurrency() {
        return currency;
    }

    public Price multiply(int quantity) {
        BigDecimal newValue = this.value.multiply(BigDecimal.valueOf(quantity));
        return new Price(newValue, this.currency);
    }

    public Price add(Price other) {
        if (!this.currency.equals(other.currency)) {
            throw new UnsupportedOperationException("Currency Mismatch");
        }

        BigDecimal newValue = this.value.add(other.value);
        return new Price(newValue, this.currency);
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
