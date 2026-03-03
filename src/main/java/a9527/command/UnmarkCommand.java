package a9527.command;

import a9527.exception.A9527CommandParamException;
import a9527.exception.A9527TaskNotExistException;
import a9527.task.TaskList;

public class UnmarkCommand extends Command{
    String taskIndex;
    public UnmarkCommand(String taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * Executes unmark command
     * <p>
     *     Unmark the task with taskIndex as not done.
     * </p>
     * @throws A9527CommandParamException if the taskIndex is blank or cannot be parsed to an integer.
     * @throws A9527TaskNotExistException if the task with taskIndex cannot be found.
     */
    @Override
    public void execute() throws A9527CommandParamException, A9527TaskNotExistException {
        checkNotBlank(taskIndex);
        int taskIndexInt = checkInt("unmark", taskIndex);
        TaskList.printAndUnmark(taskIndexInt);
    }
}
