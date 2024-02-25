import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.BasketPage;
import pages.MainPage;
import pages.ProductPage;
import pages.SearchPage;

public class TestBase {


    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    ProductPage productPage = new ProductPage();
    BasketPage basketPage = new BasketPage();

    @BeforeAll
    static void setUp() {

        Configuration.baseUrl = "https://shop.proamk.ru";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
    }

@AfterEach void afterEach(){
        Selenide.closeWebDriver();
    }
}
