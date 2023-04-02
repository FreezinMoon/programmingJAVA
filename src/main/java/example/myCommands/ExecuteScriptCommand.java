package example.myCommands;

import example.managers.Argument;
import example.managers.MyLinkedList;
import example.managers.Product;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.Stack;

/**
 * The ExecuteScriptCommand class is a concrete implementation of the Command class that executes a script file.
 */
public class ExecuteScriptCommand extends Command {
    private final Stack<String> scriptStack;
    private String arg;
    private String[] line;

    /**
     * Constructor for the ExecuteScriptCommand class.
     *
     * @param list The MyLinkedList object on which the command will be executed.
     */
    public ExecuteScriptCommand(MyLinkedList list) {
        super(list);
        this.scriptStack = new Stack<>();
    }

    /**
     * Returns the name of the execute_script command.
     *
     * @return The name of the execute_script command.
     */
    @Override
    public String getName() {
        return "execute_script";
    }

    /**
     * The execute_script command reads and executes commands from the specified file.
     * If the script isn't already in the stack of executed scripts, it attempts to read and execute the lines from the file specified by the argument.
     * Otherwise, it returns a failure Product object.
     *
     * @param argument The argument for the execute_script command.
     * @return The result of executing the execute_script command as a Product object.
     */
    @Override
    public Product execute(Argument argument) {
            try {
                String scriptName = argument.getArg();
                if (scriptStack.contains(scriptName)) {
                    return new Product("Script recursion detected", false);
                }
                scriptStack.push(scriptName);
                Path path = Path.of(argument.getArg());
                argument.setScanner(new Scanner(path));
                Scanner scanner = argument.getScanner();
                while (scanner.hasNext()) {
                    line = scanner.nextLine().split(" ");

                    if (line.length > 1) {
                        arg = line[1];
                    } else arg = "";
                    argument.getInvoker().executeCommand(line[0], new Argument(arg, scanner, argument.getInvoker(), true));
                }
                argument.setScanner(new Scanner(System.in));
                argument.setInScript(false);
                scriptStack.pop();
                return new Product("Script executed", true);
            } catch (IOException e) {
                return new Product("Error reading script file", false);
            }
    }
}
