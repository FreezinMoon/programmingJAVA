package example.managers;

import dagger.Component;

import javax.inject.Singleton;

/**
 * The MyLinkedListComponent interface defines a Dagger component for creating a singleton instance of the MyLinkedList class.
 * Uses the MyLinkedListModule class to provide dependencies for the MyLinkedList constructor.
 */
@Singleton
@Component(modules = {MyLinkedListModule.class})
public interface MyLinkedListComponent {

    /**
     * Returns a singleton instance of the MyLinkedList class.
     *
     * @return A singleton instance of the MyLinkedList class.
     */
    MyLinkedList getMyLinkedList();
}