package jfixture.publicinterface.generators;

import java.util.Random;

import jfixture.publicinterface.Fixture;
import jfixture.publicinterface.InstanceType;

import com.google.common.reflect.TypeToken;

public class EnumGenerator implements InstanceGenerator {

	@Override
	public <T> boolean AppliesTo(InstanceType<T> typeToken) {
		return typeToken.isEnum();
	}

	@Override
	public <T> T next(InstanceType<T> type, Fixture fixture) {
		Object[] enumElements = type.getEnumConstants();
		int idx = new Random().nextInt(enumElements.length);
		return (T)(enumElements[idx]);
		//TODO make it sequential! Random is bad...
	}

}
