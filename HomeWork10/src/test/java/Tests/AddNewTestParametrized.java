package Tests;

import digitalleague.storage_example.Storage;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AddNewTestParametrized {
    @Parameterized.Parameter()
    public String data1;
    @Parameterized.Parameter(1)
    public int data2;
    @Parameterized.Parameters()
    public static Collection<Object[]> setData(){
        return Arrays.asList(new Object[][]{
                {"apple", 5},
                {"pear", 7},
                {"orange", 3},
                {"mandarin", 10},
                {"lemon", 4},
                {"kiwi", 5},
                {"pineapple", 11},
                {"banana", 8,},
                {"kiwi", 1},
                {"lime", 6},
                {"melon", 6},
                {"coconut", 5}} );}
//    @Test
//    public void addNewObjectTest(){
//        assertTrue(Storage.addNewObject(data1, data2));
//    }
@Test
public void addNewObjectTest1(){
    assertNotEquals(Storage.getFreePlaces(), 0);
    Storage.addNewObject(data1,data2);
    Storage.showAllStorage();
}

//@Test
//    public void AddNewObjectTest1(){
//        int count = Storage.getFreePlaces();
//        Storage.addNewObject(data1, data2);
//        assertEquals(Storage.getFreePlaces(), count-1);
//
//    }
    @AfterClass
    public static void clear(){
        Storage.removeAll();
    }

}
