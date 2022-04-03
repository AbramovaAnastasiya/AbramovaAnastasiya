package PageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class FavoritesPage {
    private static FavoritesPage favoritesPage;
    //Заголовок
    @FindBy(xpath = "//div[@class = 'page-container']//h1")
    public SelenideElement titleFavoritesPage;
    //Названия товаров
    @FindBy(xpath = "//div[@class = 'wishlist-item-holder']//h3/a")
    public ElementsCollection nameFavoritesProducts;

    public static FavoritesPage getFavoritesPage() {
        if (Objects.isNull(favoritesPage)) favoritesPage = Selenide.page(new FavoritesPage());
        return favoritesPage;
    }
}
