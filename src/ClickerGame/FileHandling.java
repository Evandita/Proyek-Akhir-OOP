package ClickerGame;

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandling {
    // write to file
    public static void writeToFile(String filepath, Object obj) {
        createFile(filepath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            writer.write(obj.toString());
            System.out.println("success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //read from file
    public static List<String> readFromFile(String filepath) {
        List<String> list = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            // Read each line from the file
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    // create file
    public static void createFile(String filepath) {
        File file = new File(filepath);
        try {
            // Create a new file
            if (file.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}