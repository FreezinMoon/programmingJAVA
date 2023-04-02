package example.managers;

import example.myCommands.Command;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class InvokerTest {

    @Mock
    private MyLinkedList list;

    @Mock
    private Command command;

    private Invoker invoker;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        invoker = new Invoker(list);
        when(command.getName()).thenReturn("testCommand");
    }

    @Test
    public void testExecuteCommand() {
        Argument argument = mock(Argument.class);
        invoker.commands.put("testCommand", command);
        invoker.executeCommand("testCommand", argument);
        verify(command, times(1)).execute(argument);
    }

    @Test
    public void testExecuteCommandNoSuchCommand() {
        Argument argument = mock(Argument.class);
        invoker.executeCommand("noSuchCommand", argument);
        verify(list, times(0)).getCreationDate();
    }
}
