package Pages;

import com.codeborne.selenide.SelenideElement;
import DataHelper.DataHelper;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement loginPage = $("body");
    private String cssForLoginField = "input[name=login]";
    private String cssForPasswordField = "input[name=password]";
    private String cssForSubmitLoginButton = "button.button";
    private DataHelper.AuthInfo authInfo;

    public LoginPage() {}

    public VerificationCodePage submitValidLoginData() {
        this.authInfo = DataHelper.getValidAuthInfo();
        loginPage.$(cssForLoginField).sendKeys(authInfo.getLogin());
        loginPage.$(cssForPasswordField).sendKeys(authInfo.getPassword());
        loginPage.$(cssForSubmitLoginButton).click();
        return new VerificationCodePage();
    }

    public void enterValidLogin() {
        this.authInfo = DataHelper.getValidAuthInfo();
        loginPage.$(cssForLoginField).sendKeys(authInfo.getLogin());
    }

    public void enterValidPassword() {
        this.authInfo = DataHelper.getValidAuthInfo();
        loginPage.$(cssForPasswordField).sendKeys(authInfo.getPassword());
        loginPage.$(cssForSubmitLoginButton).click();
    }

    public VerificationCodePage clickSubmitButtonIfLoginDataIsValid() {
        loginPage.$(cssForSubmitLoginButton).click();
        return new VerificationCodePage();
    }
}