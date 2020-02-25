package Pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Condition;
import DataHelper.DataHelper;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.withText;


public class CardTransferPage {

    private SelenideElement cardTransferPage = $("body");
    private String cssForTransferAmountField = "[data-test-id='amount'] input";
    private String cssForSourceCardForTransferField = ".input__control[type=tel]";
    private String cssForMakeTransferButton = "button[data-test-id='action-transfer']";
    private String cssForCancelTransferButton = "[data-test-id='action-cancel']";

    public CardTransferPage() {}

    public CardListPage makeTransferFromCard(String amount, DataHelper.Card cardFrom) {
        cardTransferPage.$(cssForTransferAmountField).sendKeys(amount);
        cardTransferPage.$(cssForSourceCardForTransferField).sendKeys(cardFrom.getNumber());
        cardTransferPage.$(cssForMakeTransferButton).click();
        return new CardListPage();
    }

    public void enterAmount(String amount){
        cardTransferPage.$(cssForTransferAmountField).sendKeys(amount);
    }

    public void enterSource(DataHelper.Card cardFrom){
        cardTransferPage.$(cssForSourceCardForTransferField).sendKeys(cardFrom.getNumber());
    }

    public void clickMakeTransferButton(){
        cardTransferPage.$(cssForMakeTransferButton).click();
    }

    public void cancelAndGoBack(){
        cardTransferPage.$(cssForCancelTransferButton).click();
    }

    public void checkIfErrorNotificationIsShown(){
        cardTransferPage.$(withText("Ошибка!")).waitUntil(Condition.appears, 4000);
    }
}