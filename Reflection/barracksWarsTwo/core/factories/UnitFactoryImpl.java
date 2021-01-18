package barracksWarsTwo.core.factories;

import barracksWarsTwo.interfaces.Unit;
import barracksWarsTwo.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWarsTwo.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {
		Unit unit=null;
		try {
			Class clazz=Class.forName(UNITS_PACKAGE_NAME+unitType);
			unit=(Unit)clazz.getDeclaredConstructor().newInstance();
		} catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			throw new ExecutionControl.NotImplementedException("Invalid unit type!");
		}
		return unit;
	}
}
