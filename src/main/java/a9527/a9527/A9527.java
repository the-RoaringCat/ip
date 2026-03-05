package a9527.a9527;
import a9527.ui.Ui;

public class A9527 {
    private static boolean shouldExit = false;



    /**
     * Returns boolean state of shouldExit.
     * @return shouldExit
     */
    public static boolean shouldExit() {
        return shouldExit;
    }

    /**
     * Sets shouldExit to true
     */
    public static void assertShouldExit() {
        shouldExit = true;
    }

    /**
     * Prints greeting message to the user on CLI
     */
    public static void greetUser() {
        String logo = """
                  ___  ____  ____  _____
                \t / _ \\| ___||___ \\|___  |
                \t| (_) |___ \\  __) |  / /\s
                \t \\__/ |___) )/ __/_ / /
                \t   /_/|____/|_____//_/
                """;
        Ui.print("Hello I'm" + System.lineSeparator() + logo + "\tWhat you want me to do now?");
    }

    /**
     * Prints farewell message to the user on CLI
     */
    public static void byeUser() {
        String[] strings = {"Remember to do your task", "(^&#$^()@&)*#(*^&(^*"};
        Ui.print(strings);
    }
}
