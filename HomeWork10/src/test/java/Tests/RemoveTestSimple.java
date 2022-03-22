package Tests;

import digitalleague.storage_example.Storage;
import org.junit.Assert;
import org.junit.Test;

public class RemoveTestSimple extends BeforeTests {
    @Test
    public void removeTest1(){
        Storage.removeObject("apple");
        Assert.assertEquals(Storage.getProductAmount("apple"), 0);
}}
