public class TaskList {
    protected static int taskCount = 0;
    protected static Task[] tasks = new Task[100];

    public static int getTaskCount() {
        return taskCount;
    }

    public static Task[] getTasks() {
        return tasks;
    }

    public static void addToTaskList(Task task) {
        tasks[taskCount] = task;
        taskCount ++;
    }

    public static void printTaskList() {
        if(taskCount == 0) {
            System.out.println("\tNo task.");
            return;
        }

        for (int i = 0; i < taskCount ; i++) {
            System.out.println("\t" + (i + 1) + "." + tasks[i].toString());
        }
    }



    public static void printAddUnmark(int taskIndex) {
        if(tasks[taskIndex - 1].isDone()) {
            System.out.println("\tHaiyah, so you didn't do?");
        } else {
            System.out.println("\tI know you didn't finish");
        }

        tasks[taskIndex - 1].markNotDone();
        System.out.println("\t\t"+ tasks[taskIndex - 1].toString());
    }
    public static void unmark(int taskIndex) {
        tasks[taskIndex - 1].markNotDone();
    }

    public static void printAndMark(int taskIndex) {
        if(tasks[taskIndex - 1].isDone()) {
            System.out.println("\tDone already, you just redo ah?");
        } else {
            System.out.println("\tGood good, finally done! Need wait so long :)");
        }

        tasks[taskIndex - 1].markDone();
        System.out.println("\t\t"+ tasks[taskIndex - 1].toString());
    }
    public static void mark(int taskIndex) {
        tasks[taskIndex - 1].markDone();
    }
}
