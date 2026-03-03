package a9527.command;
import a9527.exception.A9527CommandParamException;
import a9527.task.*;

public class DeadlineCommand extends Command{
    private String description;
    private String deadline;

    /**
     * Sets the instance attribute field.
     * @param description statement that describes the task
     * @param deadline deadline of the task
     */
    public DeadlineCommand(String description, String deadline) {
        this.deadline = deadline;
        this.description = description;
    }

    /**
     * Executes deadline command.
     * <P>
     * Add a deadline task to the tasklist
     * @throws A9527CommandParamException if at least one of the instance's attributes are empty
     */
    @Override
    public void execute() throws A9527CommandParamException {
        checkNotBlank("deadline", description, deadline);
        TaskList.printAndAdd(new Deadline(description, deadline));
    }
}
