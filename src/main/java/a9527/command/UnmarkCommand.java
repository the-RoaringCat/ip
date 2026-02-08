package a9527.command;

import a9527.task.TaskList;

public class UnmarkCommand extends Command{
    String taskIndex;
    public UnmarkCommand(String taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute() {
        int finalTaskIndex = Integer.parseInt(taskIndex);
        TaskList.printAddUnmark(finalTaskIndex);
    }
}
