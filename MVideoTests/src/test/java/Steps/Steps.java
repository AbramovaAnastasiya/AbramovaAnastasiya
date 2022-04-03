package Steps;

import PageObject.*;
import Tests.SortInListingTest;
import com.codeborne.selenide.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class Steps {
    private HomePage homePage;
    private CartPage cartPage;
    private ProductListPageApple productListPageApple;
    private SortInListingTest sortInListingTest;
    private ModalWindowPage modalWindowPage;
    private ComparisonPage comparisonPage;
    private FavoritesPage favoritesPage;
    private ModalWindowChangingCity modalWindowChangingCity;
    private List<String> ProductsCards;


    public Steps() {
        homePage = HomePage.getHomePage();
        cartPage = CartPage.getCartPage();
        productListPageApple = ProductListPageApple.getProductListPage();
        modalWindowPage = ModalWindowPage.getModalWindowPage();
        comparisonPage = ComparisonPage.getComparisonPage();
        favoritesPage = FavoritesPage.getFavoritesPage();
        modalWindowChangingCity = ModalWindowChangingCity.getModalWindowChangingCity();
    }

    /*Блок HomePage*/
    //Активность/видимость кнопки "Сравнение"
    public String EnableButtonCompare() {
        return homePage.enableElement(homePage.buttonCompare);
    }
    public boolean VisibleButtonCompare() {
        return homePage.visibleElement(homePage.buttonCompare);}

    //Активность/видимость кнопки "Статус заказа"
    public String EnabledButtonOrderStatus() {
        return homePage.enableElement(homePage.buttonOrderStatus);}
    public boolean VisibleButtonOrderStatus() {return homePage.visibleElement(homePage.buttonOrderStatus);}

    //Активность/видимость кнопки "Избранное"
    public String EnabledButtonFavourites() {return homePage.enableElement(homePage.buttonFavourites);}
    public boolean VisibleButtonFavourites() {return homePage.visibleElement(homePage.buttonFavourites);}

    //Активность/видимость кнопки "Войти"
    public String EnabledButtonInput() {return homePage.enableElement(homePage.buttonInput);}
    public boolean VisibleButtonInput() {
        return homePage.visibleElement(homePage.buttonInput);
    }

    //Активность/видимость кнопки "Корзина"
    public String EnabledButtonCart() {
        //homePage.newCountToCart.shouldBe(Condition.visible);
        return homePage.enableElement(homePage.buttonCart);
    }
    public boolean VisibleButtonCart() {return homePage.visibleElement(homePage.buttonCart);}

    //Нажать кнопку "Корзина"
    public void clickButtonCart() {
        homePage.buttonClick(homePage.buttonCart);
    }

    //Видимость блока Продукт Дня
    public boolean VisibleProductDay() {
        return homePage.visibleElement(homePage.productDayBlock);
    }

    //Видимость кнопки "В корзину" у товара дня
    public boolean VisibleClickButtonAddToCartProductDay() {
        return homePage.visibleElement(homePage.productDayButton);
    }

    //Нажать "В корзину" продукт дня
    public void clickButtonAddToCartProductDay() {
        homePage.buttonClick(homePage.productDayButton);
        homePage.newCountToCart.shouldBe(Condition.visible);
        Configuration.pageLoadTimeout = 30000;
        //  homePage.buttonCart.shouldBe(Condition.enabled);
    }

    //Получить название товара дня
    public String getNameProductDay() {
        homePage.nameProductDay.shouldBe(Condition.visible);
        return homePage.nameProductDay.getText();
    }

    //Получить цену товара дня
    public Integer getPriceProductDay() {
        homePage.priceProductDay.shouldBe(Condition.visible);
        return Integer.parseUnsignedInt(homePage.priceProductDay.getText().replaceAll("\\D+", ""));
    }

    //Получить кол-во в корзине
    public String getCountInCart() {
        return homePage.newCountToCart.getText();
    }


    //Отображается блок "Самые просматриваемые"
    public boolean VisibleMostViewed() {
        homePage.homePageCarousel1.shouldBe(Condition.visible);
        homePage.homePageCarousel1.scrollTo();
        if (homePage.homePageCarousel1.getText().contains("Самые просматриваемые"))
            return homePage.homePageCarousel1.isDisplayed();
        else
            homePage.homePageCarousel2.scrollTo();
        return homePage.homePageCarousel2.isDisplayed();
    }

    //Нажать на кнопку корзина у первых 2х товаров в блоке
    public void MastViewedClickButton(int j) {
        if (j == 1) {
            homePage.button1AddToCart.click();
            homePage.newCountToCart.shouldHave(Condition.text("1"));
        } else if (j == 2) {
            homePage.button2AddToCart.click();
            homePage.newCountToCart.shouldHave(Condition.text("2"));
        }
    }

    //наименования товаров в самых просматриваемых
    public List<String> CollectionNameProductsInMastViewed(int count) {
        List<String> nameProductsHomePage = new ArrayList<>();
        for (int i = 0; i < count; i++)
            nameProductsHomePage.add(homePage.nameProducts.get(i).getText());
        Collections.sort(nameProductsHomePage);
        return nameProductsHomePage;
    }

    //Цены товаров в самых просматриваемых
    public Integer SumPriceProductsInMastViewed(int count) {
        List<String> priceProductsHomePage = new ArrayList<>();
        Integer sum = 0;
        for (int i = 0; i < count; i++) {
            priceProductsHomePage.add(homePage.priceProducts.get(i).getText());
            sum = sum + Integer.parseUnsignedInt(priceProductsHomePage.get(i).replaceAll("\\D+", ""));
            // Collections.sort(nameProductsHomePage);
        }
        return sum;
    }

    //Видимость поисковой строки
    public boolean VisibleSearchLine() {
        return homePage.visibleElement(homePage.searchLine);
    }

    //Ввод текста в поисковую строку
    public void InputTextToSearchLine(String nameProduct) {
        homePage.searchLine.clear();
        homePage.searchLine.sendKeys(nameProduct);
    }

    //Нажать кнопку поиска
    public void clickSearchButton() {
        homePage.buttonClick(homePage.searchButton);
        productListPageApple.productList.shouldBe(Condition.visible);
        //homePage.homePageList.shouldHave(Condition.text("Найден"));
        //Configuration.pageLoadTimeout = 10000;
    }
    /*Product-list-page-Apple*/
    //Проверить совпадение со строкой поиска
    public boolean CheckingSearchLine() {
        ProductsCards = productListPageApple.applePageListName();
        int sum = 0;
        for (int i = 0; i < ProductsCards.size(); i++) {
            if (ProductsCards.get(i).contains("apple"))
                sum = sum + 1;
        }
        if (sum == ProductsCards.size()) {
            homePage.homePageList.scrollIntoView(true);
            productListPageApple.productRowShouldBeVisible(1);
            return true;
        } else return false;
    }

    //Видимость выпадающего списка со значением "Сначала популярные"
    public boolean VisibleDropDown() {
        productListPageApple.dropDown.shouldBe(Condition.visible);
        if (productListPageApple.dropDown.getText().equals("Сначала популярные"))
            return true;
        else return false;
    }

    //Выбираем значение выпадающего списка
    public void SetNewValueDropdown() {
        productListPageApple.dropDown.click();
        productListPageApple.dropDownOptions.find(withText("Сначала дороже")).click();
    }

    //Проверка сортировки цен
    public boolean SortedPriceListPage() {
        List<Integer> productPrice = productListPageApple.applePageListPrice();
        Collections.sort(productListPageApple.applePageListPrice(), Collections.reverseOrder());
        if (productListPageApple.applePageListPrice().equals(productPrice))
            return true;
        else return false;
    }

    //Проверить url текущей страницы
    public boolean OpenPageTest(String url) {
        //Configuration.pageLoadTimeout = 10000;
        Configuration.pageLoadStrategy = "eager";
        sleep(500);
        //Configuration.pageLoadTimeout = 10000;
        if (WebDriverRunner.url().equals(url)){
            Configuration.pageLoadTimeout = 10000;
            return true;
        }
        else if (WebDriverRunner.url().contains(url))
            return true;
        else return false;
    }

    //Степы для корзины
    //Видимость заголовка в корзине
    public boolean VisibleTitleCart() {
        cartPage.titleCart.shouldBe(Condition.visible);
        return (cartPage.titleCart.isDisplayed());
    }
    //Отображается количество в Корзине
    public boolean VisibleCountProductInCart() {
        cartPage.countProductInCart.shouldBe(Condition.visible);
        return cartPage.countProductInCart.isDisplayed();
    }
    //Получить название товара в корзине
    public String getNameProductInCart() {
        return cartPage.nameProductInCart.getText();
    }

    //Получить цену товара в корзине
    public Integer getPriceProductInCart() {
        return Integer.parseInt(cartPage.priceProductInCart.getText().replaceAll("\\D+", ""));
    }

    //наименования товаров в корзине
    public List<String> CollectionNameProductsInCart(int count) {
        List<String> nameProductsCart = new ArrayList<>();
        for (int i = 0; i < count; i++)
            nameProductsCart.add(cartPage.nameProducts.get(i).getText());
        Collections.sort(nameProductsCart);
        return nameProductsCart;
    }
    //Сумма цен товаров в корзине
    public Integer SumPriceProductsInCart(int count) {
        List<String> priceProductsCart = new ArrayList<>();
        Integer sum = 0;
        for (int i = 0; i < count; i++) {
            priceProductsCart.add(cartPage.priceProducts.get(i).getText());
            sum = sum + Integer.parseUnsignedInt(priceProductsCart.get(i).replaceAll("\\D+", ""));
        }
        return sum;
    }

    //Видимость кнопки "Проверить заказ"
    public boolean VisionButtonSetAnOrder() {
        cartPage.setAnOrderButton.shouldBe(Condition.visible);
        return (cartPage.setAnOrderButton.isDisplayed());
    }

    //Нажимаем кнопку "Войти"
    public void clickButtonInput() {
        homePage.buttonClick(homePage.buttonInput);
    }

    /*Блок модальное окно авторизации*/
    //Видимость кнопки закрыть мод. окно
    public boolean VisibleButtonExit() {
        modalWindowPage.buttonExit.shouldBe(Condition.visible);
        if (modalWindowPage.buttonExit.isDisplayed()) return true;
        else return false;
    }

    //Видимость окна авторизации с текстом Вход или регистрация
    public boolean VisibleWindowAuthorization() {
        return modalWindowPage.visibleElement(modalWindowPage.titleWindowAuthorization, "Вход или регистрация");
    }
    //Видимость поля ввода с плейсхолдером
    public boolean VisibleFormInput() {
        return modalWindowPage.visibleElement(modalWindowPage.formInput, "Телефон");
    }
    //Видимость кнопки Продолжить
    public boolean VisibleButtonContinue(){
        return modalWindowPage.visibleElement(modalWindowPage.buttonTitleContinue, "Продолжить");}

    //Неактивность кнопки Продолжить
    public boolean EnabledButtonContinue(){
        if (modalWindowPage.buttonContinue.getAttribute("disabled").equals("true"))
            return false;
        else return true;
    }
    //Видимость ссылки для юр. лиц
    public boolean visibleLinkLoginForm(){
        return modalWindowPage.visibleElement(modalWindowPage.loginFormLink, "Для юридических лиц");
    }

    /*Блок добавление в сравнения*/

    //Отображение заголовка Избранное
    public boolean visibleComparisonTitle(){
        comparisonPage.titleComparisonPage.shouldBe(Condition.visible);
        if (comparisonPage.titleComparisonPage.getText().contains("Сравнение товаров"))
            return true;
        else return false;
    }
    //Нажать на кнопку Сравнение у первых 3х товаров в блоке
    public void addToComparison(int numButton) {
            if (numButton == 1){
                productListPageApple.buttonCompare1.click();
                productListPageApple.newCountToComparison.shouldHave(Condition.text("1"));
            }
            else
            if (numButton == 2){
                productListPageApple.buttonCompare2.click();
                productListPageApple.newCountToComparison.shouldHave(Condition.text("2"));
            }
            else
            if (numButton == 3){
                productListPageApple.buttonCompare3.click();
                productListPageApple.newCountToComparison.shouldHave(Condition.text("3"));
            }
        }

    //Нажать кнопку сравнение
    public void clickButtonComparison(){homePage.buttonClick(homePage.buttonCompare);}

    //Нажать кнопку Избранное
    public void clickButtonFavorites(){homePage.buttonClick(homePage.buttonFavourites);}

    //Получить названия первых count названий товаров в листинге Apple
    public List<String> getNameAppleProducts(int count) {
        List<String> nameProductsApple = new ArrayList<>();
        for (int i = 0; i < count; i++)
            nameProductsApple.add(productListPageApple.productCardsName.get(i).getText());
        Collections.sort(nameProductsApple);
        return nameProductsApple;
    }

    //Получить названия товаров в Сравнении
    public List<String> getNameComparisonProducts() {
        List<String> nameProductsInComparison = new ArrayList<>();
        for (int i = 0; i < comparisonPage.nameComparisonProducts.size(); i++)
            nameProductsInComparison.add(comparisonPage.nameComparisonProducts.get(i).getText());
        Collections.sort(nameProductsInComparison);
        return nameProductsInComparison;

    }

    /*Блок добавление в избранное*/
    //Нажать на кнопку в Избранное у первых 3х товаров в блоке
    public void addToFavorites(int numButton) {
        if (numButton == 1){
            productListPageApple.buttonFavorites1.click();
            productListPageApple.newCountToFavorites.shouldHave(Condition.text("1"));
        }
        else
        if (numButton == 2){
            productListPageApple.buttonFavorites2.click();
            productListPageApple.newCountToFavorites.shouldHave(Condition.text("2"));
        }
        else
        if (numButton == 3){
            productListPageApple.buttonFavorites3.click();
            productListPageApple.newCountToFavorites.shouldHave(Condition.text("3"));
        }
    }
    //Отображение заголовка Избранное
    public boolean visibleFavoritesTitle(){
        favoritesPage.titleFavoritesPage.shouldBe(Condition.visible);
        if (favoritesPage.titleFavoritesPage.getText().contains("Избранное"))
            return true;
        else return false;
    }

    //Получить названия товаров в Избранных
    public List<String> getNameFavoritesProducts() {
        List<String> nameProductsInFavorites = new ArrayList<>();
        for (int i = 0; i < favoritesPage.nameFavoritesProducts.size(); i++)
            nameProductsInFavorites.add(favoritesPage.nameFavoritesProducts.get(i).getText());
        Collections.sort(nameProductsInFavorites);
        return nameProductsInFavorites;

    }

    /*Изменение города*/
    public void clickLinkCity(){
        homePage.buttonClick(homePage.linkCity);
    }

    //Отображение модального окна с текстом "Выберите город"
    public boolean visibleModalWindowCity(){
        //modalWindowChangingCity.modalWindowCity.shouldBe(Condition.visible);
        if ((modalWindowChangingCity.modalWindowCity.isDisplayed())&&
        (modalWindowChangingCity.modalWindowCityTitle.getText().equals("Выберите город")))
            return true;
        else return false;
    }

    //Выбор города в модальном окне
    public void setNewCity(String nameCity){
        modalWindowChangingCity.locationList.find(withText(nameCity)).click();
    }

    //Отображение города в хедере
    public boolean visibleNewCity(String nameCity){
        homePage.linkCity.shouldHave(Condition.text(nameCity));
        if (homePage.linkCity.getText().equals(nameCity))
            return true;
        else return false;

    }
}

