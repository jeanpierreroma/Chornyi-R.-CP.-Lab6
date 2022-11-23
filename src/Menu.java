import java.util.ArrayList;

import manager.DataManager;
import manager.InputManager;
import manager.OutputManager;
import manager.SerializationManager;
import task.Pizzeria;

public class Menu {
    private final ArrayList<String> menuOptions;

    Menu() {
        this.menuOptions = new ArrayList<>();

        menuOptions.add("\n1. Серіалізувати дані");
        menuOptions.add("2. Десеріалізувати дані");
        menuOptions.add("3. Відсортувати всі замовлення за часом доставки.");
        menuOptions.add("4. Створити список адрес для користувачів, що замовили більше ніж 2 піци.");
        menuOptions.add("5. Перевірити, скільки користувачів замовили піцу з заданою назвою.");
        menuOptions.add("6. Знайти найбільшу кількість піц, замовлених користувачем серед запропонованого переліку піц.");
        menuOptions.add("7. Створити колекцію з переліком піц та списками їх замовників.");
        menuOptions.add("8. Створити список не виконаних замовлень на біжучий час, та вказати час перетермінування.");
        menuOptions.add("9. Вихід з програми.");
    }

    private boolean isNull(Object obj) {
        return obj == null;
    }

    public void start() {
        Pizzeria pizzeria = null;

        int userInput;
        do {
            OutputManager.ShowMenu(menuOptions);
            userInput = InputManager.GetUserInputInt();

            switch (userInput) {
                case 1:
//                    pizzeria = DataManager.getPizzeria();
                    if(isNull(pizzeria)) {
                        OutputManager.ShowMessage("Спочатку треба десеріалізувати дані. Виберіть пункт 2");
                    }
                    else {
                        OutputManager.ShowMessage("1. Виконуємо серіалізацію даних...");
                        SerializationManager.SerializePizzeria(pizzeria, "output.ser");
                    }
                    break;
                case 2:
                    OutputManager.ShowMessage("2. Виконуємо десеріалізацію даних...");
                    pizzeria = SerializationManager.DeserializePizzeria("input.ser");
                    break;
                case 3:
                    if(isNull(pizzeria)) {
                        OutputManager.ShowMessage("Спочатку треба десеріалізувати дані. Виберіть пункт 2");
                    }
                    else {
                        pizzeria.Task1();
                    }
                    break;
                case 4:
                    if(isNull(pizzeria)) {
                        OutputManager.ShowMessage("Спочатку треба десеріалізувати дані. Виберіть пункт 2");
                    }
                    else {
                        pizzeria.Task2();
                    }
                    break;
                case 5:
                    if(isNull(pizzeria)) {
                        OutputManager.ShowMessage("Спочатку треба десеріалізувати дані. Виберіть пункт 2");
                    }
                    else {
                        pizzeria.Task3();
                    }
                    break;
                case 6:
                    if(isNull(pizzeria)) {
                        OutputManager.ShowMessage("Спочатку треба десеріалізувати дані. Виберіть пункт 2");
                    }
                    else {
                        pizzeria.Task4();
                    }
                    break;
                case 7:
                    if(isNull(pizzeria)) {
                        OutputManager.ShowMessage("Спочатку треба десеріалізувати дані. Виберіть пункт 2");
                    }
                    else {
                        pizzeria.Task5();
                    }
                    break;
                case 8:
                    if(isNull(pizzeria)) {
                        OutputManager.ShowMessage("Спочатку треба десеріалізувати дані. Виберіть пункт 2");
                    }
                    else {
                        pizzeria.Task6();
                    }
                    break;
                case 9:
                    OutputManager.ShowMessage("Виконуєься вихід із програми...");
                    break;
                default:
                    OutputManager.ShowMessage("--\nВведено неправильну цифру. Повторіть спробу\n--");
            }
        } while (userInput != 9);

    }
}
