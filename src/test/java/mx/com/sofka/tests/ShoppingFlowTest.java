package mx.com.sofka.tests;

import mx.com.sofka.steps.CartSteps;
import mx.com.sofka.steps.CheckoutSteps;
import mx.com.sofka.steps.LoginSteps;
import mx.com.sofka.steps.ProductsSteps;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SerenityJUnit5Extension.class)
public class ShoppingFlowTest {

    @Steps
    LoginSteps loginSteps;

    @Steps
    ProductsSteps productsSteps;

    @Steps
    CartSteps cartSteps;

    @Steps
    CheckoutSteps checkoutSteps;

    @Test
    public void shoppingFlow() {
        //GIVEN USER LOGIN
        loginSteps.login("standard_user","secret_sauce");
        assertTrue(productsSteps.validateBeOnProductsPage());

        //WHEN ADD PRODUCTS
        List<String> productNames = productsSteps.getProductNames();
        productsSteps.addToCart(productNames.get(0));
        productsSteps.addToCart(productNames.get(productNames.size()-1));
        assertTrue(productsSteps.validateAddedItems(2));

        //AND GO TO CART
        productsSteps.goToCart();
        assertTrue(cartSteps.isCartPageOpen());
        assertTrue(cartSteps.productExistsInCart(productNames.get(0)));
        assertTrue(cartSteps.productExistsInCart(productNames.get(productNames.size()-1)));

        //AND GO TO CHECKOUT
        cartSteps.goToCheckout();
        assertTrue(checkoutSteps.validateCheckoutInformationPageIsDisplayed());
        checkoutSteps.fulfillInformationForm("Test Name", "Test Last Name", "64885");
        checkoutSteps.continueToOverview();
        assertTrue(checkoutSteps.validateCheckoutOverviewPageIsDisplayed());
        assertTrue(checkoutSteps.validateProductOnOverviewPage(productNames.get(0)));
        assertTrue(checkoutSteps.validateProductOnOverviewPage(productNames.get(productNames.size()-1)));
        assertTrue(checkoutSteps.validateTotalSummary());

        //THEN USER VALIDATES SUCCESS PURCHASE
        checkoutSteps.finalizeCheckoutOrder();
        assertTrue(checkoutSteps.validateOrderComplete());

    }
}
