package a9527.command;

import a9527.task.*;

public class TodoCommand extends Command{

    private String description;

    public TodoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute(){
        TaskList.printAndAddToTaskList(new Todo(description));
    }
}
