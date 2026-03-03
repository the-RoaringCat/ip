package a9527.command;

import a9527.exception.A9527CommandParamException;
import a9527.task.*;

public class TodoCommand extends Command{

    private String description;

    public TodoCommand(String description) {
        this.description = description;
    }

    @Override
    public void execute() throws A9527CommandParamException {
        checkNotBlank("todo", description);
        TaskList.printAndAdd(new Todo(description));
    }
}
