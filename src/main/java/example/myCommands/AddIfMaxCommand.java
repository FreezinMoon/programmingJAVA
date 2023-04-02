package example.myCommands;

import example.managers.Argument;
import example.managers.IdComparator;
import example.managers.MyLinkedList;
import example.managers.Product;
import example.objects.SpaceMarine;
import example.ripManager.MarineParser;
import example.ripManager.MarineReader;

/**
 * The AddIfMaxCommand class is a concrete implementation of the Command class that adds an element to the MyLinkedList object if it is greater than the current maximum element.
 * Uses a MarineParser to parse the arguments for the add command and an IdComparator to compare the SpaceMarine objects.
 */
public class AddIfMaxCommand extends Command {
    IdComparator idComparator = new IdComparator();

    /**
     * Constructor for the AddIfMaxCommand class.
     *
     * @param list The MyLinkedList object on which the command will be executed.
     */
    public AddIfMaxCommand(MyLinkedList list) {
        super(list);
    }

    /**
     * Returns the name of the add_if_max command.
     *
     * @return The name of the add_if_max command.
     */
    @Override
    public String getName() {
        return "add_if_max";
    }

    /**
     * Executes the add_if_max command with the given argument and returns the result as a Product object.
     * If the SpaceMarine object is greater than the current maximum element, it is added to the MyLinkedList object and returns a success Product object.
     * Otherwise, it returns a failure Product object.
     *
     * @param argument The argument for the add_if_max command.
     * @return The result of executing the add_if_max command as a Product object.
     */
    @Override
    public Product execute(Argument argument) {
        SpaceMarine maxSpaceMarine = list.getMax();
        SpaceMarine spaceMarine = MarineParser.parseSpaceMarine(MarineReader.initSpaceMarine(argument.getScanner(), argument.isInScript()));
        if (idComparator.compare(spaceMarine, maxSpaceMarine) > 0) {
            list.add(spaceMarine);
            System.out.println("added");
            return new Product("added", true);
        } else {
            System.out.println("not added");
            return new Product("not added", false);
        }
    }
}