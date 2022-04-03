package Tests;

import Steps.Steps;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SortInListingTest extends Hooks {
    private Steps steps;

//    @BeforeClass
//    public static void setup() {
//        Configuration.pageLoadStrategy = "eager";
//        Selenide.open("https://www.mvideo.ru/");
//        Configuration.pageLoadTimeout = 20000;}
//
//    @AfterClass
//    public static void teardown(){
//        Selenide.closeWebDriver();
//    }

    @Test
    public void SortInListing(){
        Steps steps = new Steps();
        //Проверка видимости строки поиска
        assert (steps.VisibleSearchLine());
        //Вводим "apple" в строку поиска
        steps.InputTextToSearchLine("apple");
        //Нажимаем кнопку поиска
        steps.clickSearchButton();
        Selenide.sleep(500);
        assert(steps.OpenPageTest("https://www.mvideo.ru/product-list-page"));
        //Проверяем, что в списке только товары apple
        assert(steps.CheckingSearchLine());
        //Проверяем, что в выпадающем списке "Сначала популярные"
        assert (steps.VisibleDropDown());
        //Устанавливаем значение "Сначала дороже" в выпадающий список
        steps.SetNewValueDropdown();
        //Проверяем, что цены товаров отсортированы по убыванию
        assert (steps.SortedPriceListPage());
    }
}
