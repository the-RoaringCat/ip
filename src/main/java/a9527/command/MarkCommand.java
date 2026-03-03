package a9527.command;
import a9527.exception.A9527CommandParamException;
import a9527.exception.A9527TaskNotExistException;
import a9527.task.*;
import a9527.exception.A9527Exception;
public class MarkCommand extends Command{
    private String taskIndex;

    public MarkCommand(String taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * Executes mark command
     * <p>
     *     Mark the task with taskIndex as done.
     * </p>
     * @throws A9527CommandParamException if the taskIndex is blank or cannot be parsed to an integer.
     * @throws A9527TaskNotExistException if the task with taskIndex cannot be found.
     */
    @Override
    public void execute() throws A9527CommandParamException, A9527TaskNotExistException {
        checkNotBlank("mark", taskIndex);
        int taskIndexInt = checkInt("mark", taskIndex);
        TaskList.printAndMark(taskIndexInt);
    }
}
