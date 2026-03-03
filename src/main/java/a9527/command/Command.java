package a9527.command;
import a9527.exception.A9527CommandParamException;
import a9527.exception.A9527Exception;
public abstract class Command {
    /**
     * Executes the command.
     * @throws A9527Exception for any parameter related errors
     */
    public abstract void execute() throws A9527Exception;

    /**
     * Checks that each element in the strings is not blank.
     * @param commandName
     * @param strings
     * @throws A9527CommandParamException if one blank element is found.
     */
    protected static void checkNotBlank(String commandName, String... strings) throws A9527CommandParamException {
        for(String string : strings) {
            if(string.isBlank()) {
                throw new A9527CommandParamException("haiyah, " + commandName + " expects parameter(s)");
            }
        }

    }

    /**
     * Checks that the string's content is an integer
     * @param commandName
     * @param string
     * @return An integer that the string represent
     * @throws A9527CommandParamException if the string cannot be parsed to an integer.
     * @see Integer
     */
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
