package PageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class ModalWindowChangingCity {
    private static ModalWindowChangingCity modalWindowChangingCity;
    static final String XPATH_MODAL_WINDOW_CITY = "//div[contains(@class, 'modal-layout')]";
    @FindBy(xpath = XPATH_MODAL_WINDOW_CITY)
    public SelenideElement modalWindowCity;
    @FindBy(xpath = XPATH_MODAL_WINDOW_CITY +"/h3")
    public SelenideElement modalWindowCityTitle;
    @FindBy(xpath = "//ul[@class = 'location-select__location-list']")
    public SelenideElement locationList;


    public static ModalWindowChangingCity getModalWindowChangingCity() {
        if (Objects.isNull(modalWindowChangingCity)) modalWindowChangingCity = Selenide.page(new ModalWindowChangingCity());
        return modalWindowChangingCity;
    }
}
