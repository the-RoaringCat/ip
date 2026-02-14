package a9527.command;

import a9527.exception.A9527Exception;
import a9527.task.*;

public class TodoCommand extends Command{

    private String description;

    public TodoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute() {

        TaskList.printAndAdd(new Todo(description));
    }
}
