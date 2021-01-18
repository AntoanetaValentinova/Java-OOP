package barracksWarsTwo.core.commands;

import barracksWarsTwo.interfaces.Repository;
import barracksWarsTwo.interfaces.Unit;
import barracksWarsTwo.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class add extends Command{
    public add(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        String unitType = this.getData()[1];
        Unit unitToAdd = this.getUnitFactory().createUnit(unitType);
        this.getRepository().addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
