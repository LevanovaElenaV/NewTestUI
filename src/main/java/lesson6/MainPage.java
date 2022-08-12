package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInReference;

    public MainPage(WebDriver driver) {
        super(driver);  //вызываем конструктор BasePage чтобы передать еему аргумент
        mainMenuBlock = new MainMenuBlock(driver);
    }

    public MainMenuBlock mainMenuBlock;

    public LoginPage clickSignInReference () {
        signInReference.click();
        return new LoginPage(driver);
    }

}
