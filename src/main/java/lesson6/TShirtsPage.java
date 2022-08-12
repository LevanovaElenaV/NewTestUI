package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TShirtsPage extends BasePage {
    public TShirtsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Size']/ancestor::div[@class='layered_filter']//a")
    private List<WebElement> sizesList; // ищем список элементов

    public TShirtsPage selectSize(String size) {
        sizesList.stream().filter(s->s.getText().contains(size)).findFirst().get().click(); // выбираем нужный
        return this;
    }

    @FindBy(xpath = "//ul[@class='product_list grid row']/li")
    private WebElement productElement;

    public SuccessAddToCartPage moveMouseToProductAndAddToCart() {
        actions.moveToElement((productElement))
                .build()
                .perform();
        addToCartButton.click();
        return new SuccessAddToCartPage(driver);
    }

    @FindBy(xpath = "//span[.='Add to cart']")
    private WebElement addToCartButton;

}
