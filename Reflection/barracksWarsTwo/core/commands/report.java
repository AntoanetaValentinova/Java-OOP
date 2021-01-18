package barracksWarsTwo.core.commands;

import barracksWarsTwo.interfaces.Executable;
import barracksWarsTwo.interfaces.Repository;
import barracksWarsTwo.interfaces.UnitFactory;

public class report extends  Command{


    public report(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String output = super.getRepository().getStatistics();
        return output;
    }
}
