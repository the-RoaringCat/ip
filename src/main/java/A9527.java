public class A9527 {
    public static final String LINE= "\t____________________________________________________________\n";

    public static void printWithLines(Runnable task) {
        //TODO: exception
        System.out.println(A9527.LINE);
        task.run();
        System.out.println(A9527.LINE);
    }

    public static void printAddTask(Runnable task) {
        printWithLines(()-> {
            System.out.println("Got it. I've added this task:");
            task.run();
            System.out.println("\t" + Task.getTasks()[Task.getTaskCount() - 1].toString());
            System.out.println("Now you have " + Task.getTaskCount() +
                    (Task.getTaskCount() == 1 ? " task in the list." : " tasks in the list."));
        });

    }


    public static void greetUser() {
        String logo = """
                \t  ___  ____  ____  _____
                \t / _ \\| ___||___ \\|___  |
                \t| (_) |___ \\  __) |  / /\s
                \t \\__/ |___) )/ __/_ / /
                \t   /_/|____/|_____//_/
                """;
        System.out.println(LINE + "\tHello I'm\n" + logo + "\tWhat can I do for you?\n" +LINE);

    }

    public static void byeUser() {
        System.out.println(LINE + "\tBye. Hope to see you again soon!\n" + LINE);
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
