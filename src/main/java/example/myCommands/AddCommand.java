package example.myCommands;

import example.managers.Argument;
import example.managers.MyLinkedList;
import example.managers.Product;
import example.ripManager.MarineParser;
import example.ripManager.MarineReader;


/**
 * The AddCommand class is a concrete implementation of the Command class that adds an element to the MyLinkedList object.
 * Uses a MarineParser to parse the arguments for the add command.
 */
public class AddCommand extends Command {

    /**
     * Constructor for the AddCommand class.
     *
     * @param list The MyLinkedList object on which the command will be executed.
     */
    public AddCommand(MyLinkedList list) {
        super(list);
    }

    /**
     * Executes the add command with the given argument and returns the result as a Product object.
     *
     * @param argument The argument for the add command.
     * @return The result of executing the add command as a Product object.
     */
    @Override
    public Product execute(Argument argument) {
        list.add(MarineParser.parseSpaceMarine(MarineReader.initSpaceMarine(argument.getScanner(), argument.isInScript())));
        return new Product("ok", true);
    }

    /**
     * Returns the name of the add command.
     *
     * @return The name of the add command.
     */
    @Override
    public String getName() {
        return "add";
    }
}