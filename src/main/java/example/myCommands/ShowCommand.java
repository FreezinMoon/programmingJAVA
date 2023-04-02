package example.myCommands;

import example.managers.Argument;
import example.managers.MyLinkedList;
import example.managers.Product;

/**
 * The ShowCommand class is a concrete implementation of the Command class that prints out all the elements in the collection.
 */
public class ShowCommand extends Command {

    private static final String OK_MESSAGE = "ok";

    /**
     * Constructor for the ShowCommand class.
     *
     * @param list The MyLinkedList object on which the command will be executed.
     */
    public ShowCommand(MyLinkedList list) {
        super(list);
    }

    /**
     * Returns the name of the show command.
     *
     * @return The name of the show command.
     */
    @Override
    public String getName() {
        return "show";
    }

    /**
     * Executes the show command and prints out all the elements in the collection.
     *
     * @param argument The argument for the show command.
     * @return The result of executing the show command as a Product object.
     */
    @Override
    public Product execute(Argument argument) {
        list.forEach(System.out::println);
        return new Product(OK_MESSAGE, true);
    }
}