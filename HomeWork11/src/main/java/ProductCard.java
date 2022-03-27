import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

public class ProductCard {
    private SelenideElement titleLineContainer;
    private SelenideElement priceLabel;
    private SelenideElement addToCartButton;
    private SelenideElement addToFavoritesButton;
    private SelenideElement addToComparisonButton;
    private SelenideElement productPicture;
    private SelenideElement bonusLabel;

    public String productName;

    private final String XPATH_TITLE_LINE_CONTAINER = "//div[contains(@class, 'product-card__title-line-container')]";
    private final String XPATH_NESTED_NAME_LINK = "[mvid-plp-product-title[.//a[text() = ' %s ']]]";
    private final String XPATH_ALT_PICTURE = "/following-sibling::mvid-plp-product-picture/div//div//a/picture/img[contains(@alt,'%s')]";

    public ProductCard(String productName) {
        String titleContainerPath = String.format(XPATH_TITLE_LINE_CONTAINER + XPATH_NESTED_NAME_LINK, productName);
        titleLineContainer = Selenide.$x(titleContainerPath);
        priceLabel = Selenide.$x(titleContainerPath +
                "/following-sibling::div[contains(@class, 'product-card__price-block-container')]" +
               "//span[@class = 'price__main-value']");
        String followingSiblingProductCheckoutButtonsContainer = "/following-sibling::mvid-plp-product-checkout";
       addToCartButton = Selenide.$x(titleContainerPath +
                followingSiblingProductCheckoutButtonsContainer + "//button[span[text() = 'В корзину']]");
        addToFavoritesButton = Selenide.$x(titleContainerPath +
                followingSiblingProductCheckoutButtonsContainer + "//div[contains(@class, 'wishlist-button-block')]//button");
        addToComparisonButton = Selenide.$x(titleContainerPath +
                followingSiblingProductCheckoutButtonsContainer + "//div[contains(@class, 'compare-button-block')]//button");
        bonusLabel = Selenide.$x(titleContainerPath +"/following-sibling::div[contains(@class, 'product-card__mbonus-block-container')]" +
                "//span[@class = 'mbonus-block__value']");
        String pictureContainer = String.format(XPATH_TITLE_LINE_CONTAINER + XPATH_ALT_PICTURE, productName);
        productPicture = Selenide.$x(pictureContainer);
    }

        static ProductCard getProductCard(String productName) {
        return new ProductCard(productName);
    }

    private ElementsCollection allPriceLabel= Selenide.$$x("//div[contains(@class, 'product-card__price-block-container')]//span[@class = 'price__main-value']");
    private ElementsCollection allToCartButton = Selenide.$$x("//div//button[span[text() = 'В корзину']]");
    private ElementsCollection allBonusBlock = Selenide.$$x("//div[contains(@class, 'mbonus-block__caption')]");

    @Test
    public void Tests(){
        Selenide.open("https://www.mvideo.ru/holodilniki-i-morozilniki-2687/holodilniki-i-morozilnye-kamery-159?reff=menu_main");
        getProductCard("Морозильный ларь Novex ND063142AW");
        System.out.println();
    }}