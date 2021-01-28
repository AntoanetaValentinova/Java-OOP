package onlineShop.models.products.computers;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.COMPUTER_COMPONENTS_TO_STRING;
import static onlineShop.common.constants.OutputMessages.COMPUTER_PERIPHERALS_TO_STRING;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public double getOverallPerformance() {
        if (components.isEmpty()) {
            return super.getOverallPerformance();
        }
        double sum = super.getOverallPerformance();
        double avgPerfComponents = 0;
        for (Component component : components) {
            avgPerfComponents += component.getOverallPerformance();
        }
        avgPerfComponents = avgPerfComponents / this.components.size();
        sum += avgPerfComponents;
        return sum;
    }

    @Override
    public double getPrice() {
        double sum = super.getPrice();
        for (Component component : components) {
            sum += component.getPrice();
        }
        for (Peripheral peripheral : peripherals) {
            sum += peripheral.getPrice();
        }
        return sum;
    }

    @Override
    public List<Component> getComponents() {
        return components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return peripherals;
    }

    @Override
    public void addComponent(Component component) {
        for (Component currentComponent : components) {
            if (currentComponent.getClass().getSimpleName().equals(component.getClass().getSimpleName())) {
                throw new IllegalArgumentException(String.format(EXISTING_COMPONENT, component.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
            }
        }
        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        if (this.components.isEmpty()) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT, componentType, this.getClass().getSimpleName(), this.getId()));
        }
        boolean isExist = false;
        int index = 0;
        for (int i = 0; i < components.size(); i++) {
            if (components.get(i).getClass().getSimpleName().equals(componentType)) {
                isExist = true;
                index = i;
            }
        }
        if (!isExist) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT, componentType, this.getClass().getSimpleName(), this.getId()));
        }

        Component removed = this.components.remove(index);
        return removed;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        for (Peripheral currentPeripherial : peripherals) {
            if (currentPeripherial.getClass().getSimpleName().equals(peripheral.getClass().getSimpleName())) {
                throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL, peripheral.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
            }
        }
        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        if (this.peripherals.isEmpty()) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL, peripheralType, this.getClass().getSimpleName(), this.getId()));
        }
        boolean isExist = false;
        int index = 0;
        for (int i = 0; i < peripherals.size(); i++) {
            if (peripherals.get(i).getClass().getSimpleName().equals(peripheralType)) {
                isExist = true;
                index = i;
            }
        }
        if (!isExist) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL, peripheralType, this.getClass().getSimpleName(), this.getId()));
        }

        Peripheral removed = this.peripherals.remove(index);
        return removed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append(String.format(" " + COMPUTER_COMPONENTS_TO_STRING, this.components.size())).append(System.lineSeparator());
        for (Component component : components) {
            sb.append("  ").append(component).append(System.lineSeparator());
        }
        double avg = 0.0;
        if (this.peripherals.size() > 0) {
            for (Peripheral peripheral : peripherals) {
                avg += peripheral.getOverallPerformance();
            }
            avg = avg / this.peripherals.size();
        }
        sb.append(" ").append(String.format(COMPUTER_PERIPHERALS_TO_STRING, this.peripherals.size(), avg)).append(System.lineSeparator());
        for (Peripheral peripheral : peripherals) {
            sb.append("  ").append(peripheral).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
