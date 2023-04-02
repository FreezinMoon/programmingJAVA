package example.ripManager;

import example.managers.MyLinkedList;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SetFromFile {
    private final MyLinkedList list;

    public SetFromFile(MyLinkedList list) {
        this.list = list;
    }

    /**
     * Reads a file of CSV strings and adds SpaceMarine objects to the linked list.
     *
     * @param path The path to the file to read.
     * @throws FileNotFoundException    if the file at the specified path cannot be found.
     * @throws IllegalArgumentException if a CSV string in the file does not contain enough values to create a SpaceMarine.
     * @throws NullPointerException     if a CSV string in the file is null or contains null values.
     */
    public void setSpaceMarinesFromFile(String path) throws FileNotFoundException, IllegalArgumentException, NullPointerException {
        Scanner scanner = new Scanner(new FileInputStream(path));

        String line;
        while (scanner.hasNext()) {
            line = scanner.nextLine();

            try {
                list.add(MarineParserCSV.parseSpaceMarine(line));
            } catch (IllegalArgumentException | NullPointerException exception) {
                System.out.println(exception.getMessage());
            }
        }

        scanner.close();
    }
}
