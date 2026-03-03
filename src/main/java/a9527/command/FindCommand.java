package a9527.command;

import a9527.exception.A9527CommandParamException;
import a9527.task.TaskList;

public class FindCommand extends Command{
    String description;

    public FindCommand(String description) {
        this.description = description;
    }

    /**
     * Executes find command.
     * <p>
     * Find tasks with matching description.
     * @throws A9527CommandParamException if the description is blank.
     */
    @Override
    public void execute() throws A9527CommandParamException {
        checkNotBlank("find", description);
        TaskList.findTasksAndPrint(description);
    }
}
