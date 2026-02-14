package a9527.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private static File tasksFile;

    public static File getFile() {
        return tasksFile;
    }

    public static void createFileObject() {
        //TODO: exception for not exist
        tasksFile = new File("data/tasks.txt");
    }

    public static void clearFile(String path) {
        try {
            new FileWriter(path, false).close();
        } catch (IOException e) {
            System.out.println("haiyah, fail to clear file");
        }
    }

    public static void writeToFile(String path, String textToWrite) throws IOException {
        FileWriter fw = new FileWriter(path);
        fw.write(textToWrite);
        fw.close();
    }

    public static void appendToFile(String path, String textToAppend, boolean isNextLine) throws IOException {
        FileWriter fw = new FileWriter(path, true);
        fw.write(textToAppend);
        if(isNextLine) {
            fw.write(System.lineSeparator());
        }
        fw.close();
    }

    public static ArrayList<String> readFromFile(String path) throws FileNotFoundException {
        File f = new File(path);
        Scanner s = new Scanner(f);
        ArrayList<String> texts = new ArrayList<>();
        while(s.hasNext()) {
            texts.add(s.nextLine());
        }
        return texts;
    }
}
