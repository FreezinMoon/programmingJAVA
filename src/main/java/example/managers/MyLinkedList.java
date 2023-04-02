package example.managers;


import example.objects.SpaceMarine;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Consumer;
import java.util.function.Predicate;


/**
 * The MyLinkedList class represents a linked list of SpaceMarine objects.
 * Implements the Iterable interface for the ability to iterate over the elements of the list.
 */
public class MyLinkedList implements Iterable<SpaceMarine> {

    private final LinkedList<SpaceMarine> list;

    private final java.time.ZonedDateTime creationDate;

    /**
     * Constructor for the MyLinkedList class.
     * Initializes the list and sets the creation date of the list.
     */
    public MyLinkedList() {
        creationDate = java.time.ZonedDateTime.now();
        list = new LinkedList<>();
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param spaceMarine The element to add to the list.
     */
    public void add(SpaceMarine spaceMarine) {
        list.add(spaceMarine);
    }

    /**
     * Returns the creation date of the list as a string.
     *
     * @return A string containing the creation date of the list.
     */
    public String getCreationDate() {
        return "Initialization date: " + creationDate.toString();
    }

    /**
     * Returns the type of the collection.
     *
     * @return A string containing the type of the collection.
     */
    public String getType() {
        return "Collection type: " + this.getClass().getName();
    }

    /**
     * Applies the given action to all elements of the list.
     *
     * @param action The action to apply to the elements of the list.
     */
    public void forEach(Consumer<? super SpaceMarine> action) {
        list.forEach(action);
    }

    /**
     * Removes all elements from the list that satisfy the given predicate.
     *
     * @param filter The predicate that determines which elements to remove.
     * @return True if at least one element was removed, otherwise false.
     */
    public boolean removeIf(Predicate<? super SpaceMarine> filter) {
        return list.removeIf(filter);
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return The number of elements in the list.
     */
    public int size() {
        return list.size();
    }

    /**
     * Returns the element of the list at the given index.
     *
     * @param index The index of the element to retrieve.
     * @return The element of the list with the given index.
     */
    public SpaceMarine get(int index) {
        return list.get(index);
    }

    /**
     * Removes all elements from the list.
     */
    public void clear() {
        list.clear();
    }

    /**
     * Sorts the elements of the list using the given comparator.
     *
     * @param c The comparator to use for sorting the elements of the list.
     */
    public void sort(Comparator<? super SpaceMarine> c) {
        list.sort(c);
    }

    /**
     * Removes the element at the given index from the list.
     *
     * @param index The index of the element to remove.
     * @return The removed element.
     */
    public SpaceMarine remove(int index) {
        return list.remove(index);
    }

    /**
     * Returns an iterator over the elements of the list.
     *
     * @return An iterator over the elements of the list.
     */
    @Override
    public Iterator<SpaceMarine> iterator() {
        return list.iterator();
    }

    /**
     * Returns the element of the list with the largest value of the id field.
     *
     * @return The element of the list with the largest value of the id field.
     */
    public SpaceMarine getMax() {
        Comparator<? super SpaceMarine> comparator = new IdComparator();
        return Collections.max(list, comparator);
    }

    /**
     * Returns the element of the list with the smallest value of the id field.
     *
     * @return The element of the list with the smallest value of the id field.
     */
    public SpaceMarine getMin() {
        Comparator<? super SpaceMarine> comparator = new IdComparator();
        return Collections.min(list, comparator);
    }
}