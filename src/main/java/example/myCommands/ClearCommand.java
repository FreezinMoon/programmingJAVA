package example.myCommands;

import example.managers.Argument;
import example.managers.MyLinkedList;
import example.managers.Product;

/**
 * The ClearCommand class is a concrete implementation of the Command class that clears the MyLinkedList object.
 */
public class ClearCommand extends Command {

    /**
     * Constructor for the ClearCommand class.
     *
     * @param list The MyLinkedList object on which the command will be executed.
     */
    public ClearCommand(MyLinkedList list) {
        super(list);
    }

    /**
     * Returns the name of the clear command.
     *
     * @return The name of the clear command.
     */
    @Override
    public String getName() {
        return "clear";
    }

    /**
     * Executes the clear command and returns a success Product object.
     *
     * @param argument The argument for the clear command.
     * @return The result of executing the clear command as a Product object.
     */
    @Override
    public Product execute(Argument argument) {
        list.clear();
        return new Product("Cleared", true);
    }
}