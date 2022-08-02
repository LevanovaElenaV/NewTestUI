package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automationpractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        Cookie cookie = new Cookie("PrestaShop-a30a9934ef476d11b6cc3c983616e364","iJZ0%2BwRebP0Y5skyN%2FLUsur0%2B9ecVwOYsq%2FESltquIOV%2BiZrES45jcHuT6L%2FInZ5lxWyRME1ZwTcr2nr%2BcVEzFD8Gh%2BCjGsBHcKnW%2BrYFr52XK0SRPMuKM2BMtlIb4vddY3s7o8IDhQkPnt7DZL84j6CTESVnreZqSO324QGHr3SLIDvwaQVAamb0qNEpDfTJ7g933le%2BG3Or%2BHw7GV6m3IR1re%2F%2Fr40ezrXFAsvRImJndP%2Bh2TINIu%2BWi2gOlFRZogyDaeJWRiSHaqgXHTpjdL685AQu0gs1qgkR%2FlEPpaTqH1w9shp299C6AvHJtjYwQSiqLVzQsKbVJSUyg9iynKY81%2BxdzHxnY0f43TOMkaON2zNrPDW4RGD0nMfeBw2EY3Ba7577K0T%2FFBe6HQc5Q%3D%3D000295");
        driver.manage().addCookie(cookie);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }

        driver.navigate().refresh();  // не авторизовались почему-то

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }

       driver.quit();
    }
}
