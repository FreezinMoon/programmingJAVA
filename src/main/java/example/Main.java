package example;


import example.managers.*;
import example.ripManager.SetFromFile;

import java.io.IOException;
import java.util.Scanner;

/**
 * The main class of the program.
 */
public class Main {

    /**
     * The path to the file containing SpaceMarine objects to load on program startup.
     */
    public static String savedArg;

    /**
     * The main method of the program.
     *
     * @param args The command line arguments passed to the program.
     * @throws IOException if an error occurs while reading the input file.
     */
    public static void main(String[] args) throws IOException {

        savedArg = "/home/jasos/IdeaProjects/fifth/src/file.csv"; //args[0] // The path to the input file containing SpaceMarine objects

        // Create a MyLinkedList object using Dagger
        MyLinkedListComponent myLinkedListComponent = DaggerMyLinkedListComponent.create();
        MyLinkedList linkedList = myLinkedListComponent.getMyLinkedList();

        // Load SpaceMarine objects from the input file and add them to the linked list
        SetFromFile setFromFile = new SetFromFile(linkedList);
        setFromFile.setSpaceMarinesFromFile(savedArg);

        // Create an Invoker object to execute user commands
        Invoker invoker = new Invoker(linkedList);

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        String arg;
        String[] line;

        // Run the main loop of the program
        while (true) {
            System.out.print("> ");
            line = scanner.nextLine().split(" ");

            // Determine the command and argument to execute
            arg = line.length > 1 ? line[1] : "";
            invoker.executeCommand(line[0], new Argument(arg, scanner, invoker, false));
        }
    }
}
