package manager;

import java.util.Scanner;

public class InputManager {
    static Scanner scanner = new Scanner(System.in);
    public static int GetUserInputInt(){
        int res;
        try {
            res = Integer.parseInt(scanner.next());
        }
        catch (NumberFormatException e) {
            System.out.println(e);
            res = -1;
        }
        return res;
    }

    public static String GetUserInputString(String description) {
        System.out.print(description);
        String res = scanner.next();
        return res;
    }

    public static String GetUserInputLine(String description) {
        System.out.print(description);
        String res = new Scanner(System.in).nextLine();
        return res;
    }
}
