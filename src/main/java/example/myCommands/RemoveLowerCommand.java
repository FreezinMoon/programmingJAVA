package example.myCommands;

import example.managers.Argument;
import example.managers.IdComparator;
import example.managers.MyLinkedList;
import example.managers.Product;
import example.objects.SpaceMarine;
import example.ripManager.MarineParser;
import example.ripManager.MarineReader;

/**
 * The RemoveLowerCommand class is a concrete implementation of the Command class that removes all elements less than a given element from the collection.
 */
public class RemoveLowerCommand extends Command {
    private static final String OK_MESSAGE = "ok";
    IdComparator idComparator = new IdComparator();

    /**
     * Constructor for the RemoveLowerCommand class.
     *
     * @param list The MyLinkedList object on which the command will be executed.
     */
    public RemoveLowerCommand(MyLinkedList list) {
        super(list);
    }

    /**
     * Returns the name of the remove_lower command.
     *
     * @return The name of the remove_lower command.
     */
    @Override
    public String getName() {
        return "remove_lower";
    }

    /**
     * Executes the remove_lower command and removes all elements less than a given element from the collection.
     *
     * @param argument The argument for the remove_lower command.
     * @return The result of executing the remove_lower command as a Product object.
     */
    @Override
    public Product execute(Argument argument) {
        SpaceMarine spaceMarine = MarineParser.parseSpaceMarine(MarineReader.initSpaceMarine(argument.getScanner(), argument.isInScript()));

        list.removeIf(sm -> idComparator.compare(spaceMarine, sm) > 0);
        System.out.println("Element which are less than given element have been removed");
        return new Product(OK_MESSAGE, true);
    }
}