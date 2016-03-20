package autofixture.publicinterface.generators;

import autofixture.publicinterface.FixtureContract;
import autofixture.publicinterface.InstanceGenerator;
import autofixture.publicinterface.InstanceType;

import java.util.Collection;

public class BuiltInCollectionGenerator implements InstanceGenerator {

  @Override
  public <T> boolean appliesTo(final InstanceType<T> clazz) {
    return
        clazz.isAssignableTo(Collection.class)
            || Iterable.class.isAssignableFrom(clazz.getRawType());
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public <T> T next(final InstanceType<T> type, final FixtureContract fixture) {
    //TODO make same as array generation
    final Collection collection = type.createCollection(fixture.getRepeatCount());
    final InstanceType<?> nestedGenericType = type.getNestedGenericType();
    collection.addAll(fixture.createMany(nestedGenericType));
    return (T) collection;
  }

  @Override
  public void setOmittingAutoProperties(final boolean isOn) {
  }


}
