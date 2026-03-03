package a9527.command;
import a9527.task.*;
import a9527.exception.A9527Exception;
public class MarkCommand extends Command{
    private String taskIndex;

    public MarkCommand(String taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute() throws A9527Exception {
        checkNotBlank("mark", taskIndex);
        int taskIndexInt = checkInt("mark", taskIndex);
        TaskList.printAndMark(taskIndexInt);
    }
}
