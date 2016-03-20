package autofixture.publicinterface.generators;

import autofixture.publicinterface.FixtureContract;
import autofixture.publicinterface.InstanceGenerator;
import autofixture.publicinterface.InstanceType;

import java.time.Period;
import java.time.ZonedDateTime;

/**
 * Created by astral on 08.02.15.
 */
public class ZonedDateTimeGenerator implements InstanceGenerator {
  @Override
  public <T> boolean appliesTo(final InstanceType<T> instanceType) {
    return instanceType.isRawTypeAssignableFrom(ZonedDateTime.class);
  }

  @Override
  public <T> T next(final InstanceType<T> instanceType, final FixtureContract fixture) {
    return (T) ZonedDateTime.now().plus(Period.ofDays(fixture.create(Integer.class)));
  }

  @Override
  public void setOmittingAutoProperties(final boolean isOn) {

  }
}
