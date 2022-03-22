package Tests;

import digitalleague.storage_example.Storage;
import org.junit.Assert;
import org.junit.Test;

public class GetFreePlacesTest extends BeforeTests {
@Test
    public void TestGetFreePlaces(){
    Storage.removeAll();
    Assert.assertEquals(Storage.getFreePlaces(), 8);
}
@Test
    public void TestGetFreePlaces1(){
    Storage.addObject("apple", 8);
    Assert.assertEquals(Storage.getFreePlaces(), 2);
}
}
