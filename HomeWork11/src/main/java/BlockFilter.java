import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

public class BlockFilter implements XpathContainers {
    private SelenideElement filterContainer;
    private SelenideElement filterTitleCheckboxList;
    private SelenideElement filterSearchInput;
    private SelenideElement filterNameCheckboxElement;//

    public BlockFilter(String title, String filterName){
        //Заголовок Чекбокса
        String titleCheckboxList = String.format(XPATH_FILTER_CONTAINER + XPATH_TITLE_CHECKBOX_LIST, title);
        //Поиск значений
        String searchInput = String.format(titleCheckboxList + "/../following-sibling::div//mvid-input[@placeholder='Поиск значений']");
        filterSearchInput = Selenide.$x(searchInput);
        //Название чекбокса
        String filterNameCheckbox = String.format(titleCheckboxList + "/../following-sibling::div//div[@class = 'checkbox']//span/a[text() = ' %s ']", filterName);
        filterNameCheckboxElement = Selenide.$x(filterNameCheckbox);

    }
    //Все заголовки
    private ElementsCollection TitleCheckbox = Selenide.$$x(XPATH_FILTER_CONTAINER + "//span[contains(@class, 'accordion__title-text')]");
    //Все окошки "Поиск значений"
    private ElementsCollection allSearchInput = Selenide.$$x(XPATH_FILTER_CONTAINER +"//div//mvid-input[@placeholder='Поиск значений']");
    //Все названия
    private ElementsCollection allFilterCheckbox = Selenide.$$x(XPATH_FILTER_CONTAINER + "//div[@class = 'checkbox']//span/a[contains(@class, 'filter-name')]");
    //Все кнопки "Показать ещё"
    private ElementsCollection allButtonsShowAll = Selenide.$$x(XPATH_FILTER_CONTAINER + "//div//p[contains(@class, 'show-all')]");

    static BlockFilter getBlockFilter(String title, String filterName) {
        return new BlockFilter(title, filterName);}

    @Test
    public void Tests(){
        Selenide.open("https://www.mvideo.ru/holodilniki-i-morozilniki-2687/holodilniki-i-morozilnye-kamery-159?reff=menu_main");
        getBlockFilter("Категория", "Винные шкафы");
        System.out.println();
    }
}