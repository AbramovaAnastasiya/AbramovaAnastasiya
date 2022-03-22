package Tests;

import digitalleague.storage_example.Storage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class AddExistTestParametrized extends BeforeTests {

    @Parameterized.Parameters()
    public static Collection<Object[]> setData(){
        return Arrays.asList(new Object[][]{
                {"pear", 2, true},
                {"orange", 1, true},
                {"mandarin", 6, true}} );}


    @Test
    public void AddExistObjectTest1(){
        int count = Storage.getProductAmount(data1);
        Storage.addToExistObject(data1, data2);
        assertEquals(Storage.getProductAmount(data1), count+data2);

    }
}
