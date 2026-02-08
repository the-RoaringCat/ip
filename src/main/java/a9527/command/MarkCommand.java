package a9527.command;
import a9527.task.*;
import a9527.exception.A9527Exception;
public class MarkCommand extends Command{
    String taskIndex;

    public MarkCommand(String taskIndex) {
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
        TaskList.printAndMark(finalTaskIndex);
    }
}
