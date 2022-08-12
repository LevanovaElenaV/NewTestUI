package lesson6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VelozonaForumPage extends BasePage {

    public VelozonaForumPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "login_h")
    private WebElement loginField;

    @FindBy(className = "pass_h")
    private WebElement passwordField;

    @FindBy(className = "vojti_h")
    private WebElement signInButton;

    @FindBy(xpath = "//a[.='Добавить новое сообщение']")
    private WebElement appendReference;

    @FindBy(className = "vyhod_h")
    private WebElement signOutButton;

    public VelozonaForumPage login(String login, String password) {
        webDriverWait.until(ExpectedConditions.visibilityOf(signInButton));
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        signInButton.click();
        return this;
    }

    public VelozonaAppendPage clickAppendReference() {
        appendReference.click();
        return new VelozonaAppendPage(driver);
    }

    public VelozonaShowPage goToAppendedRecord(String subject) {
        String xpathText = "//a[text()='" + subject + "']";
        Assertions.assertEquals(subject, driver.findElement(By.xpath(xpathText)).getText());
        driver.findElement(By.xpath(xpathText)).click();
        return new VelozonaShowPage(driver);
    }

    public VelozonaForumPage logout() {
        webDriverWait.until(ExpectedConditions.visibilityOf(signOutButton));
        signOutButton.click();
        return this;
    }



}
