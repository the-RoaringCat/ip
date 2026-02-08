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
        int finalTaskIndex;
        try {
            finalTaskIndex = Integer.parseInt(taskIndex);
        } catch (NumberFormatException e) {
            throw new A9527Exception("haiyah, unmark expects an integer param");
        }
        TaskList.printAddUnmark(finalTaskIndex);
    }
}
