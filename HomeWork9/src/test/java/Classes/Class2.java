package Classes;
import org.testng.Assert;
import org.testng.annotations.*;
public class Class2 {
    public int i;
    @BeforeClass
    public void bClass() {
        System.out.println("Before Class");
    }

    @Test(invocationCount = 2)
    public void test_1() {
        System.out.println("Test");
    }

    @Test
    public void test_2() {
        System.out.println("Test");
        System.out.println("Test data: 1 2");
        i =1;
    }

    @Test
    public void test_3() {
        System.out.println("Test");
        System.out.println("Test data: three four");
        i = 0;
    }

    @Test
    public void test_4() {
        System.out.println("Test");
        System.out.println("Test data: true false");
        //i=0;
    }
    @AfterMethod
    public void bMethod() {

        if (i == 1)
        {System.out.println("After Method");
    }}

    @AfterClass
    public void aSuite() {
        System.out.println("After Class");
    }

}
