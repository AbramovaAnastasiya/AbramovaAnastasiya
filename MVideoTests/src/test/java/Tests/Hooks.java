package Tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class Hooks {
    @BeforeClass
    public static void setup() {
        Configuration.pageLoadTimeout = 60000;
        // Configuration.pageLoadStrategy = "eager";
        Selenide.open("https://www.mvideo.ru/");
    }

    @AfterClass
    public static void teardown() {
        Selenide.closeWebDriver();
    }
}


//    @Test
//    public void Test(){}
//
//}
