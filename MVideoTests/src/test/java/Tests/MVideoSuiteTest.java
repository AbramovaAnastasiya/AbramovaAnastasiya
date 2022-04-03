package Tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        HeaderPageTest.class,
        ActivatedButtonCartTest.class,
        GoToCartTest.class,
        AddProductToCart.class,
        SearchProductsTest.class,
        SortInListingTest.class,
        ModalWindowTest.class,
        AddToComparisonTest.class,
        AddToFavoritesTest.class,
        ChangingTheCityTest.class
})

public class MVideoSuiteTest {
}
