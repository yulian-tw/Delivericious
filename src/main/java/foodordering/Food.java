package foodordering;

public class Food {

    private final String name;
    private final Price price;

    public Food(String name) {
        checkName(name);
        this.name = name;
        this.price = null;
    }

    public Food(String name, Price price) {
        checkName(name);
        this.name = name;
        this.price = price;
    }

    private void checkName(String name) {
        if (name.isBlank()) {
            throw new UnsupportedOperationException("Food should have name");
        }
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }
}
