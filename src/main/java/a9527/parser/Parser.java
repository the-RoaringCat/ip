package a9527.parser;
import a9527.command.*;
import a9527.exception.A9527Exception;
import java.util.Arrays;

public class Parser {

    public static Command parse(String input) throws A9527Exception {
        if(input.contains("|")) {
            throw new A9527Exception("haiyah, | is illegal character");
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
            case "" -> throw new A9527Exception("haiyah, tell me do something");

            default -> throw new A9527Exception("haiyah, I don't understand");
        }
    }

    private static FindCommand parseFind(String string) throws A9527Exception {
        checkNotBlank(string, "find");
        return new FindCommand(string);
    }

    private static DeleteCommand parseDelete(String string) throws A9527Exception {
        checkNotBlank(string, "delete");
        return new DeleteCommand(string);
    }

    private static ByeCommand parseBye(String string) throws A9527Exception {
        checkBlank(string, "bye");
        return new ByeCommand();
    }

    private static ListCommand parseList(String  string) throws A9527Exception {
        checkBlank(string, "list");
        return new ListCommand();
    }

    private static TodoCommand parseTodo(String string) throws A9527Exception {
        checkNotBlank(string, "todo");
        return new TodoCommand(string);
    }

    private static DeadlineCommand parseDeadline(String string) throws A9527Exception{
        final String[] FLAGS = {"/by"};
        checkFlags(string, FLAGS, "deadline");

        String description = extractBefore(string, "/by");
        String deadline = extractAfter(string, "/by");

        return new DeadlineCommand(description, deadline);
    }

    private static EventCommand parseEvent(String string) throws A9527Exception {
        final String[] FLAGS = {"/from", "/to"};
        checkFlags(string, FLAGS, "event");

        String description = extractBefore(string, "/from");
        String from = extractBetween(string, "/from", "/to");
        String to = extractAfter(string, "/to");

        return new EventCommand(description, from, to);
    }

    private static MarkCommand parseMark(String string) throws A9527Exception {
        checkNotBlank(string, "mark");
        return new MarkCommand(string);
    }

    private static UnmarkCommand parseUnmark(String string) throws A9527Exception {
        checkNotBlank(string, "unmark");
        return new UnmarkCommand(string);
    }

    //======helper=======
    private static void checkFlags(String string, String[] flags, String commandName) throws A9527Exception {
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
            throw new A9527Exception(errorMessage.toString());
        }
    }

    private static void checkNotBlank(String string, String commandName) throws A9527Exception {
        if(string.isBlank()) {
            throw new A9527Exception("haiyah, " + commandName + "expects parameter(s)");
        }
    }

    private static void checkBlank(String string, String commandName) throws A9527Exception {
        if(!string.isBlank()) {
            throw new A9527Exception("haiyah, " + commandName + "expects no parameter");
        }
    }


    private static String extractBefore(String string, String delimiter){
        int indexOfDelimiter = string.indexOf(delimiter);
        return string.substring(0, indexOfDelimiter).trim();
    }

    private static String extractBetween(String string, String startDelimiter, String endDelimiter) {
        int indexOfStartDelimiter = string.indexOf(startDelimiter);
        int indexOfEndDelimiter = string.indexOf(endDelimiter);

        return string.substring(indexOfStartDelimiter + startDelimiter.length(), indexOfEndDelimiter).trim();
    }

    private static String extractAfter(String string, String delimiter) {
        int indexOfDelimiter = string.indexOf(delimiter);
        return string.substring(indexOfDelimiter + delimiter.length()).trim();
    }
}
