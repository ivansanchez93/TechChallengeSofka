package mx.com.sofka.steps;

import mx.com.sofka.pages.LoginPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;

public class LoginSteps extends UIInteractions {

    @Step("Open SauceDemo Site")
    public void openSauceDemo() {
        onLoginPage().open();
    }

    @Step("Type user name {0}")
    public void typeUsername(String username) {
        onLoginPage().enterUsername(username);
    }

    @Step("Type password")
    public void typePassword(String password) {
        onLoginPage().enterPassword(password);
    }

    @Step("Click on Login button")
    public void clickLoginButton() {
        onLoginPage().clickLoginButton();
    }

    @Step("Login to the website")
    public void login(final String username, final String password) {
        this.openSauceDemo();
        this.typeUsername(username);
        this.typePassword(password);
        this.clickLoginButton();
    }

    private LoginPage onLoginPage(){
        return getPages().get(LoginPage.class);
    }
}
