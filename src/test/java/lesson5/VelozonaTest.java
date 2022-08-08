package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;


public class VelozonaTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    private  final static String VELOZONA_BASE_URL = "http://www.velozona.ru/forums/forum.php?forum=2";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions((driver));
        driver.get(VELOZONA_BASE_URL);
    }

    @Test
    void AppendRecordTest() throws InterruptedException {
        // Авторизация
        WebElement loginForm = driver.findElement(By.className("login_h"));
        loginForm.sendKeys("Ena");
        driver.findElement(By.className("pass_h")).sendKeys("queen");
        driver.findElement(By.className("vojti_h")).click();

        //Добавление сообщения
        driver.findElement(By.linkText("Добавить новое сообщение")).click();
        String subjectText = "Новая тема " + new Random().nextInt(1000);
        driver.findElement(By.xpath("//input[@name=\"subject\"]")).sendKeys(subjectText);
        driver.findElement(By.xpath("//textarea[@name=\"message\"]")).sendKeys("Новое автоматически созданное тестовое сообщение");
        driver.findElement(By.xpath("//input[@value=\"Отправить...\"]")).click();

        // Возвращаемся в список
        driver.findElement(By.linkText("Покатушки - велотуризм")).click();

        // Находим и удаляем только что созданное сообщение
        String xpathText = "//a[text()=\"" + subjectText + "\"]";
        driver.findElement(By.xpath(xpathText)).click();

        // тут вылезет нативное окно, закроем
        String xpathText1 = "//a[text()=" + "\"Редактировать\"]";
        driver.findElement(By.xpath(xpathText1)).click();
        driver.findElement(By.xpath("//input[@value='Удалить сообщение']")).click();
        driver.switchTo().alert().accept();

        Thread.sleep(2000);
    }

    @AfterEach
    void quitBrowser() {
        driver.findElement(By.className("vyhod_h")).click();
        driver.quit();
    }
}

