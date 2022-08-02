package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Diary {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://diary.ru/new");
        Cookie cookie = new Cookie("_identity_", "07b399886412e3b29a8a348996abf3cae5775d393c1cd56f1fd35832b7f48899a%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3570696%2C%223obRNEOmJtl6Mvi3XgqePEY2knz5vPOq%22%2C2592000%5D%22%3B%7D");
        driver.manage().addCookie(cookie);

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }

        driver.navigate().refresh();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }

        driver.manage().getCookieNamed("_identity_"); // удаляем куку
        driver.quit();

    }
}