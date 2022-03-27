import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

public class Tests{

    //private SearchProductStep steps = new SearchProductStep("Холодильник Bosch Serie 4 VitaFresh KGN39XL27R");

    @Test
    public void Tests(){
        Selenide.open("https://www.mvideo.ru/holodilniki-i-morozilniki-2687/holodilniki-i-morozilnye-kamery-159?reff=menu_main");
       // step.getSearchProduct("Холодильник Bosch Serie 4 VitaFresh KGN39XL27R");
       // SearchProductStep.getSearchProduct("Холодильник Bosch Serie 4 VitaFresh KGN39XL27R");
        Selenide.sleep(1000);
}
}
