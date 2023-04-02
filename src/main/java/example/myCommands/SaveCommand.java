package example.myCommands;

import example.managers.Argument;
import example.managers.MyLinkedList;
import example.managers.Product;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import static example.Main.savedArg;

/**
 * The SaveCommand class is a concrete implementation of the Command class that saves the collection to a file.
 */
public class SaveCommand extends Command {

    private static final String SAVED_MESSAGE = "saved";
    private static final String NOT_SAVED_MESSAGE = "not saved";

    /**
     * Constructor for the SaveCommand class.
     *
     * @param list The MyLinkedList object on which the command will be executed.
     */
    public SaveCommand(MyLinkedList list) {
        super(list);
    }

    /**
     * Executes the save command and saves the collection to a file.
     *
     * @param argument The argument for the save command.
     * @return The result of executing the save command as a Product object.
     */
    @Override
    public Product execute(Argument argument) {
        try {
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(savedArg));

            for (int i = 0; i < list.size(); i++) {
                outputStream.write(list.get(i).getStringToCSV().getBytes());
                if (i < list.size() - 1) outputStream.write('\n');
            }

            outputStream.flush();
            outputStream.close();
            return new Product(SAVED_MESSAGE, true);
        } catch (Exception e) {
            System.out.println("Cannot find provided file");
            return new Product(NOT_SAVED_MESSAGE, false);
        }
    }

    /**
     * Returns the name of the save command.
     *
     * @return The name of the save command.
     */
    @Override
    public String getName() {
        return "save";
    }
}