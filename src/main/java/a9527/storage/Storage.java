package a9527.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {

    /**
     * Make a directory if it does not exist.
     * @param path path of the directory to be made
     * @throws IOException if an I/O error occurs
     */
    public static void makeDir(String path) throws IOException {
        Path dataPath = Paths.get(path);
        Files.createDirectories(dataPath); //do nothing when dir is alr there
    }

    /**
     * Clears a file with the path
     * @param path path of the file to clear
     */
    public static void clearFile(String path) {
        try {
            new FileWriter(path, false).close();
        } catch (IOException e) {
            System.out.println("haiyah, fail to clear file");
        }
    }

    /**
     * Appends a string to the file. Asserting isNextLine would include a line separator after appending.
     * @param path path of the file
     * @param textToAppend a string
     * @param isNextLine a boolean
     * @throws IOException if an I/O error occurs.
     */
    public static void appendToFile(String path, String textToAppend, boolean isNextLine) throws IOException {
        FileWriter fw = new FileWriter(path, true);
        fw.write(textToAppend);
        if(isNextLine) {
            fw.write(System.lineSeparator());
        }
        fw.close();
    }

    /**
     * Read the content of the file line by line.
     * @param path path of the file
     * @return An arraylist of strings of the content in the file
     * @throws FileNotFoundException if the file with path is not found
     */
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
