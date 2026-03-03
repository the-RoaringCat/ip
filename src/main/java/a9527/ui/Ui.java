package a9527.ui;

import java.util.ArrayList;

public class Ui {
    public static final String LINE= "\t____________________________________________________________________________";


    /**
     * Prints a line, calls the method, then prints another lines.
     * @param task a method
     */
    public static void printWithinLines(Runnable task) {
        System.out.println(LINE);
        task.run();
        System.out.println(LINE);
    }

    /**
     * Prints the strings line by line between a pair of separation lines.
     * @param strings
     */
    public static void print(String[] strings) {
        printWithinLines(() -> {
            for(String string : strings) {
                System.out.println("\t" + string);
            }
        });
    }

    /**
     * Prints the strings line by line between a pair of separation lines
     * @param strings
     */
    public static void print(ArrayList<String> strings) {
        printWithinLines(() -> {
            for(String string : strings) {
                System.out.println("\t" + string);
            }
        });
    }

    /**
     * Prints a string between a pair of separation lines
     * @param string
     */
    public static void print(String string) {
        //no direct print as only one tab is printed when string is converted from string builder
        String[] strings = string.split(System.lineSeparator());
        print(strings);
    }
}
