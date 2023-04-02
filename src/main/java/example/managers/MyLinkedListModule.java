package example.managers;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * The MyLinkedListModule class defines a Dagger module for providing dependencies for the MyLinkedList class.
 */
@Module
public class MyLinkedListModule {

    /**
     * Provides a singleton instance of the MyLinkedList class.
     *
     * @return A singleton instance of the MyLinkedList class.
     */
    @Provides
    @Singleton
    public MyLinkedList provideMyLinkedList() {
        return new MyLinkedList();
    }
}