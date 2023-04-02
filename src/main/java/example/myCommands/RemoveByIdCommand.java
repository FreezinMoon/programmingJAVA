package example.myCommands;

import example.managers.Argument;
import example.managers.MyLinkedList;
import example.managers.Product;


/**
 * The RemoveByIdCommand class is a concrete implementation of the Command class that removes an element from the collection by its ID.
 */
public class RemoveByIdCommand extends Command {

    private static final String REMOVED_MESSAGE = "removed";
    private static final String NOT_REMOVED_MESSAGE = "not removed";

    /**
     * Constructor for the RemoveByIdCommand class.
     *
     * @param list The MyLinkedList object on which the command will be executed.
     */
    public RemoveByIdCommand(MyLinkedList list) {
        super(list);
    }

    /**
     * Executes the remove_by_id command and removes an element from the collection by its ID.
     *
     * @param argument The argument for the remove_by_id command.
     * @return The result of executing the remove_by_id command as a Product object.
     */
    @Override
    public Product execute(Argument argument) {
        try {
            int ID = Integer.parseInt(argument.getArg());
            boolean flag = false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId() == ID) {
                    list.remove(i);
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println("element is removed");
                return new Product(REMOVED_MESSAGE, true);
            } else {
                System.out.println("no such element in collection");
                return new Product(NOT_REMOVED_MESSAGE, false);
            }
        } catch (Exception e) {
            System.out.println("no such element in collection");
            return new Product(NOT_REMOVED_MESSAGE, false);
        }
    }

    /**
     * Returns the name of the remove_by_id command.
     *
     * @return The name of the remove_by_id command.
     */
    @Override
    public String getName() {
        return "remove_by_id";
    }
}