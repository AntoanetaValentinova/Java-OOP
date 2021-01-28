package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ComputerManagerTests {
    private ComputerManager computerManager;

    @Before
    public void setUp () {
        this.computerManager=new ComputerManager();
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddMethodShouldThrowExWithEmptyComputer () {
        this.computerManager.addComputer(null);
    }

    @Test
    public void testAddMethodShouldCorrectlyAddComputers() {
        this.computerManager.addComputer(new Computer("man","model",1000));
        this.computerManager.addComputer(new Computer("man2","model1",1000));
        this.computerManager.addComputer(new Computer("man3","model2",1000));
        List<Computer> computers = this.computerManager.getComputers();
        Assert.assertEquals(3,computers.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddMethodShouldNotAddAnExistingComputer() {
        this.computerManager.addComputer(new Computer("man","model",1000));
        this.computerManager.addComputer(new Computer("man","model",1000));
    }

    @Test
    public void testRemoveComputerShouldCorrectlyRemoveComputerFromTheList () {
        this.computerManager.addComputer(new Computer("man","model",1000));
        this.computerManager.addComputer(new Computer("man2","model1",1000));
        this.computerManager.addComputer(new Computer("man3","model2",1000));
        Computer removeComputer = this.computerManager.removeComputer("man", "model");
        Assert.assertEquals("man",removeComputer.getManufacturer());
        Assert.assertEquals("model",removeComputer.getModel());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveComputerShouldReturnNullWhenTheComputerNotExist () {
        this.computerManager.addComputer(new Computer("man","model",1000));
        this.computerManager.addComputer(new Computer("man2","model1",1000));
        this.computerManager.addComputer(new Computer("man3","model2",1000));
        Computer removeComputer = this.computerManager.removeComputer("man10", "model10");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerWithEmptyManShouldThrowEx() {
        this.computerManager.addComputer(new Computer("man","model",1000));
        this.computerManager.addComputer(new Computer("man2","model1",1000));
        this.computerManager.addComputer(new Computer("man3","model2",1000));
        this.computerManager.getComputer(null,"model");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerWithEmptyModelShouldThrowEx() {
        this.computerManager.addComputer(new Computer("man","model",1000));
        this.computerManager.addComputer(new Computer("man2","model1",1000));
        this.computerManager.addComputer(new Computer("man3","model2",1000));
        this.computerManager.getComputer("man",null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerWithNotExistingComputerShouldThrowEx() {
        this.computerManager.addComputer(new Computer("man","model",1000));
        this.computerManager.addComputer(new Computer("man2","model1",1000));
        this.computerManager.addComputer(new Computer("man3","model2",1000));
        this.computerManager.getComputer("man10","model10");
    }

    @Test
    public void testGetComputerShouldReturnTheCorrectComputer() {
        this.computerManager.addComputer(new Computer("man","model",1000));
        this.computerManager.addComputer(new Computer("man2","model1",1000));
        this.computerManager.addComputer(new Computer("man3","model2",1000));
        Computer computer = this.computerManager.getComputer("man2", "model1");
        Assert.assertEquals("man2",computer.getManufacturer());
        Assert.assertEquals("model1",computer.getModel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testgetComputersByManufacturerShouldThrowExWhenTheParamIsNull() {
        this.computerManager.addComputer(new Computer("man","model",1000));
        this.computerManager.addComputer(new Computer("man2","model1",1000));
        this.computerManager.addComputer(new Computer("man3","model2",1000));
        this.computerManager.getComputersByManufacturer(null);
    }

    @Test
    public void testGetComputersByManufacturerShouldReturnListWithComputers() {
        this.computerManager.addComputer(new Computer("man","model",1000));
        this.computerManager.addComputer(new Computer("man2","model1",1000));
        this.computerManager.addComputer(new Computer("man3","model2",1000));
        this.computerManager.addComputer(new Computer("man","model3",1000));
        this.computerManager.addComputer(new Computer("man","model4",1000));
        List<Computer> computersByManufacturer = this.computerManager.getComputersByManufacturer("man");
        Assert.assertEquals(3,computersByManufacturer.size());
        Assert.assertEquals("man",computersByManufacturer.get(0).getManufacturer());
        Assert.assertEquals("model",computersByManufacturer.get(0).getModel());
        Assert.assertEquals("man",computersByManufacturer.get(1).getManufacturer());
        Assert.assertEquals("model3",computersByManufacturer.get(1).getModel());
        Assert.assertEquals("man",computersByManufacturer.get(2).getManufacturer());
        Assert.assertEquals("model4",computersByManufacturer.get(2).getModel());
    }

    @Test
    public void testGetComputersByManufacturerShouldReturnEmptyList() {
        this.computerManager.addComputer(new Computer("man","model",1000));
        this.computerManager.addComputer(new Computer("man2","model1",1000));
        this.computerManager.addComputer(new Computer("man3","model2",1000));
        this.computerManager.addComputer(new Computer("man","model3",1000));
        this.computerManager.addComputer(new Computer("man","model4",1000));
        List<Computer> computersByManufacturer = this.computerManager.getComputersByManufacturer("man20");
        Assert.assertEquals(0,computersByManufacturer.size());
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(0,this.computerManager.getCount());
        this.computerManager.addComputer(new Computer("man","model",1000));
        this.computerManager.addComputer(new Computer("man2","model1",1000));
        this.computerManager.addComputer(new Computer("man3","model2",1000));
        this.computerManager.addComputer(new Computer("man","model3",1000));
        this.computerManager.addComputer(new Computer("man","model4",1000));
        Assert.assertEquals(5,this.computerManager.getCount());
    }

  
}