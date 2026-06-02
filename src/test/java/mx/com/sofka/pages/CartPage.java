package mx.com.sofka.pages;

import net.serenitybdd.annotations.At;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.List;

@At("https://www.saucedemo.com/cart.html")
public class CartPage extends PageObject {

    @FindBy(xpath = "//*[@class='inventory_item_name']")
    private List<WebElementFacade> cartItems;

    @FindBy(id = "checkout")
    private WebElementFacade buttonCheckout;

    @FindBy(className = "cart_quantity_label")
    private WebElementFacade quantityLabel;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean quantityLabelIsDisplayed() {
        return quantityLabel.isDisplayed();
    }

    public boolean productExists(String productName) {
        return cartItems.stream().anyMatch(c -> c.getText().contains(productName));
    }

    public void  clickButtonCheckout() {
        buttonCheckout.click();
    }
}
