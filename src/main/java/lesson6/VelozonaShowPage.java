package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VelozonaShowPage extends BasePage {
    public VelozonaShowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()=" + "'Редактировать']")
    private WebElement editReference;

    public VelozonaDeletePage editRecord() {
        editReference.click();
        return new VelozonaDeletePage(driver);
    }

}
