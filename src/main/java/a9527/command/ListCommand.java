package a9527.command;
import a9527.task.TaskList;

public class ListCommand extends Command{
    @Override
    public void execute() {
        TaskList.printTaskList();
    }
}
