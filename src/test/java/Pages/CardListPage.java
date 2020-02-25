package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import DataHelper.DataHelper;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.withText;

public class CardListPage {

    private SelenideElement cardListPage = $("body");
    private SelenideElement ElementForAccount_1 = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private SelenideElement ElementForAccount_2 = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");
    private String cssForMakeTransferToCard_1_Button = "[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] button";
    private String cssForMakeTransferToCard_2_Button = "[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] button";
    private String cssForReloadCardListPageButton = "[data-test-id='action-reload']";
    private String markerForSuccessfullyLoadedPage = "Личный кабинет";

    public CardListPage() {
        cardListPage.$(withText(markerForSuccessfullyLoadedPage)).shouldBe(Condition.visible);
    }

    public CardTransferPage makeTransferToCard_1() {
        cardListPage.$(cssForMakeTransferToCard_1_Button).click();
        return new CardTransferPage();
    }

    public CardTransferPage makeTransferToCard_2() {
        cardListPage.$(cssForMakeTransferToCard_2_Button).click();
        return new CardTransferPage();
    }

    public void clickReloadPageButton() {
        cardListPage.$(cssForReloadCardListPageButton).click();
    }

    public int readBalanceForCard_1() {
        String balance = DataHelper.getNumberFromString(
                ElementForAccount_1.getText(),
                "баланс:",
                "р."
        );
        return Integer.parseInt(balance);
    }

    public int readBalanceForCard_2() {
        String balance = DataHelper.getNumberFromString(
                ElementForAccount_2.getText(),
                "баланс:",
                "р."
        );
        return Integer.parseInt(balance);
    }
}