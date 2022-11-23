package task;
import java.io.Serializable;
import java.util.List;

public class Pizza implements Serializable {
    private final String name;
    private final int weight;
    private final int price;
    private final List<String> ingredients;

    public Pizza(String name, int weight, int price, List<String> ingredients) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.ingredients = ingredients;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                ", ingredients=" + ingredients +
                '}';
    }
}