package a9527.task;
import a9527.ui.Ui;


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

    public static String[] toStrings() {
        String[] strings = {"\tNo task"};
        if(taskCount != 0) {
            strings = new String[taskCount]; //reassign strings to a new array

            for (int i = 0; i < taskCount; i++) {
                strings[i] = ("\t" + (i + 1) + "." + tasks[i].toString());
            }
        }
        return strings;
    }

    public static void printTaskList() {
        Ui.print(TaskList.toStrings());
    }



    public static void printAddUnmark(int taskIndex) {
        String[] strings = new String[2];

        strings[0] = (tasks[taskIndex - 1].isDone()) ? "\tHaiyah, so you didn't do?" : "\tI know you didn't finish";
        tasks[taskIndex - 1].markNotDone();
        strings[1] = ("\t"+ tasks[taskIndex - 1].toString());

        Ui.print(strings);
    }
    public static void unmark(int taskIndex) {
        tasks[taskIndex - 1].markNotDone();
    }

    public static void printAndMark(int taskIndex) {
        String[] strings = new String[2];

        strings[0] = (tasks[taskIndex - 1].isDone()) ? "\tDone already, you just redo ah?" : "\tGood good, finally done! Need wait so long :)";
        tasks[taskIndex - 1].markDone();
        strings[1] = ("\t"+ tasks[taskIndex - 1].toString());

        Ui.print(strings);
    }
    public static void mark(int taskIndex) {
        tasks[taskIndex - 1].markDone();
    }
}
