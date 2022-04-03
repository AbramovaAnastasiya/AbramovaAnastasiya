package Tests;

import PageObject.HomePage;
import Steps.Steps;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class HeaderPageTest extends Hooks {
    private HomePage homePage;
    private Steps steps;

//    @BeforeClass
//    public static void setup() {
//        Configuration.pageLoadStrategy = "eager";
//        //Configuration.pageLoadTimeout = 60000;
//        Selenide.open("https://www.mvideo.ru/");}
//
//    @AfterClass
//    public static void teardown(){
//    Selenide.closeWebDriver();
//}

    @Test
    public void testButtonToHeader(){
        Steps steps = new Steps();
        //Проверка активности/видимости кнопки Сравнение
        Assert.assertEquals(steps.EnableButtonCompare(), "disabled");
        Assert.assertTrue(steps.VisibleButtonCompare());
        //Проверка активности/видимости кнопки Статус заказа
        Assert.assertNotEquals(steps.EnabledButtonOrderStatus(), "disabled");
        Assert.assertTrue(steps.VisibleButtonOrderStatus());
        //Проверка активности/видимости кнопки Избранное
        Assert.assertEquals(steps.EnabledButtonFavourites(), "disabled");
        Assert.assertTrue(steps.VisibleButtonFavourites());
        //Проверка активности/видимости кнопки Войти
        Assert.assertNotEquals(steps.EnabledButtonInput(), "disabled");
        Assert.assertTrue(steps.VisibleButtonInput());
        //Проверка активности/видимости кнопки Корзина
        Assert.assertEquals(steps.EnabledButtonCart(), "disabled");
        Assert.assertTrue(steps.VisibleButtonCart());
    }
}
