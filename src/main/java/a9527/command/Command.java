package a9527.command;
import a9527.exception.A9527Exception;
public abstract class Command {
    public abstract void execute() throws A9527Exception;
}
