package example.managers;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
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
public final class MyLinkedListModule_ProvideMyLinkedListFactory implements Factory<MyLinkedList> {
  private final MyLinkedListModule module;

  public MyLinkedListModule_ProvideMyLinkedListFactory(MyLinkedListModule module) {
    this.module = module;
  }

  @Override
  public MyLinkedList get() {
    return provideMyLinkedList(module);
  }

  public static MyLinkedListModule_ProvideMyLinkedListFactory create(MyLinkedListModule module) {
    return new MyLinkedListModule_ProvideMyLinkedListFactory(module);
  }

  public static MyLinkedList provideMyLinkedList(MyLinkedListModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideMyLinkedList());
  }
}
