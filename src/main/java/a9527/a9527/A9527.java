package a9527.a9527;
import a9527.ui.Ui;

public class A9527 {
    private static boolean shouldExit = false;

    public static boolean shouldExit() {
        return shouldExit;
    }
    public static void assertShouldExit() {
        shouldExit = true;
    }

    public static void greetUser() {
        String logo = """
                \t  ___  ____  ____  _____
                \t / _ \\| ___||___ \\|___  |
                \t| (_) |___ \\  __) |  / /\s
                \t \\__/ |___) )/ __/_ / /
                \t   /_/|____/|_____//_/
                """;
        Ui.print("Hello I'm\n" + logo + "\tWhat you want me to do now?");
    }

    public static void byeUser() {
        String[] strings = {"Task list deleted :(", "(^&#$^()@&)*#(*^&(^*"};
        Ui.print(strings);
    }
}
