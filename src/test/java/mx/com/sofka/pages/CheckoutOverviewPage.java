package mx.com.sofka.pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

import java.math.BigDecimal;
import java.util.List;

@DefaultUrl("https://www.saucedemo.com/checkout-step-one.html")
public class CheckoutOverviewPage extends PageObject {

    @FindBy(className = "title")
    private WebElementFacade labelCheckoutInformation;

    @FindBy(id = "finish")
    private WebElementFacade buttonFinish;

    @FindBy(className = "inventory_item_name")
    private List<WebElementFacade> labelsItemName;

    @FindBy(className = "inventory_item_price")
    private List<WebElementFacade> labelsItemPrice;

    @FindBy(className = "summary_subtotal_label")
    private WebElementFacade labelItemTotal;

    @FindBy(className = "summary_tax_label")
    private WebElementFacade labelTax;

    @FindBy(className = "summary_total_label")
    private WebElementFacade labelTotal;

    public boolean checkOutOverviewIsDisplayed() {
        return labelCheckoutInformation.isDisplayed() && labelCheckoutInformation.getText().equals("Checkout: Overview");
    }

    public boolean validateProductName(String productName){
        return labelsItemName.stream().anyMatch(c -> c.getText().contains(productName));
    }

    public boolean validateSummaryTotal(){
        BigDecimal totalItems = labelsItemPrice.stream().map(WebElementFacade::getText)
                .map(price -> price.replace("$", ""))
                .map(BigDecimal::new)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal tax = new BigDecimal(labelTax.getText().substring(labelTax.getText().lastIndexOf("$")+1));
        BigDecimal totalPrice = totalItems.add(tax);

        return labelTotal.getText().substring(labelTotal.getText().lastIndexOf("$")+1).equals(totalPrice.toString())
                && labelItemTotal.getText().substring(labelItemTotal.getText().lastIndexOf("$")+1).equals(totalItems.toString());
    }

    public void clickOnButtonFinish(){
        buttonFinish.click();
    }
}
