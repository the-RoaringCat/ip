package a9527.command;
import a9527.exception.A9527CommandParamException;
import a9527.task.*;

public class DeadlineCommand extends Command{
    private String description;
    private String deadline;

    public DeadlineCommand(String description, String deadline) {
        this.deadline = deadline;
        this.description = description;
    }

    @Override
    public void execute() throws A9527CommandParamException {
        checkNotBlank("deadline", description, deadline);
        TaskList.printAndAdd(new Deadline(description, deadline));
    }
}
