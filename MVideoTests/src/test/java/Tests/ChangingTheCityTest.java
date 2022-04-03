package Tests;

import Steps.Steps;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ChangingTheCityTest extends Hooks {
    private Steps steps;
//    @BeforeClass
//    public static void setup() {
//        Configuration.pageLoadStrategy = "eager";
//        Selenide.open("https://www.mvideo.ru/");
//        Configuration.pageLoadTimeout = 10000;}
//
//    @AfterClass
//    public static void teardown(){
//        Selenide.closeWebDriver();
//    }

    @Test
    public void TestChangingTheCity(){
        Steps steps = new Steps();
        //Нажимам ссылку c текущим городом
        steps.clickLinkCity();
        //Проверка отображения модального окна "Выберите город"
        assert (steps.visibleModalWindowCity());
        //Нажимаем строку с городом Краснодар
        steps.setNewCity("Краснодар");
        Selenide.sleep(1000);
        //Проверка отображения модального окна "Выберите город"
        Assert.assertFalse(steps.visibleModalWindowCity());
        //Проверка - в хедере отображается выбранный город
        assert (steps.visibleNewCity("Краснодар"));



    }
}
