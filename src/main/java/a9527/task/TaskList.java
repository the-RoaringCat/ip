package a9527.task;
import a9527.ui.Ui;
import a9527.exception.A9527Exception;
import java.util.ArrayList;

public class TaskList {
    protected static ArrayList<Task> tasks= new ArrayList<>();


    public static ArrayList<Task> getTasks() {
        return tasks;
    }

    private static void checkTaskIndexBound(int taskIndex) throws A9527Exception {
        if(taskIndex > tasks.size() || taskIndex < 1) {
            throw new A9527Exception("haiyah, task with index " + taskIndex + " does not exist");
        }
    }

    public static Task getTaskOfIndex(int index) {
        //assume index boundary is checked in the caller
        return tasks.get(index);
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
        checkTaskIndexBound(taskIndex);
        Task deletedTask = getTaskOfIndex(taskIndex - 1);
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

    public static void printAddUnmark(int taskIndex) throws A9527Exception{
        checkTaskIndexBound(taskIndex);
        String[] strings = new String[2];

        strings[0] = (getTaskOfIndex(taskIndex - 1).isDone()) ? "\tHaiyah, so you didn't do?" : "\tI know you didn't finish";
        getTaskOfIndex(taskIndex - 1).markNotDone();
        strings[1] = ("\t"+ getTaskOfIndex(taskIndex - 1).toString());

        Ui.print(strings);
    }

    public static void printAndMark(int taskIndex) throws A9527Exception{
        checkTaskIndexBound(taskIndex);
        String[] strings = new String[2];

        strings[0] = (getTaskOfIndex(taskIndex - 1).isDone()) ? "\tDone already, you just redo ah?" : "\tGood good, finally done! Need wait so long :)";
        getTaskOfIndex(taskIndex - 1).markDone();
        strings[1] = ("\t"+ getTaskOfIndex(taskIndex - 1).toString());

        Ui.print(strings);
    }
}
