package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VelozonaAppendPage extends BasePage {

    public VelozonaAppendPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='subject']")
    private WebElement subjectField;

    @FindBy(xpath = "//textarea[@name='message']")
    private WebElement messageField;

    @FindBy(xpath = "//input[@value='Отправить...']")
    private WebElement sendButton;

    @FindBy(xpath = "//a[.='Покатушки - велотуризм']")
    private WebElement toForum;

    public VelozonaAppendPage appendRecord(String subject, String message) {
        webDriverWait.until(ExpectedConditions.visibilityOf(sendButton)); //на всякий случай
        subjectField.sendKeys(subject);
        messageField.sendKeys(message);
        sendButton.click();
        return this;
    }

    public VelozonaForumPage returnToForum() {
        toForum.click();
        return new VelozonaForumPage(driver);
    }

}
