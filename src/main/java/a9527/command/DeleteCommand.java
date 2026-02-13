package a9527.command;

import a9527.exception.A9527Exception;
import a9527.task.TaskList;

public class DeleteCommand extends Command{

    String taskIndex;

    public DeleteCommand(String taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute() throws A9527Exception {
        int finalTaskIndex;
        try {
            finalTaskIndex = Integer.parseInt(taskIndex);
        } catch (NumberFormatException e) {
            throw new A9527Exception("haiyah, mark expects an integer param");
        }
        TaskList.printAndDelete(finalTaskIndex);
    }
}
