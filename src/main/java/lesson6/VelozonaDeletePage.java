package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VelozonaDeletePage extends BasePage {
    public VelozonaDeletePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@value='Удалить сообщение']")
    private WebElement deleteButton;

    @FindBy(xpath = "//a[.='Покатушки - велотуризм']")
    private WebElement toForum;

    public VelozonaDeletePage deleteRecord() {
        deleteButton.click();
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        return this;
    }

    public VelozonaForumPage returnToForum() {
        toForum.click();
        return new VelozonaForumPage(driver);

    }


}
