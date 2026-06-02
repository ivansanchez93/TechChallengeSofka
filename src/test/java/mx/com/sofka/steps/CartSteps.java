package mx.com.sofka.steps;

import mx.com.sofka.pages.CartPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;

public class CartSteps extends UIInteractions {

    @Step("Validate enter to cart")
    public boolean isCartPageOpen(){
        return onCartPage().quantityLabelIsDisplayed();
    }

    @Step("Validate that {0} exists in the cart")
    public boolean productExistsInCart(String productName){
        return onCartPage().productExists(productName);
    }

    @Step("Click to the checkout page")
    public void goToCheckout(){
        onCartPage().clickButtonCheckout();
    }

    private CartPage onCartPage(){
        return getPages().get(CartPage.class);
    }
}
