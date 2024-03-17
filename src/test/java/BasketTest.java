import helpers.MainMenu;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.RetryingTest;
import pages.BasketPage;
import pages.MainPage;
import pages.ProductCategoryPage;
import pages.ProductPage;

import static io.qameta.allure.Allure.step;

@Epic("UI")
@Owner("Ilgiz Gafarov")
@Feature("Тестирование функционала корзины")
@Tag("basket")
@DisplayName("Тестирование функционала добавления и удаления товара")
public class BasketTest extends TestBase {
    ProductPage productPage = new ProductPage();
    BasketPage basketPage = new BasketPage();
    MainPage mainPage = new MainPage();
    ProductCategoryPage productCategoryPage = new ProductCategoryPage();

    @Severity(SeverityLevel.NORMAL)
    @RepeatedTest(10)
    @Story("Добавление товара в корзину с главной страницы")
    @DisplayName("Проверка добавления товара в корзину")
    void addProductToBasketTest() {
        step("Выбрать первый товар на главной странице", () ->
                mainPage.openPage()
                        .chooseFirstProductMainPage());
        step("В карточке товара, нажать на кнопку 'В корзину'", () -> {
            productPage.getNameFirstProduct();
            productPage.addProductToBasket();
        });

        step("Убедиться, что товар добавлен в корзину", () ->
                basketPage.checkProductName(productPage.getNameFirstProduct()));
    }


    @Flaky
    @RetryingTest(3)
    @Severity(SeverityLevel.NORMAL)
    @Story("Добавление товара в корзину")
    @DisplayName("Проверка добавления товара в корзину из главного меню")
    void addProductToBasketFromMainMenuTest() {
        step("Перейти к главной странице", () ->
                mainPage.openPage());

        step("Перейти в категорию 'Рабочие инмтрументы' из главного меню", () -> {
            mainPage.chooseCategoryFromMainMenu(MainMenu.TOOLS.getMainMenu());
            productCategoryPage.chooseFirstProduct();
        });

        step("В карточке товара, нажать на кнопку 'В корзину'", () -> {
            productPage.getNameFirstProduct();
            productPage.addProductToBasket();
        });

        step("Убедиться, что товар добавлен в корзину", () ->
                basketPage.checkProductName(productPage.getNameFirstProduct()));
    }

    @Flaky
    @Severity(SeverityLevel.NORMAL)
    @RetryingTest(3)
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

        step("Убедиться, что товар добавлен в корзину", () ->
                basketPage.checkProductName(productPage.getNameFirstProduct()));

        step("Нажать на кнопку удаления товара в корзине", () ->
                basketPage.deleteFromBasket());

        step("Убедиться, что корзина пуста", () ->
                basketPage.checkEmptyBasket());
    }
}
