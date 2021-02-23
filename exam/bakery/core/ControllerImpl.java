package bakery.core;

import bakery.common.ExceptionMessages;
import bakery.common.OutputMessages;
import bakery.core.interfaces.Controller;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.bakedFoods.interfaces.Bread;
import bakery.entities.bakedFoods.interfaces.Cake;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.drinks.interfaces.Tea;
import bakery.entities.drinks.interfaces.Water;
import bakery.entities.tables.interfaces.InsideTable;
import bakery.entities.tables.interfaces.OutsideTable;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static bakery.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static bakery.common.ExceptionMessages.TABLE_EXIST;
import static bakery.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private FoodRepository<BakedFood> foods;
    private DrinkRepository<Drink> drinks;
    private TableRepository<Table> tables;
    private List<Double> bills;


    public ControllerImpl(FoodRepository<BakedFood> foodRepository, DrinkRepository<Drink> drinkRepository, TableRepository<Table> tableRepository) {
        this.foods=foodRepository;
        this.drinks=drinkRepository;
        this.tables=tableRepository;
        this.bills=new ArrayList<>();
    }


    @Override
    public String addFood(String type, String name, double price) {
        boolean isExist=false;
        Collection<BakedFood> foodsAll = this.foods.getAll();
        for (BakedFood bakedFood : foodsAll) {
            if (bakedFood.getName().equals(name)) {
                isExist=true;
            }
        }
        if (isExist) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST,type,name));
        }
        BakedFood bakedFood=null;
        if (type.equals("Bread")) {
            bakedFood=new Bread(name,price);
        } else if (type.equals("Cake")) {
            bakedFood=new Cake(name,price);
        }
        this.foods.add(bakedFood);
        return String.format(FOOD_ADDED,name,type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        boolean isExist=false;
        Collection<Drink> drinksAll = this.drinks.getAll();
        for (Drink drink : drinksAll) {
            if (drink.getName().equals(name)) {
                isExist=true;
            }
        }
        if (isExist) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST,type,name));
        }
        Drink drink=null;
        if (type.equals("Tea")) {
            drink=new Tea(name,portion,brand);
        } else if (type.equals("Water")) {
            drink=new Water(name,portion,brand);
        }
        this.drinks.add(drink);
        return String.format(DRINK_ADDED,name,brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        boolean isExist=false;
        Collection<Table> all = this.tables.getAll();
        for (Table table : all) {
            if (table.getTableNumber()==tableNumber) {
                isExist=true;
            }
        }
        if (isExist) {
            throw new IllegalArgumentException(String.format(TABLE_EXIST,tableNumber));
        }
        Table table=null;
        if (type.equals("InsideTable")) {
            table=new InsideTable(tableNumber,capacity);
        } else if (type.equals("OutsideTable")) {
            table=new OutsideTable(tableNumber,capacity);
        }
        this.tables.add(table);
        return String.format(TABLE_ADDED,tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {


        Collection<Table> all = this.tables.getAll();
        for (Table table : all) {
            if (!table.isReserved()&&table.getCapacity()>=numberOfPeople) {
                table.reserve(numberOfPeople);
                return String.format(TABLE_RESERVED,table.getTableNumber(),numberOfPeople);
            }
        }

        return String.format(RESERVATION_NOT_POSSIBLE,numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        Collection<Table> all = this.tables.getAll();
        boolean isTableExist=false;
        boolean isFoodExist=false;
        String output="";
        for (Table table : all) {
            if (table.getTableNumber()==tableNumber) {
                isTableExist=true;
                Collection<BakedFood> foodsAll = this.foods.getAll();
                for (BakedFood bakedFood : foodsAll) {
                    if(bakedFood.getName().equals(foodName)) {
                        isFoodExist=true;
                        table.orderFood(bakedFood);
                        output=String.format(FOOD_ORDER_SUCCESSFUL,tableNumber,foodName);
                    }
                }
            }
        }
        if (!isTableExist) {
            return String.format(WRONG_TABLE_NUMBER,tableNumber);
        }
        if (!isFoodExist) {
            return String.format(NONE_EXISTENT_FOOD,foodName);
        }
        return output;
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        Collection<Table> all = this.tables.getAll();
        boolean isTableExist=false;
        boolean isDrinkExist=false;
        String output="";
        for (Table table : all) {
            if (table.getTableNumber()==tableNumber) {
                isTableExist=true;
                Collection<Drink> drinkCollection = this.drinks.getAll();
                for (Drink drink : drinkCollection) {
                    if(drink.getName().equals(drinkName)&&drink.getBrand().equals(drinkBrand)) {
                        isDrinkExist=true;
                        table.orderDrink(drink);
                        output=String.format(DRINK_ORDER_SUCCESSFUL,tableNumber,drinkName,drinkBrand);
                    }
                }
            }
        }
        if (!isTableExist) {
            return String.format(WRONG_TABLE_NUMBER,tableNumber);
        }
        if (!isDrinkExist) {
            return String.format(NON_EXISTENT_DRINK,drinkName,drinkBrand);
        }
        return output;

    }

    @Override
    public String leaveTable(int tableNumber) {
        Collection<Table> tablesAll = tables.getAll();
        double bill=0;
        for (Table table : tablesAll) {
            if (table.getTableNumber()==tableNumber) {
                 bill = table.getBill();
                 bills.add(bill);
                 table.clear();
            }
        }
        return String.format(BILL,tableNumber,bill);
    }

    @Override
    public String getFreeTablesInfo() {
        StringBuilder sb=new StringBuilder();
        Collection<Table> all = tables.getAll();
        for (Table table : all) {
            if (!table.isReserved()) {
                sb.append(table.getFreeTableInfo()).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String getTotalIncome() {
        double total=0;
        for (Double bill : bills) {
            total+=bill;
        }
        return String.format(TOTAL_INCOME,total);
    }
}
