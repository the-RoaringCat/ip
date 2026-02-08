package a9527.command;
import a9527.exception.A9527Exception;
import a9527.task.*;

public class DeadlineCommand extends Command{
    private String description;
    private String deadline;

    public DeadlineCommand(String description, String deadline) {
        this.deadline = deadline;
        this.description = description;
    }

    @Override
    public void execute() throws A9527Exception {
        if(description.isBlank() || deadline.isBlank()) {
            throw new A9527Exception("haiyah, deadline expects non empty param(s)");
        }
        TaskList.printAndAddToTaskList(new Deadline(description, deadline));
    }
}
