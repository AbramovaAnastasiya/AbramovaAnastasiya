package Tests;

import digitalleague.storage_example.Storage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class AddTestParametrized extends BeforeTests {

    @Parameterized.Parameters()
    public static Collection<Object[]> setData(){
        return Arrays.asList(new Object[][]{
                {"banana", 2, true},
                {"pineapple", 11, true},
                {"mandarin", 1, true}} );}

    @Test
    public void AddTest() {
        Storage.addObject(data1, data2);
        assertEquals(Storage.isInStock(data1), result);
    }
    //@Test
    //public void AddTest1() {
    //    Assert.assertTrue(Storage.addObject(data1, data2));
    //}
    //@Test
    //public void AddTest2(){
    //    int count = Storage.getProductAmount(data1);
    //    Storage.addObject(data1, data2);
    //    assertEquals(Storage.getProductAmount(data1), count+data2);
    //}
}
