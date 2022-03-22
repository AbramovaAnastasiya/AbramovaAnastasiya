package Tests;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.ExcludeCategory(TestCategory.class)
@Suite.SuiteClasses({
        BeforeTests.class,
        AddTestSimple.class,
        AddTestParametrized.class,
        AddNewTestSimple.class,
        AddNewTestParametrized.class,
        AddTestParametrized.class,
        AddExistTestParametrized.class,
        RemoveTestSimple.class,
        RemoveTestParametrized.class,
        IsInStockTestParametrized.class,
        GetFreePlacesTest.class
})

public class StorageSuiteTests {

}
