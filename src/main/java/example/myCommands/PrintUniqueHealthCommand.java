package example.myCommands;

import example.managers.Argument;
import example.managers.MyLinkedList;
import example.managers.Product;
import example.objects.SpaceMarine;

import java.util.HashSet;

/**
 * The PrintUniqueHealthCommand class is a concrete implementation of the Command class that prints the unique values of the health field of each element in the collection.
 */
public class PrintUniqueHealthCommand extends Command {

    private static final String OK_MESSAGE = "ok";

    /**
     * Constructor for the PrintUniqueHealthCommand class.
     *
     * @param list The MyLinkedList object on which the command will be executed.
     */
    public PrintUniqueHealthCommand(MyLinkedList list) {
        super(list);
    }

    /**
     * Returns the name of the print_unique_health command.
     *
     * @return The name of the print_unique_health command.
     */
    @Override
    public String getName() {
        return "print_unique_health";
    }

    /**
     * Executes the print_unique_health command and prints the unique values of the health field of each element in the collection.
     *
     * @param argument The argument for the print_unique_health command.
     * @return The result of executing the print_unique_health command as a Product object.
     */
    @Override
    public Product execute(Argument argument) {
        HashSet<Float> cur = new HashSet<>();
        for (SpaceMarine elem : list) {
            cur.add(elem.getHealth());
        }
        cur.forEach(System.out::println);
        return new Product(OK_MESSAGE, true);
    }
}