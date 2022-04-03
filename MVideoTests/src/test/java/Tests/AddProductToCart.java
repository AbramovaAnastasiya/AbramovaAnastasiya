package Tests;

import Steps.Steps;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class AddProductToCart extends Hooks {
    private Steps steps;
//    @BeforeClass
//    public static void setup() {
//        Configuration.pageLoadStrategy = "eager";
//        //Configuration.pageLoadTimeout = 30000;
//        Selenide.open("https://www.mvideo.ru/");
//        Configuration.pageLoadTimeout = 10000;}
//
//    @AfterClass
//    public static void teardown(){Selenide.closeWebDriver();}

    @Test
        public void AddNewProductToCart(){
        Steps steps = new Steps();
        //Проверить отображение блока Самые просматриваемые
        assert(steps.VisibleMostViewed());
        Selenide.sleep(500);
        //Добавить первые два товара в блоке в корзину
        steps.MastViewedClickButton(1);
        steps.MastViewedClickButton(2); 
        //Сохранить имена и сумму добавляемых в корзину продуктов
        List<String> nameProductsInMastViewed = new ArrayList<String>();
        nameProductsInMastViewed.addAll(steps.CollectionNameProductsInMastViewed(2));
        Integer sumPrice = steps.SumPriceProductsInMastViewed(2);
        //Перейти на страницу "https://www.mvideo.ru/cart"
        Selenide.open("https://www.mvideo.ru/cart");
        //steps.clickButtonCart();
        Selenide.sleep(500);
        //Проверить соответствие добавляемых названий продуктов с названиями в корзине
        Assert.assertTrue (nameProductsInMastViewed.equals(steps.CollectionNameProductsInCart(2)));
        //Проверить сумму
        Assert.assertEquals(sumPrice, steps.SumPriceProductsInCart(2));

}

}
