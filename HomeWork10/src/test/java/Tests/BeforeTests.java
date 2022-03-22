package Tests;

import digitalleague.storage_example.Storage;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BeforeTests {
    @Before
    public void setUp(){
       // Storage.showAllStorage();
        Storage.addObject("apple", 5);
        Storage.addObject("pear", 7);
        Storage.addObject("orange", 3);
        Storage.addObject("mandarin", 10);
        Storage.addObject("lemon", 4);
    }

    @Parameterized.Parameter()
    public String data1;
    @Parameterized.Parameter(1)
    public int data2;
    @Parameterized.Parameter(2)
    public boolean result;

    @After
    public void remove(){
        Storage.removeAll();
    }
    @Category(TestCategory.class)
    @Test
    public void Test() {}


}
