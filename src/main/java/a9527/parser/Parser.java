package a9527.parser;
import a9527.command.*;
import a9527.exception.A9527Exception;
import java.util.Arrays;

public class Parser {

    public static Command parse(String input) throws A9527Exception {
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
            case "" -> throw new A9527Exception("haiyah, tell me do something");

            default -> throw new A9527Exception("haiyah, I don't understand");
        }
    }

    private static ByeCommand parseBye(String string) throws A9527Exception {
        if(!string.isBlank()) {
            throw new A9527Exception("haiyah, bye expects no param");
        }
        return new ByeCommand();
    }

    private static ListCommand parseList(String  string) throws A9527Exception {
        if(!string.isBlank()) {
            throw new A9527Exception("haiyah, list expects no param");
        }
        return new ListCommand();
    }

    private static TodoCommand parseTodo(String string) throws A9527Exception {
        if(string.isBlank()) {
            throw new A9527Exception("haiyah, todo expects one task description");
        }
        return new TodoCommand(string);
    }

    private static DeadlineCommand parseDeadline(String string) throws A9527Exception{
        if(!string.contains("/by")) {
            throw new A9527Exception("haiyah, deadline expects /by to indicate deadline");
        }
        String description = extractBefore(string, "/by");
        String deadline = extractAfter(string, "/by");

        return new DeadlineCommand(description, deadline);
    }

    private static EventCommand parseEvent(String string) throws A9527Exception {
        if(!string.contains("/from") || !string.contains("/to")) {
            throw new A9527Exception("haiyah, event expects /from to indicate start time and /to to indicate end time");
        }
        String description = extractBefore(string, "/from");
        String from = extractBetween(string, "/from", "/to");
        String to = extractAfter(string, "/to");

        return new EventCommand(description, from, to);
    }

    private static MarkCommand parseMark(String string) throws A9527Exception {
        if(string.isBlank()) {
            throw new A9527Exception("haiyah, mark expects one task index");
        }
        return new MarkCommand(string);
    }

    private static UnmarkCommand parseUnmark(String string) throws A9527Exception {
        if(string.isBlank()) {
            throw new A9527Exception("haiyah, unmark expects one task index");
        }
        return new UnmarkCommand(string);
    }

    private static String extractBefore(String string, String delimiter){
        int indexOfDelimiter = string.indexOf(delimiter);
        return string.substring(0, indexOfDelimiter);
    }

    private static String extractBetween(String string, String startDelimiter, String endDelimiter) {
        int indexOfStartDelimiter = string.indexOf(startDelimiter);
        int indexOfEndDelimiter = string.indexOf(endDelimiter);

        return string.substring(indexOfStartDelimiter + startDelimiter.length(), indexOfEndDelimiter);
    }

    private static String extractAfter(String string, String delimiter) {
        int indexOfDelimiter = string.indexOf(delimiter);
        return string.substring(indexOfDelimiter + delimiter.length());
    }
}
