package a9527.task;

import a9527.exception.A9527Exception;
import a9527.storage.Storage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class TaskListIO {
    //field checks
    private static void checkTaskType(String taskTypeField) throws A9527Exception {
        if(taskTypeField.isBlank()) {
            throw new A9527Exception("haiyah, Field(s) cannot be blank");
        }
        if(!taskTypeField.equals("T") && !taskTypeField.equals("E") && !taskTypeField.equals("D")) {
            throw new A9527Exception("haiyah, invalid task type field: " + taskTypeField);
        }
    }

    private static void checkIsDone(String isDoneField) throws A9527Exception {
        if(!isDoneField.equals("true") && !isDoneField.equals("false")) {
            throw new A9527Exception("haiyah, invalid isDone field: " + isDoneField);
        }
    }

    private static void checkFieldsLength(String[] fields) throws A9527Exception {
        final int TODO_LENGTH = 3;
        final int DEADLINE_LENGTH = 4;
        final int EVENT_LENGTH = 5;

        int len = fields.length;
        if(len < 3) {
            throw new A9527Exception("haiyah, all task type must have at least 3 fields");
        }
        switch (fields[0]) {
            case "T" -> {
                if(len != TODO_LENGTH) {
                    throw new A9527Exception("haiyah, todo must have 3 fields");
                }
            }
            case "D" -> {
                if(len != DEADLINE_LENGTH) {
                    throw new A9527Exception("haiyah, deadline must have 4 fields");
                }
            }
            case "E" -> {
                if(len != EVENT_LENGTH) {
                    throw new A9527Exception("haiyah, event must have 5 fields");
                }
            }
        }
    }

    private static void checkFieldsEmptiness(String[] fields) throws A9527Exception {
        A9527Exception blank = new A9527Exception("haiyah, Field(s) cannot be blank");
        switch (fields[0]) {
        case "E":
            if (fields[4].isBlank()) {
                    throw blank;
            }
            //Fallthrough
        case "D":
            if (fields[3].isBlank()) {
                throw blank;
            }
            //Fallthrough
        case "T":
            if (fields[2].isBlank()) {
                throw blank;
            }
        }
    }

    private static void checkTaskDataIntegrity(String taskData) throws A9527Exception {
        String[] fields = taskData.split("\\s*\\|\\s*");

        checkTaskType(fields[0]);
        checkFieldsLength(fields);
        checkIsDone(fields[1]);
        checkFieldsEmptiness(fields);
    }

    private static Task formatDataToTask(String taskInText) {
        String[] fields = taskInText.split("\\s*\\|\\s*");
        Task newTask = null;
        boolean isDone = Boolean.parseBoolean(fields[1]);
        switch (fields[0]) {
            case "T" -> newTask = new Todo(fields[2], isDone);
            case "D" -> newTask = new Deadline(fields[2], isDone, fields[3]);
            case "E" -> newTask = new Event(fields[2], isDone, fields[3], fields[4]);
        }
        return newTask;
    }

    public static void loadTasksFromFile(String path) throws FileNotFoundException, A9527Exception {
        //format: taskType | isDone | description | additional 1 | additional 2
        ArrayList<String> texts = Storage.readFromFile(path);

        for(String text : texts) {
            checkTaskDataIntegrity(text);
            Task newTask = formatDataToTask(text);
            TaskList.AddToTaskList(newTask);
        }
    }

    public static void storeTasksToFile(String path) throws IOException {
        Storage.clearFile(path);
        ArrayList<Task> tasks= TaskList.getTasks();
        for(Task task : tasks) {
            Storage.appendToFile(path, task.toStorageFormat(), true);
        }
    }
}
