package my.projects.toDoListApp;

import java.util.List;
import java.util.Scanner;

/**
 * A simple ToDoListApp
 * Adds tasks
 * Deletes task
 * Prints tasks
 */
public class ToDoListApp {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while(true){
            printMenu();
            int userChoice = scanner.nextInt();
            scanner.nextLine();//!!!!!
            switch (userChoice) {
                case 1->{
                    addTask(scanner);
                    break;
                }
                case 2 -> {
                    deleteTask(scanner);
                    break;
                }
                case 3 -> {
                    TaskFileHandler.printAllTasks();
                    break;
                }
                case 4 -> {
                    System.out.println("Thanks for using our app!!! Have a nice day!");
                    return;
                }
                default -> {
                    System.out.println("Invalid Option");
                    break;
                }
            }
        }
    }

    public static void printMenu() {
        System.out.println("===========================");
        System.out.println("Welcome to my to-do list!!!");
        System.out.println("===========================");
        System.out.println("1. Add a task");
        System.out.println("2. Delete a task");
        System.out.println("3. See your tasks");
        System.out.println("4. Exit");
        System.out.println("Choose one of the above: ");
    }

    public static void addTask(Scanner scanner) {
        System.out.println("Add your task: ");
        String task = scanner.nextLine();
        TaskFileHandler.writeTask(task);//call the utility class
        System.out.println("To-Do: " + TaskFileHandler.readTasks());
    }
    public static void deleteTask(Scanner scanner) {
        List<String> tasks = TaskFileHandler.readTasks();

        System.out.println("Your current tasks: ");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        System.out.println("Type the task you want to delete: ");
        String taskToDelete = scanner.nextLine();
        if (tasks.remove(taskToDelete)) {
            TaskFileHandler.overwriteTasks(tasks);
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task not found!");
        }
    }
}
