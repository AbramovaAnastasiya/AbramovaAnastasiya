package Tests;

import digitalleague.storage_example.Storage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertFalse;

    @RunWith(Parameterized.class)
    public class RemoveTestParametrized extends BeforeTests {

        @Parameterized.Parameters()
        public static Collection<Object[]> setData(){
            return Arrays.asList(new Object[][]{
                    {"apple", 0, true},
                    {"pear", 0, true},
                    {"kiwi", 0, true}} );}


//        @Test
//        public void removeTest1(){
//            Storage.removeObject("data");
//            Assert.assertEquals(Storage.getProductAmount("data"), 0);
//        }
        @Test
        public void removeTest2(){
            data2 = Storage.getFreePlaces();
            Storage.removeObject(data1);
            Assert.assertEquals(Storage.getFreePlaces(), data2+1);
        }

}
