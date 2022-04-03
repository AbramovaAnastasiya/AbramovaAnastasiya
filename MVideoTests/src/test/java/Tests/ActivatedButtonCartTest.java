package Tests;

import Steps.Steps;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ActivatedButtonCartTest extends Hooks {
    private Steps steps;

//    @BeforeClass
//    public static void setup() {
//        //Configuration.pageLoadTimeout = 40000;
//        Configuration.pageLoadStrategy = "eager";
//        Selenide.open("https://www.mvideo.ru/");
//        Configuration.pageLoadTimeout = 10000;}
//
//    @AfterClass
//    public static void teardown(){
//        Selenide.closeWebDriver();
//    }

    @Test
    public void testActivateCart(){
        Steps steps = new Steps();
        //Проверка отображения блока Товар дня
        Assert.assertTrue(steps.VisibleProductDay());
        //Нажать кнопку В корзину в блоке Товар дня
        steps.clickButtonAddToCartProductDay();
        Selenide.sleep(1000);
        //Проверить активность кнопки Корзина
        Assert.assertNotEquals(steps.EnabledButtonCart(), "disabled");
        //Проверить, что в корзине отображается 1
        Assert.assertEquals(steps.getCountInCart(), "1");
    }
}
