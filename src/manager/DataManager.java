package manager;


import task.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class DataManager {
    private static Pizza getHavaianPizza() {
        return new Pizza("Гавайська", 850, 256,
                Arrays.asList("Куряче філе", "Сир", "Ананас", "Соус"));

    }

    private static Pizza getPeperoniPizza() {
        return new Pizza("Пепероні", 780, 178,
                Arrays.asList("Пепероні", "Соус", "Сир", "Помідори черрі"));

    }

    private static Pizza getCesarePizza() {
        return new Pizza("Цезаре", 800, 217,
                Arrays.asList("Куряче філе", "Листя салату", "Помідори", "Сир", "Соус"));

    }

    public static Pizzeria getPizzeria() {
        Client Roman = new Client("Roman");
        Client Valentin = new Client("Valentin");
        Client Vlad = new Client("Vlad");
        Client Yuliya = new Client("Yuliya");
        Client Anna = new Client("Anna");

        Roman.makeOrder(new Order(
                getHavaianPizza(),
                new Address("Lukasha M.", 5, 206),
                LocalDateTime.of(2022, 11, 3, 10, 20)
        ));

        Roman.makeOrder(new Order(
                getPeperoniPizza(),
                new Address("Lukasha M.", 5, 206),
                LocalDateTime.of(2022, 11, 2, 12, 10)
        ));

        Roman.makeOrder(new Order(
                getCesarePizza(),
                new Address("Lukasha M.", 5, 206),
                LocalDateTime.of(2022, 11, 2, 14, 15)
        ));

        Vlad.makeOrder(new Order(
                getHavaianPizza(),
                new Address("Scovoroda", 48, 63),
                LocalDateTime.of(2022, 11, 3, 8, 30)
        ));

        Valentin.makeOrder(new Order(
                getPeperoniPizza(),
                new Address("Volodumurskya", 45, 99),
                LocalDateTime.of(2022, 11, 2, 11, 20)
        ));

        Yuliya.makeOrder(new Order(
                getCesarePizza(),
                new Address("Lukasha M.", 5, 206),
                LocalDateTime.of(2022, 11, 3, 14, 15)
        ));

        Anna.makeOrder(new Order(
                getCesarePizza(),
                new Address("Lukasha M.", 5, 206),
                LocalDateTime.of(2022, 11, 3, 16, 10)
        ));

        List<Client> clients = Arrays.asList(Roman, Valentin, Yuliya, Anna, Vlad);
        List<Pizza> pizzas = Arrays.asList(getHavaianPizza(), getPeperoniPizza(), getCesarePizza());

        Pizzeria pizzeria = new Pizzeria(clients, pizzas);
        SerializationManager.SerializePizzeria(pizzeria, "input.ser");

        return pizzeria;
    }
}