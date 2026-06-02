package mx.com.sofka.steps;

import mx.com.sofka.pages.ProductsPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;

import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;

public class ProductsSteps extends UIInteractions {

    public List<String> getProductNames(){
        return onProductsPage().getProductNames();
    }

    @Step("Add to cart the product {0}")
    public void addToCart(String productName){
        onProductsPage().selectProduct(productName);
    }

    @Step("Go to the cart")
    public void goToCart(){
        onProductsPage().clickOnCart();
    }

    @Step("Validate successful login")
    public boolean validateBeOnProductsPage(){
        return onProductsPage().isTitleVisible();
    }

    @Step("Validate number of products added: {0}")
    public boolean validateAddedItems(int number){
        return onProductsPage().validateTotalProductsAdded(number);
    }

    private ProductsPage onProductsPage(){
        return getPages().get(ProductsPage.class);
    }
}
