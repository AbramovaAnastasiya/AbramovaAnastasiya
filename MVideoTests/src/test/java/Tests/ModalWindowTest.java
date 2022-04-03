package Tests;

import Steps.Steps;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ModalWindowTest extends Hooks {
    private Steps steps;
//    @BeforeClass
//    public static void setup() {
//        Configuration.pageLoadStrategy = "eager";
//        //Configuration.pageLoadTimeout = 30000;
//        Selenide.open("https://www.mvideo.ru/");
//        Configuration.pageLoadTimeout = 10000;}
//
//    @AfterClass
//    public static void teardown(){
//        Selenide.closeWebDriver();
//    }

    @Test
    public void TestModalWindow(){
        Steps steps = new Steps();
        //Нажать кнопку Войти
        steps.clickButtonInput();
        //Проверка видимости кнопки закрыть в модульном окне
        assert (steps.VisibleButtonExit());
        //Проверка отображения модального окна с заголовком Вход или регистрация
        assert (steps.VisibleWindowAuthorization());
        //Проверка отображения поля для ввода текста с плейсхолдером “Телефон”
        assert (steps.VisibleFormInput());
        //Проверка отображения и неактивности кнопки Продолжить
        assert (steps.VisibleButtonContinue() && !steps.EnabledButtonContinue());
        //Проверка отображения ссылки для юр. лиц
        assert (steps.visibleLinkLoginForm());






    }
}
