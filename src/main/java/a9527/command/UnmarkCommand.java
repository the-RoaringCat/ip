package a9527.command;

import a9527.task.TaskList;
import a9527.exception.A9527Exception;
public class UnmarkCommand extends Command{
    String taskIndex;
    public UnmarkCommand(String taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute() throws A9527Exception {
        checkNotBlank(taskIndex);
        int taskIndexInt = checkInt("unmark", taskIndex);
        TaskList.printAddUnmark(taskIndexInt);
    }
}
