package barracksWarsTwo.core.commands;

import barracksWarsTwo.interfaces.Repository;
import barracksWarsTwo.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class fight extends Command{
    public fight(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        return "fight";
    }
}
