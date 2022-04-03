package PageObject;


import com.codeborne.selenide.*;

import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.Collections;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.element;
import static java.time.temporal.ChronoUnit.SECONDS;

public class HomePage {
    private static HomePage homePage;

    //Контейнер страницы
    final String XPATH_HOME_PAGE = "//main[contains(@class, 'layout__content')]";
    //Контейнер шапки страницы
    final String XPATH_PAGE_HEADER = "//div[@class = 'nav-tabs']";
    final String XPATH_PRODUCT_DAY_CONTAINER = "//mvid-day-products-block[contains(@class, 'block')]";
    final String XPATH_PRODUCT_DAY = XPATH_PRODUCT_DAY_CONTAINER +"//mvid-day-product[contains(@class, 'main')]";

    @FindBy(xpath = XPATH_HOME_PAGE)
    public SelenideElement homePageList;
    @FindBy(xpath = "//mvid-simple-product-collection-mp[1]")
    public SelenideElement homePageCarousel1;
    @FindBy(xpath = "//mvid-simple-product-collection-mp[2]")
    public SelenideElement homePageCarousel2;

    //Самые просматриваемые
    final String XPATH_MOST_VIEWED = XPATH_HOME_PAGE + "//div//h2[text()='Самые просматриваемые']";
    @FindBy(xpath = XPATH_MOST_VIEWED)
    public SelenideElement mostViewed;
    //Кнопка "Статус заказа"
    @FindBy(xpath = XPATH_PAGE_HEADER + "//mvid-header-icon//a[@title ='Статус заказа']")
    public SelenideElement buttonOrderStatus;
    //Кнопка войти
    @FindBy(xpath = XPATH_PAGE_HEADER + "//mvid-header-icon//a[@title ='Личный кабинет']")
    public SelenideElement buttonInput;
    //Кнопка Сравнение
    @FindBy(xpath = XPATH_PAGE_HEADER + "//mvid-header-icon[@title = 'Сравнение']")
    public SelenideElement buttonCompare;
    //Кнопка Избранное
    @FindBy(xpath = XPATH_PAGE_HEADER + "//mvid-header-icon[@title ='Избранное']")
    public SelenideElement buttonFavourites;
    //Кнопка Корзина
   // @FindBy(xpath = XPATH_PAGE_HEADER + "//a[@title ='Корзина']")
    @FindBy(xpath = XPATH_PAGE_HEADER + "//mvid-header-icon[@title ='Корзина']")
    public SelenideElement buttonCart;
    //Кнопка Товары дня - "В корзину"
    @FindBy(xpath = XPATH_PRODUCT_DAY + "//button[contains(@class, 'mv-main-button--primary')]//span[text() = ' В корзину']")
    public SelenideElement productDayButton;

    //Блок Товар дня
   @FindBy(xpath = XPATH_PRODUCT_DAY_CONTAINER + "//span[text() = 'Товары дня']")
   public SelenideElement productDayBlock;

   //Название товара дня
    @FindBy(xpath = XPATH_PRODUCT_DAY + "//div[contains(@class, 'title')]//a")
    public SelenideElement nameProductDay;

    //Цена товара дня
    @FindBy(xpath = XPATH_PRODUCT_DAY +"//div[contains(@class, 'price--dailyProduct')]//span[@class='price__main-value']")
    public SelenideElement priceProductDay;


    //Количество товаров в корзине
    public SelenideElement newCountToCart = Selenide.$x("//a[@title ='Корзина']/mvid-bubble");

    //Строка поиска
    @FindBy (xpath = "//div[@class = 'input__container']//input[@class = 'input__field']")
    public SelenideElement searchLine;

    //Кнопка поиска в поисковой строке
    @FindBy (xpath = "//div[contains(@class, 'search-icon-wrap')]")
    public SelenideElement searchButton;

    /*Блок Самые просматриваемые*/
    final String XPATH_BLOCK_MOSTVIEWED = "//mvid-simple-product-collection-mp//h2[text() = 'Самые просматриваемые']";
    // кнопки Добавить в корзину
    @FindBy(xpath = XPATH_BLOCK_MOSTVIEWED + "/..//div[contains(@class, 'product-mini-card__controls')][1]//button[@title = 'Добавить в корзину']")
    public SelenideElement button1AddToCart;

    @FindBy(xpath = XPATH_BLOCK_MOSTVIEWED + "/..//div[contains(@class, 'product-mini-card__controls')][2]//button[@title = 'Добавить в корзину']")
    public SelenideElement button2AddToCart;

    //Коллекция наименований товаров в блоке Самые просматриваемые
    @FindBy(xpath = XPATH_BLOCK_MOSTVIEWED + "/..//div[contains(@class, 'product-mini-card__name')]//a//div")
    public ElementsCollection nameProducts;
    //Коллекция цен товаров
    @FindBy(xpath = XPATH_BLOCK_MOSTVIEWED + "/..//span[@class = 'price__main-value']")
    public ElementsCollection priceProducts;

    //Город
    @FindBy(xpath = "//div[contains(@class, 'app-header-top')]//span[contains(@class, 'top-navbar-link')]")
    public SelenideElement linkCity;

    //Активность элементов страницы
    public String enableElement(SelenideElement elementButton){
        return element(elementButton).getAttribute("class");
    }
    //Видимость элементов страницы
    public boolean visibleElement(SelenideElement elementButton){
        elementButton.shouldBe(Condition.visible);
        return element(elementButton).isDisplayed();
    }

    //Нажать на кнопку
    public void buttonClick(SelenideElement elementButton){
        elementButton.shouldBe(Condition.visible);
        elementButton.click();}

    public static HomePage getHomePage() {
        if (Objects.isNull(homePage)) homePage = Selenide.page(new HomePage());
        return homePage;
    }}



