package onlineShop.core;

import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Map<Integer,Computer> computers;
    private Map<Integer, Component> components;
    private Map<Integer, Peripheral> peripherals;

    public ControllerImpl() {
        this.computers=new LinkedHashMap<>();
        this.components=new LinkedHashMap<>();
        this.peripherals=new LinkedHashMap<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        if (computers.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        }
        if (!computerType.equals("DesktopComputer")&&!computerType.equals("Laptop")) {
            throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
        }
        Computer computer=null;
        switch (computerType) {
            case"DesktopComputer":
                computer=new DesktopComputer(id,manufacturer,model,price);
                break;
            case"Laptop":
                computer=new Laptop(id,manufacturer,model,price);
                break;
        }
        this.computers.put(id,computer);
        return String.format(ADDED_COMPUTER,id);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        if (!this.computers.containsKey(computerId)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        if (this.peripherals.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }
        Peripheral peripheral=null;
        switch (peripheralType) {
            case"Headset":
                peripheral=new Headset(id,manufacturer,model,price,overallPerformance,connectionType);
                break;
            case"Keyboard":
                peripheral=new Keyboard(id,manufacturer,model,price,overallPerformance,connectionType);
                break;
            case"Monitor":
                peripheral=new Monitor(id,manufacturer,model,price,overallPerformance,connectionType);
                break;
            case"Mouse":
                peripheral=new Mouse(id,manufacturer,model,price,overallPerformance,connectionType);
                break;
            default: throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }
        this.computers.get(computerId).addPeripheral(peripheral);
        this.peripherals.put(id,peripheral);
        //Peripheral {peripheral type} with id {peripheral id} added successfully in computer with id {computer id}.".
        return String.format(ADDED_PERIPHERAL,peripheralType,id,computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        if (!this.computers.containsKey(computerId)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        Peripheral peripheral = this.computers.get(computerId).removePeripheral(peripheralType);
        this.peripherals.remove(peripheral.getId());
     //returns "Successfully removed {peripheral type} with id { peripheral id}.".
        return String.format(REMOVED_PERIPHERAL,peripheralType,peripheral.getId());
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        if (!this.computers.containsKey(computerId)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        if (this.components.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }
        Component component=null;
        switch (componentType) {
            case"CentralProcessingUnit":
                component=new CentralProcessingUnit(id,manufacturer,model,price,overallPerformance,generation);
            break;
            case"Motherboard":
                component=new Motherboard(id,manufacturer,model,price,overallPerformance,generation);
                break;
            case"PowerSupply":
                component=new PowerSupply(id,manufacturer,model,price,overallPerformance,generation);
                break;
            case"RandomAccessMemory":
                component=new RandomAccessMemory(id,manufacturer,model,price,overallPerformance,generation);break;
            case"SolidStateDrive":
                component=new SolidStateDrive(id,manufacturer,model,price,overallPerformance,generation);break;
            case"VideoCard":
                component=new VideoCard(id,manufacturer,model,price,overallPerformance,generation);
                break;
            default: throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }
        this.computers.get(computerId).addComponent(component);
        this.components.put(id,component);
        //Component {component type} with id {component id} added successfully in computer with id {computer id}.".
        return String.format(ADDED_COMPONENT,componentType,id,computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        if (!this.computers.containsKey(computerId)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        Component component = this.computers.get(computerId).removeComponent(componentType);
        this.components.remove(component.getId());
        //"Successfully removed {component type} with id {component id}.".
        return String.format(REMOVED_COMPONENT,componentType,component.getId());
    }

    @Override
    public String buyComputer(int id) {
        if (!this.computers.containsKey(id)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        Computer removedComputer = this.computers.remove(id);

        return removedComputer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {
        if (this.computers.isEmpty()) {
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER,budget));
        }
        Computer computer = this.computers.values()
                .stream()
                .filter(c -> c.getPrice() <= budget)
                .sorted((c1, c2) -> Double.compare(c2.getOverallPerformance(), c1.getOverallPerformance()))
                .findFirst()
                .orElse(null);
        if (computer==null) {
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER,budget));
        }
        this.computers.remove(computer.getId());
        return computer.toString();
    }

    @Override
    public String getComputerData(int id) {
        if (!this.computers.containsKey(id)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
        Computer computer = this.computers.get(id);
        return computer.toString();
    }
}
