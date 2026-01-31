public class Task {
    private static int taskCount = 0;
    private static Task[] tasks = new Task[100];

    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public static int getTaskCount() {
        return taskCount;
    }
    public static Task[] getTasks() {
        return tasks;
    }

    public static void addTask(String description) {
        tasks[taskCount] = new Task(description);
        taskCount ++;
    }

    public static void printTasks() {
        if(taskCount == 0) {
            System.out.println("\tNo task.");
            return;
        }

        for (int i = 0; i < taskCount ; i++) {
            System.out.println("\t" + (i + 1) + "." + "[" + tasks[i].getStatusIcon() + "] " + tasks[i].getDescription());
        }
    }

    public static void printTask(int taskIndex) {
        System.out.println("\t\t["+ tasks[taskIndex - 1].getStatusIcon() + "] " + tasks[taskIndex - 1].getDescription());
    }

    public static void unmarkTasksMsg() {
        System.out.println("\tOK, I've marked this task as not done yet:");
    }
    public static void unmarkTasks(int taskIndex) {
        tasks[taskIndex - 1].markNotDone();
    }

    public static void markTasksMsg() {
        System.out.println("\tNice! I've marked this task as done:");
    }
    public static void markTasks(int taskIndex) {
        tasks[taskIndex - 1].markDone();
    }


    public String getStatusIcon() {
        return (isDone? "X" : " ");
    }

    public String getDescription() {
        return this.description;
    }


    public void markDone() {
        this.isDone = true;
    }

    public void markNotDone() {
        this.isDone = false;
    }

}
