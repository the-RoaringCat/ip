package a9527.command;

import a9527.exception.A9527CommandParamException;
import a9527.exception.A9527Exception;
import a9527.exception.A9527TaskNotExistException;
import a9527.task.TaskList;

public class DeleteCommand extends Command{

    private String taskIndex;

    /**
     * Sets the instance attribute field
     * @param taskIndex an index of the task that the instance should delete from the tasklist.
     */
    public DeleteCommand(String taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * Executes the delete command.
     * <p>
     * Delete a task with taskIndex from the tasklist.
     * </p>
     * @throws A9527CommandParamException if the taskIndex is blank or cannot be parsed to an integer.
     * @throws A9527TaskNotExistException if the task with taskIndex cannot be found.
     */
    @Override
    public void execute() throws A9527CommandParamException, A9527TaskNotExistException {
        checkNotBlank("delete", taskIndex);
        int taskIndexInt = checkInt("delete", taskIndex);
        TaskList.printAndDelete(taskIndexInt);
    }
}
