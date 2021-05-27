
public class Product {

    protected static int id;
    protected static String title;
    protected static int cost;

    public Product(int id, String title, int cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Product[] products = {
            new Product(1, "Apple", 57),
            new Product(2, "Peach", 68),
            new Product(3, "Carrot", 35),
            new Product(4, "Banana", 105),
            new Product(5, "Onion", 34),
            new Product(6, "Tomato", 56),
            new Product(8, "Grape", 120),
            new Product(9, "Watermelon", 92),
            new Product(10, "Cherry", 183)
    };
}

