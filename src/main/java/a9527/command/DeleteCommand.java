package a9527.command;

import a9527.exception.A9527Exception;
import a9527.task.TaskList;

public class DeleteCommand extends Command{

    private String taskIndex;

    public DeleteCommand(String taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute() throws A9527Exception {
        checkNotBlank("delete", taskIndex);
        int taskIndexInt = checkInt("delete", taskIndex);
        TaskList.printAndDelete(taskIndexInt);
    }
}
