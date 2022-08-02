package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class Velozona {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.velozona.ru/forums/forum.php?forum=2");

        // Авторизация
        WebElement loginForm = driver.findElement(By.className("login_h"));
        loginForm.sendKeys("Ena");
        driver.findElement(By.className("pass_h")).sendKeys("queen");
        driver.findElement(By.className("vojti_h")).click();

        //Добавление сообщения
        driver.findElement(By.linkText("Добавить новое сообщение")).click();
        // - так переходят в новый фрэйм, когда надо (но тут не надо)
        // driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src=\"//www.acint.net/mc/?dp=10\"]")));
        String subjectText = "Новая тема " + new Random().nextInt(1000);
        driver.findElement(By.xpath("//input[@name=\"subject\"]")).sendKeys(subjectText);
        driver.findElement(By.xpath("//textarea[@name=\"message\"]")).sendKeys("Новое автоматически созданное тестовое сообщение");
        driver.findElement(By.xpath("//input[@value=\"Отправить...\"]")).click();

        // Возвращаемся в список
        driver.findElement(By.linkText("Покатушки - велотуризм")).click();

        // Находим и удаляем только что созданное сообщение
        String xpathText = "//a[text()=\"" + subjectText + "\"]";
        driver.findElement(By.xpath(xpathText)).click();

        // тут вылезет нативное окно, пройдем на 5-ом уроке
//        String xpathText1 = "//a[text()=" + "\"Редактировать\"]";
//        driver.findElement(By.xpath(xpathText1)).click();
//        driver.findElement(By.xpath("//input[@value='Удалить сообщение']")).click();
        // Отсюда пишем, как удалить нативное окно


        try {
            Thread.sleep(5000);
        }
        catch(Exception e) {}

        driver.findElement(By.className("vyhod_h")).click();
        driver.quit();
    }
}
