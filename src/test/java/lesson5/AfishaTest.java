// урок 5 для Git
package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
//import java.util.stream.Stream;

public class AfishaTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    private  final static String AFISHA_BASE_URL = "https://www.afisha.ru/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    void likeMovieTest() {
        webDriverWait.until(d -> d.findElements(
                By.xpath("//a[@data-test='LINK ITEM-NAME ITEM-URL' and contains(@href, 'movie')]/h2")).size() > 0);

        List<WebElement> filmsList = driver.findElements(
                By.xpath("//a[@data-test='LINK ITEM-NAME ITEM-URL' and contains(@href, 'movie')]/h2"));
//        filmsList.stream().filter(f -> f.getText().contains("Бойся темноты")).findFirst().get().click();
       filmsList.get(0).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//section[@data-test='PAGE-SECTION TITLE-SECTION']//button[@data-test='BUTTON FAVORITE']")));

        driver.findElement(By.xpath("//section[@data-test='PAGE-SECTION TITLE-SECTION']//button[@data-test='BUTTON FAVORITE' ]")).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'login')]")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        Assertions.assertEquals(driver.findElement(By.id("login")).isDisplayed(), true);
    }

    @Test
    void hoverCinrmaButtonAndClickOkkoLinkTest() {
        actions.moveToElement(driver.findElement(By.xpath("//a[.='КИНО']")))
                .build()
                .perform(); //навели мышь и увидели больше
        driver.findElement(By.xpath("//a[.='Скоро онлайн в Okko']")).click();
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.afisha.ru/movie/okko-soon/");

        //удалим элемент
        ((JavascriptExecutor)driver).executeScript("let element = document.evaluate(\"//img[@alt='QR код для скачивания приложения Afisha']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null)\n" +
                "element.singleNodeValue.remove()");

        // проскролируем до элемента (похоже только по вертикали
//      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[@href='/movie/271845/' and @data-test='LINK ITEM-NAME ITEM-URL']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//button[.='Подписаться']")));

        try {
            Thread.sleep(10000);
        }
        catch(Exception e) {}
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions((driver));
        driver.get(AFISHA_BASE_URL);
    }

    @AfterEach
    void quitBrowser() {
        driver.quit();
    }

}
