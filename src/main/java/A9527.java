public class A9527 {
    public static final String LINE= "\t____________________________________________________________\n";

//    private static int taskCount = 0;
//    private static Task[] tasks = new Task[100];


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

//    public static int getTaskCount() {
//        return taskCount;
//    }

//    public static Task[] getTasks() {
//        return tasks;
//    }

//    public static void addTask(String description) {
//        tasks[taskCount] = new Task(description);
//        taskCount ++;
//    }

//    public static void printTasks() {
//        System.out.println(LINE);
//        if(taskCount == 0) {
//            System.out.println("\tNo task.");
//        } else {
//            for (int i = 0; i < taskCount ; i++) {
//                System.out.println((i + 1) + "." + "[" + tasks[i].getStatusIcon() + "] " + tasks[i].getDescription());
//            }
//        }
//        System.out.println(LINE);
//    }
}
