import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;
import static helpers.MainMenu.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("UI")
@Owner("Ilgiz Gafarov")
@Feature("Проверка страниц из меню навигации")
@Tag("ui")
@DisplayName("Тестирование функционала страниц из меню навигации")
public class MainMenuTest extends TestBase {

    @Test
    @Tag("smoke")
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка главного меню")
    @DisplayName("Проверка элементов главного меню")
    void checkMainMenuTest() {
        step("Проверить наличие элементов главного меню, на главной странице", () -> {
            mainPage.openPage();
            mainPage.checkMainMenu(PAPER_PRODUCTS.getMainMenu());
            mainPage.checkMainMenu(PRIMER.getMainMenu());
            mainPage.checkMainMenu(BABY_CLOTHES.getMainMenu());
            mainPage.checkMainMenu(GLUE.getMainMenu());
            mainPage.checkMainMenu(FURNITURE.getMainMenu());
            mainPage.checkMainMenu(CLOTHES.getMainMenu());
            mainPage.checkMainMenu(TOOLS.getMainMenu());
            mainPage.checkMainMenu(SOUVENIRS.getMainMenu());
        });
    }


    @Severity(SeverityLevel.NORMAL)
    @Tag("smoke")
    @Story("Проверка перехода по ссылкам из главного меню")
    @Test
    @DisplayName("Проверка перехода по ссылкам из главного меню")
    void checkOpenPageFromMainMenuTest() {

        step("Перейти на главную страницу", () ->
                mainPage.openPage());

        step("Перейти по каждой ссылке из главного меню и убедиться, что открыта нужная страница", () -> {
            ElementsCollection hrefs = $$("#menu-main a");

            List<String> links = hrefs.asFixedIterable().stream()
                    .map(x -> x.getAttribute("href")).map(String::valueOf).toList();

            for (int i = 0; i < links.size(); i++) {
                String listUrl = links.get(i);
                Selenide.open(listUrl);
                String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();

                assertEquals(currentUrl, listUrl);

            }
        });
    }
}
