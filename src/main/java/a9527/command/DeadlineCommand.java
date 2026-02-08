package a9527.command;
import a9527.task.*;

public class DeadlineCommand extends Command{
    private String description;
    private String deadline;

    public DeadlineCommand(String description, String deadline) {
        this.deadline = deadline;
        this.description = description;
    }

    @Override
    public void execute() {
        TaskList.printAndAddToTaskList(new Deadline(description, deadline));
    }
}
