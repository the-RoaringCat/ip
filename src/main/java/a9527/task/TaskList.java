package a9527.task;
import a9527.ui.Ui;
import a9527.exception.A9527TaskNotExistException;
import java.util.ArrayList;

public class TaskList {
    protected static ArrayList<Task> tasks= new ArrayList<>();


    public static ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Finds all tasks with matching description
     * @param description
     * @return An arraylist of task found.
     */
    public static ArrayList<Task> findTasks(String description) {
        ArrayList<Task> neededTasks = new ArrayList<>();
        for(Task task : tasks) {
            if(task.isContain(description)) {
                neededTasks.add(task);
            }
        }
        return neededTasks;
    }

    /**
     * Prints all tasks with matching description
     * @param description
     */
    public static void findTasksAndPrint(String description) {
        printTaskList(findTasks(description));
    }


    private static void checkTaskIndexBound(int taskIndex) throws A9527TaskNotExistException {
        if(taskIndex > tasks.size() || taskIndex < 1) {
            throw new A9527TaskNotExistException("haiyah, task with index " + taskIndex + " does not exist");
        }
    }

    private static Task getTaskOfIndex(int taskIndex) throws A9527TaskNotExistException {
        checkTaskIndexBound(taskIndex);
        return tasks.get(taskIndex - 1); //because start from 0
    }

    /**
     * Adds a task to the tasklist and prints a message to the user.
     * @param task a Task to add
     */
    public static void printAndAdd(Task task) {
        tasks.add(task);
        String[] messages = {
                "Got it. I've added this task:",
                task.toString(),
                ("Now you have " + tasks.size() +
                        (tasks.size() == 1 ? " task in the list." : " tasks in the list."))
        };
        Ui.print(messages);
    }

    /**
     * Deletes a task with taskIndex and prints a message to the user.
     * @param taskIndex an int
     * @throws A9527TaskNotExistException if the task with taskIndex cannot be found
     */
    public static void printAndDelete(int taskIndex) throws A9527TaskNotExistException{
        Task deletedTask = getTaskOfIndex(taskIndex);
        tasks.remove(taskIndex - 1);
        String[] messages = {
                "Ok, I've deleted this task:",
                deletedTask.toString(),
                ("Now you have " + tasks.size() +
                        (tasks.size() == 1 ? " task in the list." : " tasks in the list."))
        };
        Ui.print(messages);
    }

    /**
     * Add a task to tasklist
     * @param task
     */
    public static void AddToTaskList(Task task) {
        tasks.add(task);
    }

    /**
     *
     * @return Returns an array of string where each element is the string representation of each task.
     */
    public static String[] toStrings() {
        String[] strings = {"\tNo task"};
        if(!tasks.isEmpty()) {
            strings = new String[tasks.size()]; //reassign strings to a new array

            int taskIndex = 1;
            for(Task task : tasks) {
                strings[taskIndex - 1] = (taskIndex + "." + task.toString());
                taskIndex ++;
            }
        }
        return strings;
    }

    /**
     * Prints the string representation of the tasklist
     */
    public static void printTaskList() {
        Ui.print(TaskList.toStrings());
    }

    /**
     * Prints the string representation of the tasklist
     * @param tasklist an ArrayList of Task
     */
    public static void printTaskList(ArrayList<Task> tasklist) {
        ArrayList<String> strings = new ArrayList<>();
        if(tasklist.isEmpty()) {
            strings.add("No such task is found");
        } else {
            strings.add("I found these:");
            for (Task task : tasklist) {
                strings.add(task.toString());
            }
        }
        Ui.print(strings);
    }


    /**
     * Marks the task with taskIndex as not done and prints a message.
     * @param taskIndex an int
     * @throws A9527TaskNotExistException if the task with taskIndex is not found.
     */
    public static void printAndUnmark(int taskIndex) throws A9527TaskNotExistException{
        Task taskToUnmark = getTaskOfIndex(taskIndex);
        taskToUnmark.markNotDone();

        //Ui
        ArrayList<String> message = new ArrayList<>();
        message.add("Ok, task " + taskIndex + " unmarked");
        message.add(taskToUnmark.toString());
        Ui.print(message);
    }

    /**
     * Marks the task with taskIndex as done and prints a message.
     * @param taskIndex an int
     * @throws A9527TaskNotExistException if the task with taskIndex is not found.
     */
    public static void printAndMark(int taskIndex) throws A9527TaskNotExistException{
        Task taskToMark = getTaskOfIndex(taskIndex);
        taskToMark.markDone();

        //Ui
        ArrayList<String> message = new ArrayList<>();
        message.add("Ok, task " + taskIndex + " marked");
        message.add(taskToMark.toString());
        Ui.print(message);
    }
}
