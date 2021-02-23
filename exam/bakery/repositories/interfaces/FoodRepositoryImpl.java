package bakery.repositories.interfaces;

import bakery.entities.bakedFoods.interfaces.BakedFood;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class FoodRepositoryImpl<T extends BakedFood> implements FoodRepository<BakedFood>{
    private Collection<BakedFood> models;

    public FoodRepositoryImpl() {
        this.models=new ArrayList<>();
    }

    @Override
    public BakedFood getByName(String name) {
        for (BakedFood model : models) {
            if (model.getName().equals(name)) {
                return model;
            }
        }
        return null;
    }

    @Override
    public Collection<BakedFood> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(BakedFood bakedFood) {
        this.models.add(bakedFood);
    }
}
