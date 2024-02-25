package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProductPage {

    SelenideElement basket = $(byTagAndText("button", "В корзину")),
            productName = $(".product_title");;

    public String getNameFirstProduct() {
        return productName.getText();
    }

    public ProductPage addProductToBasket() {
        basket.click();
        return this;
    }



}
