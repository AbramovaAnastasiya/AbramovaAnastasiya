package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class ModalWindowPage {
    private static ModalWindowPage modalWindowPage;

    final String XPATH_MODAL_WINDOW_AUTHORIZATION = "//div[contains(@class, 'modal-layout--without-title')]";
    @FindBy(xpath = XPATH_MODAL_WINDOW_AUTHORIZATION )
    public SelenideElement modalWindowAuthorization;

    @FindBy(xpath = "//mvid-login-form-top-nav[@formview = 'PHONE_VIEW']/button[contains(@class, 'login-form-top-nav')]")
    public SelenideElement buttonExit;

    @FindBy(xpath = XPATH_MODAL_WINDOW_AUTHORIZATION + "//h2")
    public SelenideElement titleWindowAuthorization;

    @FindBy(xpath = "//div[@class = 'form-field__input-overlay']//span")
    public SelenideElement formInput;

    final String XPATH_BUTTON_CONTINUE = "//button[contains(@class, 'login-form__button')]";
    @FindBy(xpath = XPATH_BUTTON_CONTINUE)
    public SelenideElement buttonContinue;

    @FindBy(xpath = XPATH_BUTTON_CONTINUE + "//div[@class = 'mv-main-button--content']")
    public SelenideElement buttonTitleContinue;

    @FindBy(xpath =  "//button[contains(@class, 'login-form__link')]")
    public SelenideElement loginFormLink;

    //Отображение элементов и проверка текста на них
    public boolean visibleElement(SelenideElement element, String text){
        element.shouldBe(Condition.visible);
        if (element.getText().equals(text))
            return true;
        else return false;
    }

    public static ModalWindowPage getModalWindowPage() {
        if (Objects.isNull(modalWindowPage)) modalWindowPage = Selenide.page(new ModalWindowPage());
        return modalWindowPage;
    }
}
