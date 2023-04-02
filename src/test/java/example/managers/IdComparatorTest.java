package example.managers;


import example.objects.SpaceMarine;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IdComparatorTest {

    @Test
    public void testCompare() {
        SpaceMarine sm1 = Mockito.mock(SpaceMarine.class);
        Mockito.when(sm1.getId()).thenReturn(1);

        SpaceMarine sm2 = Mockito.mock(SpaceMarine.class);
        Mockito.when(sm2.getId()).thenReturn(2);

        SpaceMarine sm3 = Mockito.mock(SpaceMarine.class);
        Mockito.when(sm3.getId()).thenReturn(3);

        List<SpaceMarine> list = Arrays.asList(sm2, sm3, sm1);
        list.sort(new IdComparator());

        assertEquals(sm1, list.get(0));
        assertEquals(sm2, list.get(1));
        assertEquals(sm3, list.get(2));
    }
}