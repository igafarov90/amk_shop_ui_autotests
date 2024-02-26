import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static helpers.MainMenu.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("UI")
@Owner("Ilgiz Gafarov")
@Feature("Тестирование функционала фильтра")
@Tag("ui")
@DisplayName("Тестирование функционала фильтра")
public class FilterProductsTest extends TestBase {

    private static final String NOTEBOOK = "Блокнот на пружине";
    private static final String T_SHORT = "Алик и Валик";
    private static final String DIARY = "ежедневник";
    private final Integer PRICE_TO = 150;
    private final Integer PRICE_FROM = 100;


    static Stream<Arguments> filterProductsTest() {

        return Stream.of(
                Arguments.of(PAPER_PRODUCTS.getMainMenu(), DIARY),
                Arguments.of(BABY_CLOTHES.getMainMenu(), T_SHORT),
                Arguments.of(SOUVENIRS.getMainMenu(), NOTEBOOK));

    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("Проверка фильтрации товаров")
    @ParameterizedTest(name = "Фильтрация товара {0}")
    @MethodSource
    @Tag("smoke")
    void filterProductsTest(String filter, String product) {

        step("Установить чекбокс для фильтра и нажать кнопку 'Фильтровать'", () ->
                mainPage.openPage()
                        .installCheckBox(filter)
                        .doFilter());
        step("Проверить наличие товаров в таблице после фильтрации");
        mainPage.checkProductsTable(product);
    }

//    @Test
//    @Severity(SeverityLevel.CRITICAL)
//    @Story("Проверка фильтрации товаров")
//    @DisplayName("Проверка фильтрации по цене товара")
//    @Tag("smoke")
//    void checkFilterProductsByPriceTest() {
//
//        step("Установить ценовой диапазон от 100 до 150", () ->
//                mainPage.openPage()
//                        .setPriceFrom(String.valueOf(PRICE_FROM))
//                        .setPriceTo(String.valueOf(PRICE_TO)));
//
//        step("Нажать кнопку 'Фильтровать'", () ->
//                mainPage.doFilter());
//
//        step("Убедиться, что цена каждого отфильтрованого товара" +
//                "в рамках заданного ценового диапазона ", () -> {
//            List<Integer> price = mainPage.getProducts().asFixedIterable().stream()
//                    .map(x -> x.getText()
//                            .replaceAll(",", "")
//                            .replace(".00 Р", ""))
//                    .map(Integer::valueOf)
//                    .toList();
//
//            assertThat(price).allMatch(x -> x >= 100 && x <= 150);
//        });
//    }
}





