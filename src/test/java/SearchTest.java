import helpers.Products;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pages.SearchPage;

import static io.qameta.allure.Allure.step;

@Epic("search")
@Owner("Ilgiz Gafarov")
@Feature("Тестирование функционала поиска")
@Tag("ui")
@DisplayName("Тестирование функционала поиска")
public class SearchTest extends TestBase {
    SearchPage searchPage = new SearchPage();

    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка поиска товара")

    @ParameterizedTest(name = "При поиске товара {0}")
    @EnumSource(Products.class)
    @Tag("smoke")
    void searchResultShouldContainTextTest(Products query) {
        step("Открыть главную страницу и заполнить поисковое поле {0}", () -> {
            mainPage.openPage()
                    .searchProducts(query.getProducts());
        });

        step("Убедиться, что поиск выдает верный результат {0}", () -> {
            searchPage.checkSearchResult(query.getProducts());
        });
    }
}