package a9527.command;
import a9527.task.TaskList;

public class ListCommand extends Command{
    /**
     * Executes list command.
     * <p>
     *     List the tasks in the tasklist.
     * </p>
     */
    @Override
    public void execute() {
        TaskList.printTaskList();
    }
}
