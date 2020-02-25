import org.junit.jupiter.api.Test;
import Pages.*;
import DataHelper.DataHelper;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    void shouldLogInSuccessfully() {
        LoginPage loginPage = open("http://localhost:9999/", LoginPage.class);
        loginPage.enterValidLogin();
        loginPage.enterValidPassword();
        VerificationCodePage verificationCodePage = loginPage.clickSubmitButtonIfLoginDataIsValid();
        verificationCodePage.enterValidVerificationCode();
        verificationCodePage.clickSubmitButtonIfVerificationCodeIsValid();
    }

    @Test
    void shouldCorrectlyTransferAmountFromOneCardToAnotherForCredit() {
        String amount = "100";
        LoginPage loginPage = open("http://localhost:9999/", LoginPage.class);
        VerificationCodePage verificationCodePage = loginPage.submitValidLoginData();
        CardListPage cardListPageBefore = verificationCodePage.submitValidVerificationCode();
        int card_1_BalanceBefore = cardListPageBefore.readBalanceForCard_1();
        CardTransferPage cardTransferPage = cardListPageBefore.makeTransferToCard_1();
        CardListPage cardListPageAfter = cardTransferPage.makeTransferFromCard(amount, DataHelper.getCard_0002());
        int card_1_BalanceAfter = cardListPageAfter.readBalanceForCard_1();
        assertEquals(card_1_BalanceBefore + Integer.parseInt(amount), card_1_BalanceAfter);
    }

    @Test
    void shouldCorrectlyTransferAmountFromOneCardToAnotherForDebit() {
        String amount = "1000";
        LoginPage loginPage = open("http://localhost:9999/", LoginPage.class);
        VerificationCodePage verificationCodePage = loginPage.submitValidLoginData();
        CardListPage cardListPageBefore = verificationCodePage.submitValidVerificationCode();
        int card_2_BalanceBefore = cardListPageBefore.readBalanceForCard_2();
        CardTransferPage cardTransferPage = cardListPageBefore.makeTransferToCard_1();
        CardListPage cardListPageAfter = cardTransferPage.makeTransferFromCard(amount, DataHelper.getCard_0002());
        int card_2_BalanceAfter = cardListPageAfter.readBalanceForCard_2();
        assertEquals(card_2_BalanceBefore - Integer.parseInt(amount), card_2_BalanceAfter);
    }

    @Test
    void shouldNotifyIfTransferIsImpossibleForThisAmount() {
        LoginPage loginPage = open("http://localhost:9999/", LoginPage.class);
        VerificationCodePage verificationCodePage = loginPage.submitValidLoginData();
        CardListPage cardListPage = verificationCodePage.submitValidVerificationCode();
        int card_2_BalanceBefore = cardListPage.readBalanceForCard_2();
        String incorrectAmount = Integer.toString(card_2_BalanceBefore + 10000);
        CardTransferPage cardTransferPage = cardListPage.makeTransferToCard_1();
        cardTransferPage.enterAmount(incorrectAmount);
        cardTransferPage.enterSource(DataHelper.getCard_0002());
        cardTransferPage.clickMakeTransferButton();
        cardTransferPage.checkIfErrorNotificationIsShown();
    }
}