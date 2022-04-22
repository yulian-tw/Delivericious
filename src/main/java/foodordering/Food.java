package foodordering;

import java.math.BigDecimal;

public class Food {

    private final String name;
    private final BigDecimal price;

    public Food(String name) {
        this.name = name;
        this.price = null;
    }

    public Food(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
