package example.managers;

import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class DaggerMyLinkedListComponent {
  private DaggerMyLinkedListComponent() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static MyLinkedListComponent create() {
    return new Builder().build();
  }

  public static final class Builder {
    private MyLinkedListModule myLinkedListModule;

    private Builder() {
    }

    public Builder myLinkedListModule(MyLinkedListModule myLinkedListModule) {
      this.myLinkedListModule = Preconditions.checkNotNull(myLinkedListModule);
      return this;
    }

    public MyLinkedListComponent build() {
      if (myLinkedListModule == null) {
        this.myLinkedListModule = new MyLinkedListModule();
      }
      return new MyLinkedListComponentImpl(myLinkedListModule);
    }
  }

  private static final class MyLinkedListComponentImpl implements MyLinkedListComponent {
    private final MyLinkedListComponentImpl myLinkedListComponentImpl = this;

    private Provider<MyLinkedList> provideMyLinkedListProvider;

    private MyLinkedListComponentImpl(MyLinkedListModule myLinkedListModuleParam) {

      initialize(myLinkedListModuleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final MyLinkedListModule myLinkedListModuleParam) {
      this.provideMyLinkedListProvider = DoubleCheck.provider(MyLinkedListModule_ProvideMyLinkedListFactory.create(myLinkedListModuleParam));
    }

    @Override
    public MyLinkedList getMyLinkedList() {
      return provideMyLinkedListProvider.get();
    }
  }
}
