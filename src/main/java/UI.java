public class UI {
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
}
