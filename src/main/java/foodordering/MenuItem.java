package foodordering;

public class MenuItem {

    private final String name;
    private final Price price;

    public MenuItem(String name) {
        checkName(name);
        this.name = name;
        this.price = null;
    }

    public MenuItem(String name, Price price) {
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
