package a9527.task;
import a9527.ui.Ui;
import a9527.exception.A9527Exception;
import java.util.ArrayList;

public class TaskList {
    protected static ArrayList<Task> tasks= new ArrayList<>();


    public static ArrayList<Task> getTasks() {
        return tasks;
    }

    public static ArrayList<Task> findTasks(String description) {
        ArrayList<Task> neededTasks = new ArrayList<>();
        for(Task task : tasks) {
            if(task.isContain(description)) {
                neededTasks.add(task);
            }
        }
        return neededTasks;
    }

    public static void findTasksAndPrint(String description) {
        printTaskList(findTasks(description));
    }


    private static void checkTaskIndexBound(int taskIndex) throws A9527Exception {
        if(taskIndex > tasks.size() || taskIndex < 1) {
            throw new A9527Exception("haiyah, task with index " + taskIndex + " does not exist");
        }
    }

    public static Task getTaskOfIndex(int taskIndex) throws A9527Exception {
        checkTaskIndexBound(taskIndex);
        return tasks.get(taskIndex - 1); //because start from 0
    }

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

    public static void printAndDelete(int taskIndex) throws A9527Exception{
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

    public static void AddToTaskList(Task task) {
        tasks.add(task);
    }


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

    public static void printTaskList() {
        Ui.print(TaskList.toStrings());
    }

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


    public static void printAddUnmark(int taskIndex) throws A9527Exception{
        Task taskToUnmark = getTaskOfIndex(taskIndex);
        taskToUnmark.markNotDone();

        //Ui
        ArrayList<String> message = new ArrayList<>();
        message.add("Ok, task " + taskIndex + " unmarked");
        message.add(taskToUnmark.toString());
        Ui.print(message);
    }

    public static void printAndMark(int taskIndex) throws A9527Exception{
        Task taskToMark = getTaskOfIndex(taskIndex);
        taskToMark.markDone();

        //Ui
        ArrayList<String> message = new ArrayList<>();
        message.add("Ok, task " + taskIndex + " marked");
        message.add(taskToMark.toString());
        Ui.print(message);
    }
}
