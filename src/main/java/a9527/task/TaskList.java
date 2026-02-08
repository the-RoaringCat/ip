package a9527.task;
import a9527.ui.Ui;
import a9527.exception.A9527Exception;



public class TaskList {
    protected static int taskCount = 0;
    protected static Task[] tasks = new Task[100];

    public static int getTaskCount() {
        return taskCount;
    }

    public static Task[] getTasks() {
        return tasks;
    }

    public static void printAndAddToTaskList(Task task) {
        tasks[taskCount] = task;
        taskCount ++;
        String[] strings = {
                "Got it. I've added this task:",
                task.toString(),
                ("Now you have " + TaskList.getTaskCount() +
                        (TaskList.getTaskCount() == 1 ? " task in the list." : " tasks in the list."))
        };
        Ui.print(strings);
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


    //TODO: for mark and unmark, deal with taskIndex out of bound
    public static void printAddUnmark(int taskIndex) throws A9527Exception{
        if(taskIndex > taskCount || taskIndex < 1) {
            throw new A9527Exception("haiyah, task with index " + taskIndex + " does not exist");
        }
        String[] strings = new String[2];

        strings[0] = (tasks[taskIndex - 1].isDone()) ? "\tHaiyah, so you didn't do?" : "\tI know you didn't finish";
        tasks[taskIndex - 1].markNotDone();
        strings[1] = ("\t"+ tasks[taskIndex - 1].toString());

        Ui.print(strings);
    }

    public static void printAndMark(int taskIndex) throws A9527Exception{
        if(taskIndex > taskCount || taskIndex < 1) {
            throw new A9527Exception("haiyah, task with index " + taskIndex + " does not exist");
        }
        String[] strings = new String[2];

        strings[0] = (tasks[taskIndex - 1].isDone()) ? "\tDone already, you just redo ah?" : "\tGood good, finally done! Need wait so long :)";
        tasks[taskIndex - 1].markDone();
        strings[1] = ("\t"+ tasks[taskIndex - 1].toString());

        Ui.print(strings);
    }
}
