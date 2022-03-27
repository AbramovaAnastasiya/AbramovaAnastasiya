import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SearchProductStep implements XpathContainers {

    private String productName;

    public SearchProductStep(String productName) {
        SelenideElement nextPage = $(byXpath("//div//li[@class='page-item']/a[contains(@class, 'ng-star-inserted')]"));
        SelenideElement productCardRow = $(byXpath("//div[@class='plp__card-grid']"));
        while ($(byText(productName)).isDisplayed() == false) {
            try {
                productCardRow.scrollIntoView("{behavior: \"smooth\", block: \"end\"}");
                $(byText(productName)).scrollIntoView("{block: \"center\"}");
                if ($(byText(productName)).isDisplayed() == true) break;
            } catch (ElementNotFound r) {
                nextPage.scrollIntoView(false);
                nextPage.click();
            }
        }
        $(byText(productName)).click();
    }

}





