package mx.com.sofka.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class CheckoutCompletePage extends PageObject {

    @FindBy(xpath = "//*[text()='Thank you for your order!']")
    private WebElementFacade labelThankYou;

    public boolean validateThankYouLabel(){
        return labelThankYou.isVisible();
    }
}
