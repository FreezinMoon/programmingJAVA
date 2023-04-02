package example.managers;


import example.objects.SpaceMarine;

import java.util.Comparator;

/**
 * A custom implementation of the Comparator interface that compares two SpaceMarine objects based on their ID field.
 */
public class IdComparator implements Comparator<SpaceMarine> {
    /**
     * Compares two SpaceMarine objects based on their ID field.
     *
     * @param sm1 the first SpaceMarine object to compare
     * @param sm2 the second SpaceMarine object to compare
     * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to,
     * or greater than the second, respectively, based on their ID field.
     */
    @Override
    public int compare(SpaceMarine sm1, SpaceMarine sm2) {
        return Integer.compare(sm1.getId(), sm2.getId());
    }
}
