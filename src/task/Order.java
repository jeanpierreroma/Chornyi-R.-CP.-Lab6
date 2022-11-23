package task;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Order implements Serializable {
    private static int count = 1;
    private final int id;
    private final Pizza pizza;
    private final Address address;
    private final LocalDateTime deliveryTime;

    public Order(Pizza pizza, Address address, LocalDateTime deliveryTime) {
        this.id = count++;
        this.pizza = pizza;
        this.address = address;
        this.deliveryTime = deliveryTime;
    }

    public int getId() {
        return id;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public Address getAddress() {
        return address;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", pizza=" + pizza +
                ", address=" + address +
                ", deliveryTime=" + deliveryTime +
                "}\n\n";
    }
}
