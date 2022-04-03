package Tests;

import Steps.Steps;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AddToComparisonTest extends Hooks {
    private Steps steps;
//    @BeforeClass
//    public static void setup() {
//        Configuration.pageLoadStrategy = "eager";
//        //Configuration.pageLoadTimeout = 30000;
//        Selenide.open("https://www.mvideo.ru/");
//        Configuration.pageLoadTimeout = 10000;}
//
//    @AfterClass
//    public static void teardown(){
//        Selenide.closeWebDriver();
//    }

    @Test
    public void TestAddToCompare(){
        Steps steps = new Steps();
        //Проверка видимости строки поиска
        assert (steps.VisibleSearchLine());
        //Вводим "apple" в строку поиска
        steps.InputTextToSearchLine("apple");
        //Нажимаем кнопку поиска
        steps.clickSearchButton();
        Selenide.sleep(1000);
        //Проверяем, что открылась страница "https://www.mvideo.ru/product-list-page"
        assert(steps.OpenPageTest("https://www.mvideo.ru/product-list-page"));
        //Добавляем первые три товара в сравнение
        steps.addToComparison(1);
        steps.addToComparison(2);
        steps.addToComparison(3);
        //Сохранить имена добавляемых в сравнение товаров
        List<String> nameProductsInAppleList = new ArrayList<String>();
        nameProductsInAppleList.addAll(steps.getNameAppleProducts(3));
        //Нажимаем на кнопку "Сравнение"
        steps.clickButtonComparison();
        //Проверить url открытой страницы
        assert (steps.OpenPageTest("https://www.mvideo.ru/product-comparison"));
        //Проверить отображение заголовка "Сравнение товаров"
        assert (steps.visibleComparisonTitle());
        //Проверить карточки добавленных товаров
        Assert.assertEquals(nameProductsInAppleList, steps.getNameComparisonProducts());




    }
}
