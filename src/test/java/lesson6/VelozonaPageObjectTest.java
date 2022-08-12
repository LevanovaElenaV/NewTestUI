package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class VelozonaPageObjectTest {
    WebDriver driver;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.get("http://www.velozona.ru/forums/forum.php?forum=2");
    }

    @Test
    void AppendRecordTest()  {
//        VelozonaForumPage velozonaForumPage = new VelozonaForumPage(driver);
//        // Авторизация
//        velozonaForumPage.login("Ena", "queen");
//
//        //Добавление сообщения
        String subjectText = "Новая тема " + new Random().nextInt(1000);
        String messageText = "Новое автоматически созданное тестовое сообщение";
//        velozonaForumPage.clickAppendReference();   // -> velozonaAppendPage
//        VelozonaAppendPage velozonaAppendPage = new VelozonaAppendPage(driver);
//        velozonaAppendPage.appendRecord(subjectText, messageText);
//
//        // Возвращаемся в список
//        velozonaAppendPage.returnToForum();         // -> velozonaForumPage
//
//        velozonaForumPage.logout();                 // возможно просто нужна задержка, иначе *ломается* авторизация
//        velozonaForumPage.login("Ena", "queen");
//
//        // Находим только что созданное сообщение
//        velozonaForumPage.goToAppendedRecord(subjectText);  // -> velozonaShowPage ТУТ ПРОВЕРКА, ЧТО ТЕМА ДОБАВИЛАСЬ ВЕРНО
//        VelozonaShowPage velozonaShowPage = new VelozonaShowPage(driver);
//
//        // Удаляем запись
//        velozonaShowPage.editRecord();              // -> velozonaDeletePage
//        VelozonaDeletePage velozonaDeletePage = new VelozonaDeletePage(driver);
//        velozonaDeletePage.deleteRecord();
//
//        // Возвращаемся в список
//        velozonaDeletePage.returnToForum();  // -> velozonaForumPage
//        velozonaForumPage.logout();

        new VelozonaForumPage(driver).login("Ena", "queen")
                .clickAppendReference()
                .appendRecord(subjectText, messageText)
                .returnToForum()
                .goToAppendedRecord(subjectText)
                .editRecord()
                .deleteRecord()
                .returnToForum().logout();


    }

    @AfterEach
    void killBrowser() {
        driver.quit();
    }

}
