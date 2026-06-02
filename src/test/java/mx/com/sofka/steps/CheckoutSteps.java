package mx.com.sofka.steps;

import mx.com.sofka.pages.CheckoutCompletePage;
import mx.com.sofka.pages.CheckoutInformationPage;
import mx.com.sofka.pages.CheckoutOverviewPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;

public class CheckoutSteps extends UIInteractions {

    @Step("Validate checkout information page is displayed")
    public boolean validateCheckoutInformationPageIsDisplayed(){
        return onCheckoutInformationPage().checkOutInformationIsDisplayed();
    }

    @Step("Type first name: {0}")
    public void typeFirstName(String firstName){
        onCheckoutInformationPage().addFirstname(firstName);
    }

    @Step("Type last name: {0}")
    public void typeLastName(String lastName){
        onCheckoutInformationPage().addLastname(lastName);
    }

    @Step("Type postal code: {0}")
    public void typePostalCode(String postalCode){
        onCheckoutInformationPage().addPostalCode(postalCode);
    }

    @Step("Fulfill information form")
    public void fulfillInformationForm(String firstName, String lastName, String postalCode){
        this.typeFirstName(firstName);
        this.typeLastName(lastName);
        this.typePostalCode(postalCode);
    }

    @Step("Continue to next page")
    public void continueToOverview(){
        onCheckoutInformationPage().clickContinue();
    }

    @Step("Validate checkout overview page is displayed")
    public boolean validateCheckoutOverviewPageIsDisplayed(){
        return onCheckoutOverviewPage().checkOutOverviewIsDisplayed();
    }

    @Step("Validate product: {0} on overview page")
    public boolean validateProductOnOverviewPage(String productName){
        return onCheckoutOverviewPage().validateProductName(productName);
    }

    @Step("Validate total summary")
    public boolean validateTotalSummary(){
        return onCheckoutOverviewPage().validateSummaryTotal();
    }

    @Step("Finalize checkout order")
    public void finalizeCheckoutOrder(){
        onCheckoutOverviewPage().clickOnButtonFinish();
    }

    @Step("Validate order complete")
    public boolean validateOrderComplete(){
        return onCheckoutCompletePage().validateThankYouLabel();
    }

    private CheckoutInformationPage onCheckoutInformationPage(){
        return getPages().get(CheckoutInformationPage.class);
    }

    private CheckoutOverviewPage onCheckoutOverviewPage(){
        return getPages().get(CheckoutOverviewPage.class);
    }

    private CheckoutCompletePage onCheckoutCompletePage(){ return getPages().get(CheckoutCompletePage.class);}
}
