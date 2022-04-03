package Tests;

import Steps.Steps;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoToCartTest extends Hooks {
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
    public void goToCart(){
        Steps steps = new Steps();
        assertTrue(steps.VisibleProductDay());
        //steps.VisibleClickButtonAddToCartProductDay();
        //Сохранить название товара
        String nameProductDay = steps.getNameProductDay();
        //Сохранить цену товара
        Integer priceProductDay = steps.getPriceProductDay();
        steps.clickButtonAddToCartProductDay();
        //Selenide.sleep(6000);
        steps.clickButtonCart();
        //Selenide.sleep(1000);
        //Проверка открылась страница /cart
        assertTrue(steps.OpenPageTest("https://www.mvideo.ru/cart"));
        //Проверка Отображается заголовок Моя корзина
        assertTrue(steps.VisibleTitleCart());
        //Проверка Наименование товара в корзине совпадает с именем добавленного товара.
        assertEquals(nameProductDay,steps.getNameProductInCart());
        //Проверка Отображается кнопка Перейти к оформлению
        assertTrue(steps.VisionButtonSetAnOrder());
        //Сумма в корзине совпадает с ценой из карточки товара дня
        assertEquals(priceProductDay, steps.getPriceProductInCart());
        //Отображается: "В корзине 1 товар"
        assertTrue(steps.VisibleCountProductInCart());
    }

}

