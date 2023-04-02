package example.myCommands;

import example.managers.Argument;
import example.managers.IdComparator;
import example.managers.MyLinkedList;
import example.managers.Product;
import example.objects.SpaceMarine;
import example.ripManager.MarineParser;
import example.ripManager.MarineReader;

/**
 * The AddIfMinCommand class is a concrete implementation of the Command class that adds an element to the MyLinkedList object if it is less than the current minimum element.
 * Uses a MarineParser to parse the arguments for the add command and an IdComparator to compare the SpaceMarine objects.
 */
public class AddIfMinCommand extends Command {
    IdComparator idComparator = new IdComparator();

    /**
     * Constructor for the AddIfMinCommand class.
     *
     * @param list The MyLinkedList object on which the command will be executed.
     */
    public AddIfMinCommand(MyLinkedList list) {
        super(list);
    }

    /**
     * Returns the name of the add_if_min command.
     *
     * @return The name of the add_if_min command.
     */
    @Override
    public String getName() {
        return "add_if_min";
    }

    /**
     * Executes the add_if_min command with the given argument and returns the result as a Product object.
     * If the SpaceMarine object is less than the current minimum element, it is added to the MyLinkedList object and returns a success Product object.
     * Otherwise, it returns a failure Product object.
     *
     * @param argument The argument for the add_if_min command.
     * @return The result of executing the add_if_min command as a Product object.
     */
    @Override
    public Product execute(Argument argument) {
        SpaceMarine minSpaceMarine = list.getMin();
        SpaceMarine spaceMarine = MarineParser.parseSpaceMarine(MarineReader.initSpaceMarine(argument.getScanner(), argument.isInScript()));
        if (idComparator.compare(spaceMarine, minSpaceMarine) < 0) {
            list.add(spaceMarine);
            System.out.println("added");
            return new Product("added", true);
        } else {
            System.out.println("not added");
            return new Product("not added", false);
        }
    }
}