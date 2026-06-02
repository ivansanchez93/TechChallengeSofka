package mx.com.sofka.pages;

import net.serenitybdd.annotations.At;
import net.serenitybdd.annotations.WhenPageOpens;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.stream.Collectors;

@At("https://www.saucedemo.com/inventory.html")
public class ProductsPage extends PageObject {

    @FindBy(xpath="//div[@class='inventory_item']")
    private List<WebElementFacade> products;

    @FindBy(id = "shopping_cart_container")
    private WebElementFacade buttonShoppingCart;

    @FindBy(xpath = "//*[@class='title']")
    private WebElementFacade title;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElementFacade itemsInCart;

    private JavascriptExecutor js;

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.js = (JavascriptExecutor) driver;
    }

    public void selectProduct(String productName){
        WebElementFacade product = products.stream().filter(
                p -> p.find(By.xpath(".//div[@class='inventory_item_label']//div[1]")).getText().equals(productName))
                .findFirst().orElseThrow();
        js.executeScript("arguments[0].scrollIntoView(true);", product.findElement(By.xpath(".//button")));
        product.findElement(By.xpath(".//button")).click();
    }

    public List<String> getProductNames(){
        return  products.stream()
                .map(product -> product.find(By.xpath(".//div[@class='inventory_item_label']//div[1]")).getText())
                .collect(Collectors.toList());
    }

    public void clickOnCart(){
        buttonShoppingCart.click();
    }

    public boolean validateTotalProductsAdded(int number){
        js.executeScript("arguments[0].scrollIntoView(true);", itemsInCart);
        return itemsInCart.getText().contains(String.valueOf(number));
    }

    @WhenPageOpens
    public void ensurePageIsDisplayed(){
        title.shouldContainText("Products");
    }

    public boolean isTitleVisible(){
        return title.isDisplayed();
    }
}
