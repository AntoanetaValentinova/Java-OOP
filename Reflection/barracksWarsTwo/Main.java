package barracksWarsTwo;

import barracksWarsTwo.interfaces.Repository;
import barracksWarsTwo.interfaces.Runnable;
import barracksWarsTwo.interfaces.UnitFactory;
import barracksWarsTwo.core.Engine;
import barracksWarsTwo.core.factories.UnitFactoryImpl;
import barracksWarsTwo.data.UnitRepository;

public class Main {

    public static void main(String[] args) {

        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
