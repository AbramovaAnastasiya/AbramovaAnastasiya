package Tests;

import Steps.Steps;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class SearchProductsTest extends Hooks {
    private Steps steps;
//    @BeforeClass
//    public static void setup() {
//         Configuration.pageLoadStrategy = "eager";
//        //Configuration.pageLoadTimeout = 30000;
//        Selenide.open("https://www.mvideo.ru/");
//        Configuration.pageLoadTimeout = 10000;}
//
//    @AfterClass
//    public static void teardown(){
//        Selenide.closeWebDriver();
//    }

    @Test
    public void SearchProducts(){
        Steps steps = new Steps();
        //Проверка видимости строки поиска
        assert (steps.VisibleSearchLine());
        //Вводим "apple" в строку поиска
        steps.InputTextToSearchLine("apple");
        //Нажимаем кнопку поиска
        steps.clickSearchButton();
        Selenide.sleep(500);
        //Проверяем, что открылась страница "https://www.mvideo.ru/product-list-page"
        assert(steps.OpenPageTest("https://www.mvideo.ru/product-list-page"));
        //Проверяем, что в списке только товары apple
        assert(steps.CheckingSearchLine());
    }
}
