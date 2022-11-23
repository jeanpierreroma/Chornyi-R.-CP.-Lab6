package task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Client implements Serializable {
    public void makeOrder(Order order) {
        if(order != null) {
            orders.add(order);
        }
    }
    private static int count = 1;
    private final int id;
    private final String name;
    private final List<Order> orders;

    public Client(String name) {
        this.id = count++;
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return name;
    }
}