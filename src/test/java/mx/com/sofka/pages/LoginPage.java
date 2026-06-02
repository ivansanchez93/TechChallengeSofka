package mx.com.sofka.pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.annotations.WhenPageOpens;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

@DefaultUrl("https://www.saucedemo.com/")
public class LoginPage extends PageObject {

    @FindBy(id = "user-name")
    WebElementFacade inputUsername;

    @FindBy(id = "password")
    WebElementFacade inputPassword;

    @FindBy(id = "login-button")
    WebElementFacade buttonLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username){
        enter(username).into(inputUsername);
    }

    public void enterPassword(String password){
        enter(password).into(inputPassword);
    }

    public void clickLoginButton(){
        buttonLogin.click();
    }

    @WhenPageOpens
    public void waitUntilTitleAppears() {
        element(buttonLogin).waitUntilVisible();
    }
}
