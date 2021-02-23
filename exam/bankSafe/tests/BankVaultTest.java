package bankSafe;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Map;

public class BankVaultTest {
    private BankVault bankVault;

    @Before
    public void setUp () {
        this.bankVault=new BankVault();
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddShouldThrowExWhenCellDoesntExist() throws OperationNotSupportedException {
        this.bankVault.addItem("D",null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddShouldThrowExWhenCellIsTaken() throws OperationNotSupportedException {
        this.bankVault.addItem("B1",new Item("test","test"));
        this.bankVault.addItem("B1",new Item("test2","test2"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowExWheniTEMiSiNCell() throws OperationNotSupportedException {
        Item item=new Item("test","test");
        this.bankVault.addItem("B1",item);
        this.bankVault.addItem("B2",item);
    }

    @Test
    public void testAdd() throws OperationNotSupportedException {
        Item item = new Item("test", "test");
        String addItem = this.bankVault.addItem("B1", item);
        Assert.assertEquals("Item:test saved successfully!",addItem);
    }
    @Test
    public void testAdd2() throws OperationNotSupportedException {
        Item item = new Item("test", "test");
        String addItem = this.bankVault.addItem("B1", item);

        Assert.assertEquals("test",item.getItemId());
        Assert.assertEquals("test",item.getOwner());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldThrowExWhenCellDoesNotExist () {
        this.bankVault.removeItem("D",new Item("test","test"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveShouldThrowExWhenItemDoesNotExist () throws OperationNotSupportedException {
        Item item=new Item("test","test");
        Item item2=new Item("testF","testG");
        this.bankVault.addItem("B1",item);
        this.bankVault.removeItem("B1",item2);
    }

    @Test
    public void testRemove() throws OperationNotSupportedException {
        Item item=new Item("test","test");
        this.bankVault.addItem("B1",item);
        String removeItem = this.bankVault.removeItem("B1", item);
        Assert.assertEquals("Remove item:test successfully!",removeItem);
    }

    @Test
    public void testRemove2() throws OperationNotSupportedException {
        Item item=new Item("test","test");
        this.bankVault.addItem("B1",item);
        String removeItem = this.bankVault.removeItem("B1", item);
        Assert.assertEquals(null,this.bankVault.getVaultCells().get("B1"));
    }


    @Test
    public void testGet() {
        Map<String, Item> vaultCells = this.bankVault.getVaultCells();
        Assert.assertEquals(null,vaultCells.get("A1"));
        Assert.assertEquals(null,vaultCells.get("A2"));
        Assert.assertEquals(null,vaultCells.get("A3"));
        Assert.assertEquals(null,vaultCells.get("A4"));
        Assert.assertEquals(null,vaultCells.get("B1"));
        Assert.assertEquals(null,vaultCells.get("B2"));
        Assert.assertEquals(null,vaultCells.get("B3"));
        Assert.assertEquals(null,vaultCells.get("B4"));
        Assert.assertEquals(null,vaultCells.get("C1"));
        Assert.assertEquals(null,vaultCells.get("C2"));
        Assert.assertEquals(null,vaultCells.get("C3"));
        Assert.assertEquals(null,vaultCells.get("C4"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetUnmod() {
        this.bankVault.getVaultCells().remove("A1");
        Item a1 = this.bankVault.getVaultCells().get("A1");
        Assert.assertEquals(null,a1);
    }



}