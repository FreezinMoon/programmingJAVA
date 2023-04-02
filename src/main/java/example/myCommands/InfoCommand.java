package example.myCommands;

import example.managers.Argument;
import example.managers.MyLinkedList;
import example.managers.Product;

/**
 * The InfoCommand class is a concrete implementation of the Command class that prints information about the collection.
 */
public class InfoCommand extends Command {

    private static final String OK_MESSAGE = "ok";

    /**
     * Constructor for the InfoCommand class.
     *
     * @param list The MyLinkedList object on which the command will be executed.
     */
    public InfoCommand(MyLinkedList list) {
        super(list);
    }

    /**
     * Returns the name of the info command.
     *
     * @return The name of the info command.
     */
    @Override
    public String getName() {
        return "info";
    }

    /**
     * Executes the info command and prints information about the collection.
     *
     * @param argument The argument for the info command.
     * @return The result of executing the info command as a Product object.
     */
    @Override
    public Product execute(Argument argument) {
        System.out.println("Collection info:");
        System.out.println(list.getType());
        System.out.println(list.getCreationDate());
        System.out.println("Size: " + list.size());
        return new Product(OK_MESSAGE, true);
    }
}