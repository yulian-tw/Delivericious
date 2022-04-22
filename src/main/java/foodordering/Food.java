package foodordering;

public class Food {

    private final String name;
    private final Price price;

    public Food(String name) {
        this.name = name;
        this.price = null;
    }

    public Food(String name, Price price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }
}
