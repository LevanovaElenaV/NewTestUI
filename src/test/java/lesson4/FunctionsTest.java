package lesson4;

import org.checkerframework.checker.units.qual.C;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static lesson4.Functions.isPalindrome;
import static org.assertj.core.api.Assertions.assertThat;

public class FunctionsTest {
    private static Logger logger = LoggerFactory.getLogger("FunctionsTest");
    @BeforeAll
    static void beforeAll() {
         logger.info("Метод выполняется 1 раз перед всеми тестами класса");
//         System.out.println("Метод выполняется 1 раз перед всеми тестами класса");
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

// TRACE, DEBUG, INFO, WARNING, ERROR - уровни логирования, стандарт
    @BeforeEach
    void beforeEach() {
        logger.error("Метод выполняется перед каждым тестом класса");
        //WebDriver driver = new ChromeDriver();
    }

    @Test
    @DisplayName("Метод проверки палиндрома с нечетным количеством символов")
    void isPalindromeThenTrue() {
        assertThat(isPalindrome("1234321")).isTrue();
//        boolean result = isPalindrome("1234321");
//        Assertions.assertTrue(result);

//        Assertions.assertEquals(result, true);
    }

    @Test
    //@Disabled("broken")
    @DisplayName("Метод проверки палиндрома с четным количеством символов")
    void isPalindromeThenTrue1() {
        boolean result = isPalindrome("123321");
        Assertions.assertTrue(result);
//        Assertions.assertEquals(result, false);
    }

    @ParameterizedTest
    @Tag("smoke")
    @ValueSource(strings = {"1234321","123321"}) // передаем тестовые данные
    @DisplayName("Метод проверки палиндрома, переданного в метод isPalindrome при помощи Data Provider")
    void isPalindromeThenTrueWithDataProvider(String word) {
        boolean result = isPalindrome(word);
        Assertions.assertTrue(result);
    }

    @ParameterizedTest
//    @CsvSource({"'123', false", "'123321', true"}) // передаем и тестовые данные и ожидаемый результат
    @DisplayName("Метод проверки палиндрома, переданного в метод isPalindrome при помощи cvs")
    @CsvSource({"123, false", "123321, true"}) // так можно

    void csvTest(String word, boolean expectedResult) {
        boolean actualResult = isPalindrome(word);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @MethodSource("catAndAgeDataProvider")
    void catEqualAgeTest(Cat cat, int age) {
        Assertions.assertEquals(cat.getAge(), age);
    }

    private static Stream<Arguments> catAndAgeDataProvider() {
        return Stream.of( // последовательность наборов тестовых данных
                Arguments.of(new Cat("Ababa", 10), 10),
                Arguments.of(new Cat("Felix", 11), 11),
                Arguments.of(new Cat("Dad", 15), 15)
        );
    }

    @AfterEach
    void afterEach() {
        System.out.println("Метод выполняется после каждого теста класса");
//        WebDriver driver.quit();
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Метод выполняется после всех тестов класса");
    }

}
