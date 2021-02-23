package bakery.entities.tables.interfaces;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;

import java.util.ArrayList;
import java.util.Collection;

import static bakery.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static bakery.common.ExceptionMessages.INVALID_TABLE_CAPACITY;

public abstract class BaseTable implements Table{
    private Collection<BakedFood> foodOrders;
    private Collection<Drink> drinkOrders;
    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    protected BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.foodOrders=new ArrayList<>();
        this.drinkOrders=new ArrayList<>();
        this.tableNumber= tableNumber;
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople<=0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    private void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    private void setCapacity(int capacity) {
        if (capacity<0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    private void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    @Override
    public int getTableNumber() {
        return this.tableNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        if (numberOfPeople!=0) {
            return true;
        }
        return false;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        this.setNumberOfPeople(numberOfPeople);
    }

    @Override
    public void orderFood(BakedFood food) {
        this.foodOrders.add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        this.drinkOrders.add(drink);
    }

    @Override
    public double getBill() {
        double bill=0;
        bill+=this.numberOfPeople*this.pricePerPerson;
        for (BakedFood foodOrder : foodOrders) {
            bill+=foodOrder.getPrice();
        }
        for (Drink drinkOrder : drinkOrders) {
            bill+=drinkOrder.getPrice();
        }
        return bill;
    }

    @Override
    public void clear() {
        this.drinkOrders.clear();
        this.foodOrders.clear();
        this.price=0;
        this.numberOfPeople=0;
    }

    @Override
    public String getFreeTableInfo() {
        StringBuilder sb=new StringBuilder();
        sb.append(String.format("Table: %d",getTableNumber())).append(System.lineSeparator());
        sb.append(String.format("Type: %s",this.getClass().getSimpleName())).append(System.lineSeparator());
        sb.append(String.format("Capacity: %d",getCapacity())).append(System.lineSeparator());
        sb.append(String.format("Price per Person: %.2f",getPricePerPerson())).append(System.lineSeparator());
        return sb.toString().trim();
    }
}
