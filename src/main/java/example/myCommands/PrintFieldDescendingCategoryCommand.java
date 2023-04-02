package example.myCommands;

import example.managers.Argument;
import example.managers.MyLinkedList;
import example.managers.Product;

import java.util.Arrays;
import java.util.Comparator;

/**
 * The PrintFieldDescendingCategoryCommand class is a concrete implementation of the Command class that prints the values of the category field of each element in the collection in descending order.
 */
public class PrintFieldDescendingCategoryCommand extends Command {

    private static final String OK_MESSAGE = "ok";

    /**
     * Constructor for the PrintFieldDescendingCategoryCommand class.
     *
     * @param list The MyLinkedList object on which the command will be executed.
     */
    public PrintFieldDescendingCategoryCommand(MyLinkedList list) {
        super(list);
    }

    /**
     * Returns the name of the print_field_descending_category command.
     *
     * @return The name of the print_field_descending_category command.
     */
    @Override
    public String getName() {
        return "print_field_descending_category";
    }

    /**
     * Executes the print_field_descending_category command and prints the values of the category field of each element in the collection in descending order.
     *
     * @param argument The argument for the print_field_descending_category command.
     * @return The result of executing the print_field_descending_category command as a Product object.
     */
    @Override
    public Product execute(Argument argument) {
        String[] arr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i).getCategory().name();
        }
        Arrays.sort(arr, Comparator.reverseOrder());
        System.out.println(Arrays.toString(arr));
        return new Product(OK_MESSAGE, true);
    }
}