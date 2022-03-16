package Classes;

import org.testng.annotations.*;

public class Class4 {

    @BeforeTest()
    public void bTest(){
        System.out.println("Before Test");
    }

    @Test
    public void test_2(){
        System.out.println("Test");
    }

    @AfterMethod
    public void aMethod(){
        System.out.println("After Method");
    }
    @AfterTest
    public void aTest(){
        System.out.println("After Test");
    }

}
