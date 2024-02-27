import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("UI")
@Owner("Ilgiz Gafarov")
@Feature("Тестирование функционала корзины")
@Tag("ui")
@DisplayName("Тестирование функционала добавления и удаления товара")
public class BasketTest extends TestBase {

    private int count = 1;

    @Severity(SeverityLevel.NORMAL)
    @Test()
    @Story("Добавление товара в корзину")
    @DisplayName("Проверка добавления товара в корзину")
    void addProductToBasketTest() {
        step("Выбрать первый товар на главной странице", () ->
                mainPage.openPage()
                        .chooseFirstProductMainPage());
        step("В карточке товара, нажать на кнопку 'В корзину'", () -> {
            productPage.getNameFirstProduct();
            productPage.addProductToBasket();
        });

        step("Убедиться, что товар добавлен в корзину");
        basketPage.checkProductName(productPage.getNameFirstProduct());
    }

    @Severity(SeverityLevel.NORMAL)
    @Story("Увеличение количества товаров в корзине")
    @DisplayName("Проверка увеличения количества товара и цены в корзине.")
    @Test()
    void checkQuantityInBasketTest() {

        step("Добавить первый товар на главной странице в корзину", () ->
                mainPage.openPage()
                        .chooseFirstProductMainPage());
        productPage.addProductToBasket();

        step("Изменить количество товара на" + count + " в корзине");
        int a = Integer.parseInt(basketPage.getTotalPrice());
        basketPage.addCountProduct();

        step("Убедиться, что цена увеличилась в 2 раза");
        int b = Integer.parseInt(basketPage.getTotalPrice());

        assertEquals(2, b / a);

    }

    @Severity(SeverityLevel.NORMAL)
    @Test()
    @Story("Удаление товара из корзины")
    @DisplayName("Проверка удаления товара из корзины")
    void deleteItemFromBasketTest() {
        step("Выбрать первый товар на главной странице", () ->
                mainPage.openPage()
                        .chooseFirstProductMainPage());
        step("В карточке товара, нажать на кнопку 'В корзину'", () -> {
            productPage.getNameFirstProduct();
            productPage.addProductToBasket();
        });
        step("Убедиться, что товар добавлен в корзину");
        basketPage.checkProductName(productPage.getNameFirstProduct());

        step("Нажать на кнопку удаления товара в корзине");
        basketPage.deleteFromBasket();

        step("Убедиться, что корзина пуста");
        basketPage.checkEmptyBasket();
    }
}
