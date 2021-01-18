package barracksWarsTwo.core.commands;

import barracksWarsTwo.interfaces.Repository;
import barracksWarsTwo.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class retire extends Command{
    public retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
       String unitType=this.getData()[1];
       getRepository().removeUnit(unitType);
       return unitType+" retired!";
    }
}
