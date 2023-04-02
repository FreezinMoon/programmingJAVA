package example.managers;

import example.objects.SpaceMarine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MyLinkedListTest {

    private MyLinkedList list;

    @Mock
    private SpaceMarine marine1;

    @Mock
    private SpaceMarine marine2;

    @Mock
    private SpaceMarine marine3;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        list = new MyLinkedList();
        list.add(marine1);
        list.add(marine2);
        list.add(marine3);
    }

    @Test
    public void testAdd() {
        SpaceMarine marine4 = mock(SpaceMarine.class);
        list.add(marine4);
        assertEquals(4, list.size());
        assertSame(marine4, list.get(3));
    }

    @Test
    public void testGetCreationDate() {
        assertNotNull(list.getCreationDate());
    }

    @Test
    public void testGetType() {
        assertNotNull(list.getType());
    }

    @Test
    public void testForEach() {
        Consumer<SpaceMarine> consumer = mock(Consumer.class);
        list.forEach(consumer);
        verify(consumer, times(3)).accept(any());
    }

    @Test
    public void testRemoveIf() {
        Predicate<SpaceMarine> predicate = mock(Predicate.class);
        when(predicate.test(any())).thenReturn(true);
        assertTrue(list.removeIf(predicate));
        assertEquals(0, list.size());
    }

    @Test
    public void testSize() {
        assertEquals(3, list.size());
    }

    @Test
    public void testGet() {
        assertSame(marine1, list.get(0));
        assertSame(marine2, list.get(1));
        assertSame(marine3, list.get(2));
    }

    @Test
    public void testClear() {
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testRemove() {
        assertSame(marine3, list.remove(2));
        assertEquals(2, list.size());
    }

    @Test
    public void testIterator() {
        Iterator<SpaceMarine> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertNotNull(iterator.next());
    }

    @Test
    public void testGetMax() {
        when(marine1.getId()).thenReturn(1);
        when(marine2.getId()).thenReturn(2);
        when(marine3.getId()).thenReturn(3);
        assertSame(marine3, list.getMax());
    }

    @Test
    public void testGetMin() {
        when(marine1.getId()).thenReturn(1);
        when(marine2.getId()).thenReturn(2);
        when(marine3.getId()).thenReturn(3);
        assertSame(marine1, list.getMin());
    }
}
