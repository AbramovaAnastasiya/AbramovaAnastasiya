package Classes;

import org.testng.annotations.*;

public class Class1 {

    @BeforeSuite
    public void bSuite() {
        System.out.println("Before Suite");
    }

    @BeforeClass
    public void bClass() {
        System.out.println("Before Class");
    }

    @Test
    public void test_1() {
        System.out.println("Test");
    }

    @AfterMethod
    public void aMethod() {
        System.out.println("After Method");
    }

    @Test
    public void test_2() {
        System.out.println("Test");
        System.out.println("Test data: 1 2");
    }
    @Test
    public void test_3() {
    }

    @Test
    public void test_4() {
        System.out.println("Test");
        System.out.println("Test data: three four");}

    @Test
        public void test_5() {
            System.out.println("Test");
            System.out.println("Test data: true false");}

    @AfterSuite
    public void aSuite() {
        System.out.println("After Suite");
    }

}
