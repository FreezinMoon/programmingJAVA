package example.myCommands;


import example.managers.Argument;
import example.managers.MyLinkedList;
import example.managers.Product;

/**
 * The Command class is an abstract class that defines a command that can be executed on a MyLinkedList object.
 * Contains a reference to the MyLinkedList object on which the command will be executed.
 */
public abstract class Command {
    protected final MyLinkedList list;

    /**
     * Constructor for the Command class.
     *
     * @param list The MyLinkedList object on which the command will be executed.
     */
    protected Command(MyLinkedList list) {
        this.list = list;
    }

    /**
     * Executes the command with the given argument and returns the result as a Product object.
     *
     * @param argument The argument for the command.
     * @return The result of executing the command as a Product object.
     */
    public abstract Product execute(Argument argument);

    /**
     * Returns the name of the command.
     *
     * @return The name of the command.
     */
    public abstract String getName();
}
