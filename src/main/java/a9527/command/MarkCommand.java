package a9527.command;
import a9527.task.*;

public class MarkCommand extends Command{
    String taskIndex;

    public MarkCommand(String taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute() {
        //TODO: non integer error
        int finalTaskIndex = Integer.parseInt(taskIndex);
        TaskList.printAndMark(finalTaskIndex);
    }
}
