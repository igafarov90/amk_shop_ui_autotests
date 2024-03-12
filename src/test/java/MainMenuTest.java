import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.MainMenu.*;
import static io.qameta.allure.Allure.step;

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

}
