package Tests;

import digitalleague.storage_example.Storage;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddNewTestSimple extends BeforeTests {
    @Test
    public void addNewObjectTest(){
        assertTrue(Storage.addNewObject("kiwi", 11));
    }
    @Test
    public void addNewObjectTest1(){
        Storage.addNewObject("peach",8);
        assertTrue(Storage.isInStock("peach"));
    }
    @Test
    public void AddNewObjectTest2(){
        int count = Storage.getFreePlaces();
        Storage.addNewObject("apple", 1);
        assertEquals(Storage.getFreePlaces(), count-1);

    }
}
