package my.projects.toDoListApp;
/**
 * utility class for writing tasks in a file, reads tasks from a file, prints and deletes them
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskFileHandler {
    private static final String FILE_NAME = "tasks.txt";

    public static void writeTask(String task) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(task);
        } catch (IOException e) {
            System.out.println("Error writing task.");
        }
    }

    public static List<String> readTasks() {
        List<String> tasks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                tasks.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading tasks.");
        }
        return tasks;
    }

    public static void overwriteTasks(List<String> tasks) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (String task : tasks) {
                pw.println(task);
            }
        } catch (IOException e) {
            System.out.println("Error overwriting file.");
        }
    }
    public static void printAllTasks() {
        List<String> tasks = readTasks();
        if (tasks.isEmpty()) {
            System.out.println("Your to-do list is empty.");
        } else {
            System.out.println("Your current tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}


