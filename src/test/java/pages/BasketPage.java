package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class BasketPage {

    private final SelenideElement productName = $(".xoo-wsc-pname"),
            totalPrice = $("span[class=\"xoo-wsc-ft-amt-value\"]"),
            deleteButton = $(".xoo-wsc-smr-del"),

    plus = $(".xoo-wsc-plus");

    public BasketPage checkProductName(String value) {
        productName.shouldBe(visible, Duration.ofSeconds(10)).shouldHave(Condition.text(value));
        return this;

    }

    public BasketPage addCountProduct() {
        plus.click();
        sleep(3000);
        return this;

    }

    public String getTotalPrice() {
        return totalPrice.getText().replaceAll(",", "").replace(".00 Р", "");

    }

    public BasketPage checkEmptyBasket() {
        productName.shouldNot(visible);
        return this;

    }

    public BasketPage deleteFromBasket() {
        deleteButton.click();
        return this;

    }

}
