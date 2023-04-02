package example.myCommands;

import example.managers.Argument;
import example.managers.MyLinkedList;
import example.managers.Product;

/**
 * The HelpCommand class is a concrete implementation of the Command class that prints a list of available commands and their descriptions.
 */
public class HelpCommand extends Command {

    private static final String OK_MESSAGE = "ok";

    /**
     * Constructor for the HelpCommand class.
     *
     * @param list The MyLinkedList object on which the command will be executed.
     */
    public HelpCommand(MyLinkedList list) {
        super(list);
    }

    /**
     * Returns the name of the help command.
     *
     * @return The name of the help command.
     */
    @Override
    public String getName() {
        return "help";
    }

    /**
     * Executes the help command and prints a list of available commands and their descriptions.
     *
     * @param argument The argument for the help command.
     * @return The result of executing the help command as a Product object.
     */
    @Override
    public Product execute(Argument argument) {
        String s = """
                help : вывести справку по доступным командам
                info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
                show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
                add {element} : добавить новый элемент в коллекцию
                update id {element} : обновить значение элемента коллекции, id которого равен заданному
                remove_by_id id : удалить элемент из коллекции по его id
                clear : очистить коллекцию
                save : сохранить коллекцию в файл
                execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
                exit : завершить программу (без сохранения в файл)
                add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции
                add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
                remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный
                print_unique_health : вывести уникальные значения поля health всех элементов в коллекции
                print_field_descending_category : вывести значения поля category всех элементов в порядке убывания
                print_field_descending_melee_weapon : вывести значения поля meleeWeapon всех элементов в порядке убывания""";
        System.out.println(s);
        return new Product(OK_MESSAGE, true);
    }
}