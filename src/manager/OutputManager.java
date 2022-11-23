package manager;

import task.Address;
import task.Client;
import task.Order;
import task.Pizza;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputManager {

    public static void ShowMenu(List<String> options) {
        for (String item : options) {
            System.out.println(item);
        }
    }

    public static void ShowMessage(String s) {
        System.out.println(s);
    }

    public static void printIdTimeList(String s, List<Order> result) {
        System.out.println(s);
        for (Order item : result) {
            System.out.println(String.format("%-8d%s", item.getId(), item.getDeliveryTime().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"))));
        }
    }

    public static void printAdresses(List <Client> neededClients) {
        System.out.println(String.format("%-16s%-16s%-12s%-15s", "Вулиця", "№ будинку", "№ квартири", "К-сть замовлень"));
        for (Client client : neededClients) {
            for (Order order : client.getOrders()) {
                Address address = order.getAddress();
                System.out.println(String.format("%-16s%-16s%-12s%-15s", address.getStreet(),
                        address.getBuildingNumber(), address.getFlatNumber(), client.getOrders().size()));
            }
        }
    }

    public static void showPizzaClientMap(HashMap<Pizza, List<Client>> pizzaClientMap) {
        System.out.println(String.format("%-16s%-16s", "Назва","Список замовників"));
        for (var key : pizzaClientMap.keySet()) {
            System.out.println(String.format("%-16s%-16s", key.getName(), pizzaClientMap.get(key)));
        }
    }

    public static void printTask6(Map<Order, Duration> result) {
        OutputManager.ShowMessage(String.format("%-12s%s", "Замовлення", "Протермінування"));

        result.forEach((x, y) -> System.out.println(String.format("%-12s%s д. %s год. %s хв.",
                x.getId(), y.toDays(), y.toHours(), y.toMinutes())));

    }
}
