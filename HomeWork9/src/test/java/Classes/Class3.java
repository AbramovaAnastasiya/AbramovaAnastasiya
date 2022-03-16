package Classes;
import org.testng.annotations.*;

public class Class3 {
    @Test
    public void test_1() {

    }

    @AfterClass
    public void aClass() {
        System.out.println("After Class");
    }

    @AfterTest
    public void aTest(){
        System.out.println("After Test");
    }

}
