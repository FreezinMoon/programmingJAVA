package example.myCommands;

import example.managers.Argument;
import example.managers.MyLinkedList;
import example.managers.Product;
import example.ripManager.MarineParser;
import example.ripManager.MarineReader;

/**
 * The UpdateByIdCommand class is a concrete implementation of the Command class that updates an element in the collection by its ID.
 */
public class UpdateByIdCommand extends Command {

    private static final String UPDATED_MESSAGE = "updated";
    private static final String NO_SUCH_ID_MESSAGE = "no such id";
    private static final String INCORRECT_ID_MESSAGE = "incorrect id";

    /**
     * Constructor for the UpdateByIdCommand class.
     *
     * @param list The MyLinkedList object on which the command will be executed.
     */
    public UpdateByIdCommand(MyLinkedList list) {
        super(list);
    }

    /**
     * Returns the name of the update_by_id command.
     *
     * @return The name of the update_by_id command.
     */
    @Override
    public String getName() {
        return "update_by_id";
    }

    /**
     * Executes the update_by_id command and updates an element in the collection by its ID.
     *
     * @param argument The argument for the update_by_id command.
     * @return The result of executing the update_by_id command as a Product object.
     */
    @Override
    public Product execute(Argument argument) {
        try {
            int rID = Integer.parseInt(argument.getArg());
            boolean flag = false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId() == rID) {
                    list.remove(i);
                    flag = true;
                    break;
                }
            }
            if (flag) {
                list.add(MarineParser.parseSpaceMarine(MarineReader.initSpaceMarine(argument.getScanner(), argument.isInScript())));
                System.out.println(rID + "updated");
                return new Product(UPDATED_MESSAGE, true);
            } else {
                System.out.println("no such element in collection");
                return new Product(NO_SUCH_ID_MESSAGE, false);
            }
        } catch (Exception e) {
            System.out.println("no such element in collection");
            return new Product(INCORRECT_ID_MESSAGE, false);
        }
    }
}