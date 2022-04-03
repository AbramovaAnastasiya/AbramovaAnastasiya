package PageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import com.codeborne.selenide.Condition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ProductListPageApple {
    private static ProductListPageApple productListPageApple;
    final String XPATH_PRODUCT_LIST_CONTAINER = "//mvid-product-cards-row[@class = 'ng-star-inserted']";
    @FindBy (xpath = XPATH_PRODUCT_LIST_CONTAINER)
    public SelenideElement productList;
    //Строки с карточками
    final String XPATH_PRODUCTS_ROW ="//div[contains(@class, 'product-cards-row')]";
    final String XPATH_PRODUCTS_ROW_NUM = XPATH_PRODUCTS_ROW + "[%s]";
    @FindBy (xpath = "//div[contains(@class, 'product-cards-row')]")
    public SelenideElement listingPage;

    public void scrollToProductsRow(int rowNum) {
        (Selenide.$x(String.format(XPATH_PRODUCTS_ROW_NUM, rowNum))).scrollTo();
    }
    public int getProductRowsCount() {
        return Selenide.$$x(XPATH_PRODUCTS_ROW).size();
    }

    public void productRowShouldBeVisible(int rowNum) {
        String xPath = String.format(XPATH_PRODUCTS_ROW_NUM + "//mvid-plp-product-title", rowNum);
        (Selenide.$x(xPath)).shouldBe(Condition.visible);
    }

  //Все названия товаров
    @FindBy (xpath = "//a[@class = 'product-title__text product-title--clamp']")
    public ElementsCollection productCardsName;

    //Все цены товаров на странице
    @FindBy(xpath = XPATH_PRODUCTS_ROW +"/..//span[@class = 'price__main-value']")
    public ElementsCollection productCardsPrice;

    public void scrollToPageList(){
        scrollToProductsRow(1);
        productRowShouldBeVisible(1);
        int count = getProductRowsCount();
        for (int i = 0; i < count; i++) {
            scrollToProductsRow(i + 1);
            productRowShouldBeVisible(i + 1);
    }
}
    //Получить список названий товаров
    public List<String> applePageListName(){
        scrollToPageList();
        List<String> productsCardsNameList = new ArrayList<>();
        for (int i = 0; i< productCardsName.size(); i++){
            productsCardsNameList.add(productCardsName.get(i).getText().toLowerCase());
        }
        return productsCardsNameList;
    }

    //Получить список цен товаров
    public List<Integer> applePageListPrice() {
        scrollToPageList();
        List<Integer> productsCardsPriceList = new ArrayList<>();
        for (int i = 0; i < productCardsPrice.size(); i++) {
            productsCardsPriceList.add(Integer.parseUnsignedInt(productCardsPrice.get(i).getText().replaceAll("\\D+", "")));
        }
        return productsCardsPriceList;}

    //Выпадающий список
    @FindBy(xpath ="//mvid-product-list-controls[contains(@class, 'list-controls')]//span")
    public SelenideElement dropDown;
    @FindBy(xpath ="//mvid-product-list-controls[contains(@class, 'list-controls')]//div[@class = 'dropdown__options']")
    public SelenideElement dropDownOptions;


    final String XPATH_PRODUCT_CARDS_CHECKOUT_1ROW = "//div[contains(@class, 'product-cards-row')][1]";
    //Добавить в сравнения
    final String XPATH_BUTTON_COMPARE = "//button[@title = 'Добавить в сравнение']";
    //Добавить в сравнения
    final String XPATH_BUTTON_FAVORITES = "//button[@title = 'Добавить в избранное']";

    //Кнопки в сравнение у товаров
    @FindBy(xpath = XPATH_PRODUCT_CARDS_CHECKOUT_1ROW + "//mvid-plp-product-checkout[contains(@class, 'product-card__checkout')][1]" + XPATH_BUTTON_COMPARE)
    public SelenideElement buttonCompare1;
    @FindBy(xpath = XPATH_PRODUCT_CARDS_CHECKOUT_1ROW + "//mvid-plp-product-checkout[contains(@class, 'product-card__checkout')][2]" + XPATH_BUTTON_COMPARE)
    public SelenideElement buttonCompare2;
    @FindBy(xpath = XPATH_PRODUCT_CARDS_CHECKOUT_1ROW + "//mvid-plp-product-checkout[contains(@class, 'product-card__checkout')][3]" + XPATH_BUTTON_COMPARE)
    public SelenideElement buttonCompare3;

    //Кнопки в Избранное
    @FindBy(xpath = XPATH_PRODUCT_CARDS_CHECKOUT_1ROW + "//mvid-plp-product-checkout[contains(@class, 'product-card__checkout')][1]" + XPATH_BUTTON_FAVORITES)
    public SelenideElement buttonFavorites1;
    @FindBy(xpath = XPATH_PRODUCT_CARDS_CHECKOUT_1ROW + "//mvid-plp-product-checkout[contains(@class, 'product-card__checkout')][2]" + XPATH_BUTTON_FAVORITES)
    public SelenideElement buttonFavorites2;
    @FindBy(xpath = XPATH_PRODUCT_CARDS_CHECKOUT_1ROW + "//mvid-plp-product-checkout[contains(@class, 'product-card__checkout')][3]" + XPATH_BUTTON_FAVORITES)
    public SelenideElement buttonFavorites3;

    //Количество товаров в сравнении
    public SelenideElement newCountToComparison = Selenide.$x("//a[@title ='Сравнение']//mvid-bubble");

    //Количество товаров в избранном
    public SelenideElement newCountToFavorites = Selenide.$x("//a[@title ='Избранное']//mvid-bubble");


    public static ProductListPageApple getProductListPage() {
        if (Objects.isNull(productListPageApple)) productListPageApple = Selenide.page(new ProductListPageApple());
        return productListPageApple;
    }

}
