package a9527.parser;
import a9527.command.*;

import java.util.Arrays;

public class Parser {

    public static Command parse(String input) {
        String[] words = input.trim().split(" "); //separate into an array of words
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].trim(); //each word is trimmed
        }
        String commandWord = words[0];
        String[] arguments = Arrays.copyOfRange(words, 1, words.length);
        String argument = String.join(" ", arguments);

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
            //TODO:
            case "" -> {}
            default -> {}
        }
        return null; //TODO：
    }



    private static ByeCommand parseBye(String string) {
        return new ByeCommand();
    }

    private static ListCommand parseList(String  string) {
        return new ListCommand();
    }

    private static TodoCommand parseTodo(String string) {
        return new TodoCommand(string);
    }

    private static DeadlineCommand parseDeadline(String string) {
        //TODO: try catch here
        String description = extractBefore(string, " /by ");
        String deadline = extractAfter(string, " /by ");

        return new DeadlineCommand(description, deadline);
    }

    private static EventCommand parseEvent(String string) {
        String description = extractBefore(string, " /from ");
        String from = extractBetween(string, " /from ", " /to ");
        String to = extractAfter(string, " /to ");

        return new EventCommand(description, from, to);
    }

    private static MarkCommand parseMark(String string) {
        return new MarkCommand(string);
    }

    private static UnmarkCommand parseUnmark(String string) {
        return new UnmarkCommand(string);
    }

    private static String extractBefore(String string, String delimiter) {
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
