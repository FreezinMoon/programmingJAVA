package example.myCommands;

import example.managers.Argument;
import example.managers.MyLinkedList;
import example.managers.Product;

/**
 * The ExitCommand class is a concrete implementation of the Command class that terminates the JVM.
 */
public class ExitCommand extends Command {

    private static final String EXIT_MESSAGE = "ok";

    /**
     * Constructor for the ExitCommand class.
     *
     * @param list The MyLinkedList object on which the command will be executed.
     */
    public ExitCommand(MyLinkedList list) {
        super(list);
    }

    /**
     * Returns the name of the exit command.
     *
     * @return The name of the exit command.
     */
    @Override
    public String getName() {
        return "exit";
    }

    /**
     * Executes the exit command and terminates the JVM.
     *
     * @param argument The argument for the exit command.
     * @return The result of executing the exit command as a Product object.
     */
    @Override
    public Product execute(Argument argument) {
        argument.closeScanner();
        System.out.println("Terminating JVM...");
        System.exit(0);
        return new Product(EXIT_MESSAGE, true);
    }
}