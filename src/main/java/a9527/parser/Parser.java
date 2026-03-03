package a9527.parser;
import a9527.command.*;
import a9527.exception.*;
import java.util.Arrays;

public class Parser {

    /**
     * Parses the user input to an executable command.
     * @param input A string that a user inputs.
     * @return a command that can be executed.
     * @throws A9527Exception if any parsing error occurs.
     */
    public static Command parse(String input) throws A9527Exception {
        if(input.contains("|")) {
            throw new A9527CommandSyntaxException("haiyah, | is illegal character");
        }
        String[] words = input.trim().split("\\s+"); //separate into an array of words from any whitespace sequence
        String commandWord = words[0];
        String argument = String.join(" ", Arrays.copyOfRange(words, 1, words.length));

        switch(commandWord) {
            case "bye" -> {
                return parseBye(argument);
            }
            case "list" -> {
                return parseList(argument);
            }
            case "todo" -> {
                return parseTodo(argument);
            }
            case "deadline" -> {
                return parseDeadline(argument);
            }
            case "event" -> {
                return parseEvent(argument);
            }
            case "mark" -> {
                return parseMark(argument);
            }
            case "unmark" -> {
                return parseUnmark(argument);
            }
            case "delete" -> {
                return parseDelete(argument);
            }
            case "find" -> {
                return parseFind(argument);
            }
            case "" -> throw new A9527CommandSyntaxException("haiyah, tell me do something");

            default -> throw new A9527CommandSyntaxException("haiyah, I don't understand");
        }
    }

    private static FindCommand parseFind(String string) {
        return new FindCommand(string);
    }

    private static DeleteCommand parseDelete(String string) {
        return new DeleteCommand(string);
    }

    private static ByeCommand parseBye(String string) throws A9527CommandParamException {
        checkBlank(string, "bye");
        return new ByeCommand();
    }

    private static ListCommand parseList(String  string) throws A9527CommandParamException {
        checkBlank(string, "list");
        return new ListCommand();
    }

    private static TodoCommand parseTodo(String string) throws A9527CommandSyntaxException {
        final String[] FLAGS = {"/name"};
        checkContainFlags(string, FLAGS, "todo");

        String[] params = extractFlagParam(string, "/name");
        return new TodoCommand(params[0]);
    }

    private static DeadlineCommand parseDeadline(String string) throws A9527CommandSyntaxException{
        final String[] FLAGS = {"/name", "/by"};
        checkContainFlags(string, FLAGS, "deadline");
        String[] params = extractFlagParam(string, FLAGS);
        return new DeadlineCommand(params[0], params[1]);
    }

    private static EventCommand parseEvent(String string) throws A9527CommandSyntaxException {
        final String[] FLAGS = {"/name", "/from", "/to"};
        checkContainFlags(string, FLAGS, "event");
        String[] params = extractFlagParam(string, FLAGS);
        return new EventCommand(params[0], params[1], params[2]);
    }

    private static MarkCommand parseMark(String string) {
        return new MarkCommand(string);
    }

    private static UnmarkCommand parseUnmark(String string) {
        return new UnmarkCommand(string);
    }

    //======helper=======

    /**
     * Checks that the string contains all the flags.
     * @param string command's argument
     * @param flags array of flags
     * @param commandName the type of the command for checking
     * @throws A9527CommandSyntaxException if there are missing flags
     */
    private static void checkContainFlags(String string, String[] flags, String commandName) throws A9527CommandSyntaxException {
        StringBuilder errorMessage = new StringBuilder();
        for(String flag : flags) {
            if(!string.contains(flag)) {
                errorMessage.append("haiyah, ")
                        .append(commandName)
                        .append(" expects the flag: ")
                        .append(flag)
                        .append(System.lineSeparator());
            }
        }
        if(!errorMessage.isEmpty()) {
            errorMessage.setLength(errorMessage.length() - 1); //remove the last lineSeparator
            throw new A9527CommandSyntaxException(errorMessage.toString());
        }
    }

    private static void checkBlank(String string, String commandName) throws A9527CommandParamException {
        if(!string.isBlank()) {
            throw new A9527CommandParamException("haiyah, " + commandName + " expects no parameter");
        }
    }

    /**
     * Extracts the parameters that correspond to their flags.
     * <p>
     *     The order of the parameters in the returned array is the same as the order of the corresponding input flags in its array.
     * </p>
     * <p>
     *     For duplicated flags, only the first occurrence would be processed, the rest would be ignored.
     * </p>
     * <p>
     *     For empty parameter, it will be an empty string in the returned array.
     * </p>
     * @param string a string of flags with their parameters
     * @param flags array of flags
     * @return a string array that contains the parameters indicated by the flags.
     */
    private static String[] extractFlagParam(String string, String... flags) {
        String[] params = new String[flags.length];
        Arrays.fill(params, ""); //for compatibility with isEmpty isBlank since array's initialised to null

        String[] arguments = string.split("(?=/)");

        for(int i = 0; i < flags.length; i++) {
            for(String argument : arguments) {
                if(argument.startsWith(flags[i])){
                    params[i] = argument.replaceFirst(flags[i], "").trim();
                    break; //this means duplicated flags will be ignored from second occurrence onward
                }
            }
        }
        return params;
    }
}
