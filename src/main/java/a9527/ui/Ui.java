package a9527.ui;
public class Ui {
    public static final String LINE= "\t____________________________________________________________________________";


    public static void printWithinLines(Runnable task) {
        System.out.println(LINE);
        task.run();
        System.out.println(LINE);
    }

    public static void print(String[] strings) {
        printWithinLines(() -> {
            for(String string : strings) {
                System.out.println("\t" + string);
            }
        });
    }

    public static void print(String string) {
        printWithinLines(() -> System.out.println("\t" + string));
    }
}
