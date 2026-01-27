public class Task {
    protected String description;
    protected boolean isDone;

    private static int taskCount = 0;
    private static Task[] tasks = new Task[100];

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
        } else {
            for (int i = 0; i < taskCount ; i++) {
                System.out.println("\t" + (i + 1) + "." + "[" + tasks[i].getStatusIcon() + "] " + tasks[i].getDescription());
            }
        }

    }

    public static void printTask(int taskIndex) {
        System.out.println("\t\t["+ tasks[taskIndex - 1].getStatusIcon() + "] " + tasks[taskIndex - 1].getDescription());
    }

    public static void unmarkTasks(int taskIndex) {
        tasks[taskIndex - 1].markNotDone();
    }

    public static void markTasks(int taskIndex) {
        //TODO: can add try catch here later for invalid index
        //TODO: index bound check
        tasks[taskIndex - 1].markDone();
    }
    public Task(String description) {
        this.description = description;
        this.isDone = isDone;
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
