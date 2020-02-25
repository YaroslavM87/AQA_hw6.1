package Pages;

import com.codeborne.selenide.SelenideElement;
import DataHelper.DataHelper;
import static com.codeborne.selenide.Selenide.$;

public class VerificationCodePage {

    private SelenideElement verificationCodePage = $("body");
    private String cssForVerificationCodeField = "input[name=code]";
    private String cssForSubmitVerificationCodeButton = "button.button";
    private DataHelper.VerificationCode verificationCode;

    public VerificationCodePage() {}

    public CardListPage submitValidVerificationCode() {
        this.verificationCode = DataHelper.getCorrectVerificationCode();
        verificationCodePage.$(cssForVerificationCodeField).sendKeys(verificationCode.getCode());
        verificationCodePage.$(cssForSubmitVerificationCodeButton).click();
        return new CardListPage();
    }

    public void enterValidVerificationCode() {
        this.verificationCode = DataHelper.getCorrectVerificationCode();
        verificationCodePage.$(cssForVerificationCodeField).sendKeys(verificationCode.getCode());
    }

    public CardListPage clickSubmitButtonIfVerificationCodeIsValid() {
        verificationCodePage.$(cssForSubmitVerificationCodeButton).click();
        return new CardListPage();
    }
}