package Tests;

import digitalleague.storage_example.Storage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IsInStockTestParametrized extends BeforeTests {
    @Parameterized.Parameters()
    public static Collection<Object[]> setData(){
        return Arrays.asList(new Object[][]{
                {"pear",1, true},
                {"orange",1, false},
                {"pineapple",1, true},
                {"grapefruit",1, false}} );}
    @Test
    public void IsInStockTest(){
        Assert.assertEquals(Storage.isInStock(data1), result);
        System.out.printf("Object %s found.\n", data1);
    }
}
