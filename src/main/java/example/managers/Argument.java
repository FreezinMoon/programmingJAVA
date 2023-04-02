package example.managers;

import java.nio.file.Path;
import java.util.Scanner;

/**
 * Represents an argument for a command in the application.
 */
public class Argument {
    /**
     * The string representation of the argument.
     */
    String arg;

    /**
     * The scanner used to read user input.
     */
    Scanner scanner;
    /**
     * The invoker that executes commands in the application.
     */
    Invoker invoker;
    /**
     * A boolean value indicating whether the application is running in a script or not.
     */
    boolean isInScript;

    /**
     * Constructs an Argument object with the specified parameters.
     *
     * @param arg        The string representation of the argument.
     * @param scanner    The scanner used to read user input.
     * @param invoker    The invoker that executes commands in the application.
     * @param isInScript A boolean value indicating whether the application is running in a script or not.
     */
    public Argument(String arg, Scanner scanner, Invoker invoker, boolean isInScript) {
        this.arg = arg;
        this.scanner = scanner;
        this.invoker = invoker;
        this.isInScript = isInScript;
    }

    /**
     * Returns the string representation of the argument.
     *
     * @return The string representation of the argument.
     */
    public String getArg() {
        return arg;
    }

    /**
     * Sets the string representation of the argument.
     *
     * @param arg The string representation of the argument.
     */
    public Argument setArg(String arg) {
        this.arg = arg;
        return this;
    }

    /**
     * Returns the scanner used to read user input.
     *
     * @return The scanner used to read user input.
     */
    public Scanner getScanner() {
        return scanner;
    }

    /**
     * Sets the scanner used to read user input.
     *
     * @param scanner The scanner used to read user input.
     */
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Returns the invoker that executes commands in the application.
     *
     * @return The invoker that executes commands in the application.
     */
    public Invoker getInvoker() {
        return invoker;
    }

    /**
     * Sets the invoker that executes commands in the application.
     *
     * @param invoker The invoker that executes commands in the application.
     */
    public void setInvoker(Invoker invoker) {
        this.invoker = invoker;
    }

    /**
     * Closes the scanner used to read user input.
     */
    public void closeScanner() {
        scanner.close();
    }

    /**
     * Returns a boolean value indicating whether the application is running in a script or not.
     *
     * @return A boolean value indicating whether the application is running in a script or not.
     */
    public boolean isInScript() {
        return isInScript;
    }

    /**
     * Sets a boolean value indicating whether the application is running in a script or not.
     *
     * @param inScript A boolean value indicating whether the application is running in a script or not.
     */
    public void setInScript(boolean inScript) {
        isInScript = inScript;
    }
}