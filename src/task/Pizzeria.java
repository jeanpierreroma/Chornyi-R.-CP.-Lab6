package task;
import manager.InputManager;
import manager.OutputManager;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Pizzeria implements Serializable {
    private List<Client> clientList;
    private List<Pizza> pizzaList;

    public Pizzeria(List<Client> clientList, List<Pizza> pizzaList) {
        this.clientList = clientList;
        this.pizzaList = pizzaList;
    }

    public void Task1() {
        OutputManager.ShowMessage("3. Відсортувати всі замовлення за часом доставки.");

        var orders = clientList.stream().map(Client::getOrders).flatMap(List::stream).toList();
        var result = orders.stream().sorted(Comparator.comparing(Order::getDeliveryTime)).toList();

        OutputManager.printIdTimeList("№ \t\tЧас доставки", result);
    }

    public void Task2() {
        OutputManager.ShowMessage("4. Створити список адрес для користувачів, що замовили більше ніж 2 піци.");

        var neededClients = clientList.stream()
                .filter(x -> x.getOrders().size() > 2).toList();

        OutputManager.printAdresses(neededClients);
    }

    public void Task3() {
        OutputManager.ShowMessage("5. Перевірити, скільки користувачів замовили піцу з заданою назвою");

        String pizzaName = InputManager.GetUserInputString("Назва піци: ");
        var count = clientList.stream()
                .filter(x -> x.getOrders().stream()
                        .anyMatch(y -> y.getPizza().getName().equals(pizzaName))).count();


        OutputManager.ShowMessage("Замовлень піци " + pizzaName + " - " + count);
    }

    public void Task4() {
        OutputManager.ShowMessage("6. Знайти найбільшу кількість піц, замовлених користувачем серед запропонованого переліку піц.");

        var maxNumberPizzas = clientList.stream()
                .map(x -> x.getOrders().size()).max(Integer::compare).get();

        OutputManager.ShowMessage("Найбільша кількість піц, замовлених одним відвідувачем: " + maxNumberPizzas);
    }

    public void Task5() {
        OutputManager.ShowMessage("7. Створити колекцію з переліком піц та списками їх замовників.");

        HashMap<Pizza, List<Client>> pizzaClientMap = new HashMap<>();

        for (Pizza pizza : pizzaList) {
            var res = clientList.stream().
                    filter(x -> x.getOrders().stream()
                            .anyMatch(y -> pizza.getName().equals(y.getPizza().getName()))
                    ).toList();
            pizzaClientMap.put(pizza, res);
        }

        OutputManager.showPizzaClientMap(pizzaClientMap);
    }

    public void Task6() {
        OutputManager.ShowMessage("8. Створити список не виконаних замовлень на біжучий час, та вказати час перетермінування.");
        String str = InputManager.GetUserInputLine("Введіть дату у форматі \"dd-MM-yyyy HH:mm\": ");

        try{
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(str, dateTimeFormatter);

            var orders = clientList.stream().map(Client::getOrders).flatMap(List::stream).toList();

            var notCompleted = orders.stream().filter(x -> dateTime.isAfter(x.getDeliveryTime())).toList();

            var result = notCompleted.stream()
                    .collect(Collectors.toMap(x -> x, y -> Duration.between(y.getDeliveryTime(), dateTime)));

            OutputManager.printTask6(result);
        }
        catch (DateTimeParseException e) {
            OutputManager.ShowMessage(e.getMessage());
        }
    }
}