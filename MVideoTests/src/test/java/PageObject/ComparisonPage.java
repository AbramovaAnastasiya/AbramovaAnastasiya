package PageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class ComparisonPage {
    private static ComparisonPage comparisonPage;

    //Заголовок в сравнениях
    @FindBy(xpath = "//div[@class = 'c-compare-head-title']//h1")
    public SelenideElement titleComparisonPage;
    //Названия товаров
    @FindBy(xpath = "//div[contains(@class, 'c-compare-cell__pinable-product-tile')]//h3")
    public ElementsCollection nameComparisonProducts;

    public static ComparisonPage getComparisonPage() {
        if (Objects.isNull(comparisonPage)) comparisonPage = Selenide.page(new ComparisonPage());
        return comparisonPage;
}
}
