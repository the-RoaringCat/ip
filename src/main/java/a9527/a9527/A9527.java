package a9527.a9527;
import a9527.ui.Ui;

public class A9527 {
    public static final String LINE= "\t____________________________________________________________\n";


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


    //TODO: extract method need deal with missing delimiter
    public static String extractBefore(String string, String delimiter) {
        int indexOfDelimiter = string.indexOf(delimiter);
        return string.substring(0, indexOfDelimiter);
    }

    public static String extractBetween(String string, String startDelimiter, String endDelimiter) {
        int indexOfStartDelimiter = string.indexOf(startDelimiter);
        int indexOfEndDelimiter = string.indexOf(endDelimiter);

        return string.substring(indexOfStartDelimiter + startDelimiter.length(), indexOfEndDelimiter);
    }

    public static String extractAfter(String string, String delimiter) {
        int indexOfDelimiter = string.indexOf(delimiter);
        return string.substring(indexOfDelimiter + delimiter.length());
    }

}
