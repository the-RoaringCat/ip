package a9527.ui;
public class Ui {
    public static final String LINE= "\t____________________________________________________________";


    public static void printWithinLines(Runnable task) {
        System.out.println(LINE);
        task.run();
        System.out.println(LINE);
    }

//    public static void printAddTask(Task task) {
//        printWithinLines(()-> {
//            System.out.println("\tGot it. I've added this task:");
//            System.out.println("\t" + task.toString());
//            System.out.println("\tNow you have " + TaskList.getTaskCount() +
//                    (TaskList.getTaskCount() == 1 ? " task in the list." : " tasks in the list."));
//        });
//    }

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
