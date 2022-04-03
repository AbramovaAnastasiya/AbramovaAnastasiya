package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class CartPage {
    private static CartPage cartPage;
    //Контейнер корзины
    final String XPATH_CONTAINER_CART = "//div[@class = 'main-holder']";
    //Заголовок в корзине
    final String XPATH_TITLE_CART = XPATH_CONTAINER_CART + "//span[text() = 'Моя корзина']";
    @FindBy(xpath = XPATH_TITLE_CART)
    public SelenideElement titleCart;

    //Название товара в корзине
    @FindBy(xpath = XPATH_CONTAINER_CART + "//div[@class = 'c-cart-item__wrapper ']//div[@class = 'c-cart-item__header']/a[contains(@class, c-link)]")
    public SelenideElement nameProductInCart;

    //Цена товара в корзине
    @FindBy(xpath = XPATH_CONTAINER_CART +"//div[@class = 'c-cost-line__text-wrap']//span[@class = 'c-cost-line__text']")
    public SelenideElement priceProductInCart;

    //Кнопка "Перейти к оформлению"
    @FindBy(xpath = XPATH_CONTAINER_CART + "//input[@value = 'Перейти к оформлению']")
    public SelenideElement setAnOrderButton;

    //Количество товаров в корзине
    @FindBy(xpath = "//div[@class = 'c-cost-line__title-wrap']//span[@class = 'c-cost-line__title']")
    public SelenideElement countProductInCart;

    //Наименования всех товаров в корзине
    final String XPATH_PRODUCTS_IN_CART = "//div[contains(@class, 'o-checkout__step')][contains(@class, 'u-pt-4')]";
    @FindBy(xpath = XPATH_PRODUCTS_IN_CART + "//a[contains(@class,'c-cart-item__title')]")
    public ElementsCollection nameProducts;
    //Цены всех товаров корзине
    @FindBy(xpath = XPATH_PRODUCTS_IN_CART + "//span[@class = 'c-cart-item__price']")
    public ElementsCollection priceProducts;

    //Подождать видимость элемента
    public void shouldBeVisible(SelenideElement element) {
        element.shouldBe(Condition.visible);
    }

    public static CartPage getCartPage() {
        if (Objects.isNull(cartPage)) cartPage = Selenide.page(new CartPage());
        return cartPage;
    }
}
