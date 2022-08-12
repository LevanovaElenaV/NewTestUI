package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMenuBlock extends BasePage {
    public MainMenuBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li//a[@title='Women']") // Выбирает все элементы liб для каждого li
    // (Выбирает все элементы a[@title='Women'],
    // являющиеся потомками элемента li независимо от того, где они находятся от элемента li)
    private WebElement womenButton;

    public WomenSuggestPage hoverWomenButton() {
        actions.moveToElement(womenButton)
                .build()
                .perform();
        return new WomenSuggestPage(driver);
    }

}
