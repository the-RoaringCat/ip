package a9527.command;
import a9527.exception.A9527CommandParamException;
import a9527.exception.A9527Exception;
public abstract class Command {
    public abstract void execute() throws A9527Exception;

    protected static void checkNotBlank(String commandName, String... strings) throws A9527CommandParamException {
        for(String string : strings) {
            if(string.isBlank()) {
                throw new A9527CommandParamException("haiyah, " + commandName + " expects parameter(s)");
            }
        }

    }

    protected static void checkBlank(String commandName, String string) throws A9527CommandParamException {
        if(!string.isBlank()) {
            throw new A9527CommandParamException("haiyah, " + commandName + " expects no parameter");
        }
    }

    protected static int checkInt(String commandName, String string) throws A9527CommandParamException {
        int integer;
        try {
            integer = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new A9527CommandParamException("haiyah, " + commandName + " expects an integer param");
        }
        return integer;
    }
}
