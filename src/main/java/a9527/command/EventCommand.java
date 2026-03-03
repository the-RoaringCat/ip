package a9527.command;
import a9527.exception.A9527CommandParamException;
import a9527.exception.A9527Exception;
import a9527.task.*;

public class EventCommand extends Command{
    private String description;
    private String from;
    private String to;


    public EventCommand(String description, String from, String to) {
        this.description = description;
        this.from = from;
        this.to = to;
    }

    /**
     * Executes the event command
     * <P>
     * Add an event task to the tasklist.
     * @throws A9527CommandParamException if at least one of the event attributes are blank.
     */
    @Override
    public void execute() throws A9527CommandParamException {
        checkNotBlank("event", description, from, to);
        TaskList.printAndAdd(new Event(description, from, to));
    }
}
