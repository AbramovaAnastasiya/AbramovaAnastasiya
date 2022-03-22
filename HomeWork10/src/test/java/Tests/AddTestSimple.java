package Tests;

import digitalleague.storage_example.Storage;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddTestSimple extends BeforeTests {
    @Test
    public void AddTest1() {
        Assert.assertTrue(Storage.addObject("pineapple", 9));
    }
    @Test
    public void AddTest2(){
        int count = Storage.getProductAmount("pear");
        Storage.addObject("pear", 4);
        assertEquals(Storage.getProductAmount("pear"), count+4);
    }
}
