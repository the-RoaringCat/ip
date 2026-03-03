package a9527.command;
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

    @Override
    public void execute() throws A9527Exception {
        checkNotBlank("event", description, from, to);
        TaskList.printAndAdd(new Event(description, from, to));
    }
}
