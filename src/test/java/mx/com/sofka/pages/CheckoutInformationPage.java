package mx.com.sofka.pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.saucedemo.com/checkout-step-one.html")
public class CheckoutInformationPage extends PageObject {

    @FindBy(className = "title")
    private WebElementFacade labelCheckoutInformation;

    @FindBy(id = "first-name")
    private WebElementFacade inputFirstName;

    @FindBy(id = "last-name")
    private WebElementFacade inputLastName;

    @FindBy(id = "postal-code")
    private WebElementFacade inputPostalCode;

    @FindBy(id = "continue")
    private WebElementFacade buttonContinue;

    public boolean checkOutInformationIsDisplayed() {
        return labelCheckoutInformation.isDisplayed() && labelCheckoutInformation.getText().equals("Checkout: Your Information");
    }

    public void addFirstname(String firstname) {
        inputFirstName.sendKeys(firstname);
    }

    public void addLastname(String lastname) {
        inputLastName.sendKeys(lastname);
    }

    public void addPostalCode(String postalCode) {
        inputPostalCode.sendKeys(postalCode);
    }

    public void clickContinue() {
        buttonContinue.click();
    }
}
