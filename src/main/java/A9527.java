import java.util.Random;

public class A9527 {
    public static final String LINE= "\t____________________________________________________________\n";

    public static void printWithinLines(Runnable task) {
        //TODO: exception
        System.out.println(A9527.LINE);
        task.run();
        System.out.println(A9527.LINE);
    }

    public static void printAddTask(Task task) {
        printWithinLines(()-> {
            System.out.println("\tGot it. I've added this task:");
            System.out.println("\t" + task.toString());
            System.out.println("\tNow you have " + TaskList.getTaskCount() +
                    (TaskList.getTaskCount() == 1 ? " task in the list." : " tasks in the list."));
        });
    }

    public static void bootNoise() {
        //this is from GPT, just for fun.
        Random r = new Random();

        for (int i = 0; i < 20; i++) {
            int len = 30 + r.nextInt(40); // line length
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < len; j++) {
                char c = (char) (33 + r.nextInt(94)); // printable ASCII
                sb.append(c);
            }

            System.out.println(sb);
            long end = System.currentTimeMillis() + 35;
            while(System.currentTimeMillis() < end) {
            }
        }
    }





    public static void greetUser(boolean isBootNoise) {
        if(isBootNoise) bootNoise();
        String logo = """
                \t  ___  ____  ____  _____
                \t / _ \\| ___||___ \\|___  |
                \t| (_) |___ \\  __) |  / /\s
                \t \\__/ |___) )/ __/_ / /
                \t   /_/|____/|_____//_/
                """;
        System.out.println(LINE + "\tHello I'm\n" + logo + "\tWhat you want me to do now?\n" +LINE);
    }

    public static void byeUser() {
        System.out.println(LINE + "\tTask list deleted :(\n" + "\t(^&#$^()@&)*#\n" + LINE);
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
