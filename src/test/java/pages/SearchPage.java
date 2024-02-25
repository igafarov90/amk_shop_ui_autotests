package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {

    SelenideElement product = $(".woocommerce-LoopProduct-link");

    public SearchPage checkSearchResult(String value) {
        product.shouldHave(Condition.text(value));
        return this;
    }
}
