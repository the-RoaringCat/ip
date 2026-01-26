public class A9527 {
    public static final String LINE= "\t____________________________________________________________\n";

    private static int taskCount = 0;
    private static String[] taskNames = new String[100];


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

    public static int getTaskCount() {
        return taskCount;
    }

    public static String[] getTaskNames() {
        return taskNames;
    }

    public static void addTask(String taskName) {
        taskNames[taskCount] = taskName;
        taskCount ++;
    }

    public static void printTask() {
        System.out.println(LINE);
        if(taskCount == 0) {
            System.out.println("\tNo task.");
        } else {
            for (int i = 1; i <= taskCount ; i++) {
                System.out.printf("\t%d. %s%n", i, taskNames[i - 1]);
            }
        }
        System.out.println(LINE);
    }
}
