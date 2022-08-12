package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomenSuggestPage extends BasePage {

    public WomenSuggestPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[contains(@class,'submenu')]//a[@title='T-shirts']")
    private WebElement TShirtsButton;

    public TShirtsPage clickTShirtsButton() {
        TShirtsButton.click();
        return new TShirtsPage(driver);

    }
}
