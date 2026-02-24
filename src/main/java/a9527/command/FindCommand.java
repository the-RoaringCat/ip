package a9527.command;

import a9527.task.TaskList;

public class FindCommand extends Command{
    String description;

    public FindCommand(String description) {
        this.description = description;
    }
    @Override
    public void execute() {
        TaskList.findTasksAndPrint(description);
    }
}
