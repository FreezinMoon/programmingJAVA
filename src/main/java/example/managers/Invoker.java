package example.managers;


import example.myCommands.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Invoker class that executes commands.
 */
public class Invoker {
    final Map<String, Command> commands = new HashMap<>();
    MyLinkedList list;

    /**
     * Constructor for the Invoker class.
     *
     * @param list the list of space marines
     */
    public Invoker(MyLinkedList list) {
        this.list = list;
        register(new AddCommand(list));
        register(new AddIfMaxCommand(list));
        register(new AddIfMinCommand(list));
        register(new ClearCommand(list));
        register(new ExecuteScriptCommand(list));
        register(new ExitCommand(list));
        register(new HelpCommand(list));
        register(new InfoCommand(list));
        register(new PrintFieldDescendingCategoryCommand(list));
        register(new PrintFieldDescendingMeleeWeaponCommand(list));
        register(new PrintUniqueHealthCommand(list));
        register(new RemoveByIdCommand(list));
        register(new RemoveLowerCommand(list));
        register(new SaveCommand(list));
        register(new ShowCommand(list));
        register(new UpdateByIdCommand(list));
    }

    /**
     * Adds the command to the HashMap.
     *
     * @param command the command to add
     */
    void register(Command command) {
        commands.put(command.getName(), command);
    }

    /**
     * Executes the given command with the specified argument.
     *
     * @param name     the name of the command
     * @param argument the argument for the command
     */
    public void executeCommand(String name, Argument argument) {
        try {
            commands.get(name).execute(argument);
        } catch (Exception e) {
            System.out.println("No such command");
        }
    }
}
