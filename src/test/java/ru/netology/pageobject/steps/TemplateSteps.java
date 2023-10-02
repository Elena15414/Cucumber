package ru.netology.pageobject.steps;

import ru.netology.pageobject.data.DataHelper;
import ru.netology.pageobject.page.DashBoardPage;
import ru.netology.pageobject.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static junit.framework.TestCase.assertEquals;

import resources.features;

public class TemplateSteps {
    private DashBoardPage dashBoardPage;

    @Пусть("пользователь залоген с именем {string} и паролем {string}")
    public void loginNameAndPassword(String login, String password){
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var verificationPage = loginPage.validLogin(login,password);
        dashBoardPage = verificationPage.validVerify(DataHelper.getVerificationCode());
    }
    @Когда("он переводит {string} рублей с карты номером {string} на свою {int} карту с главной страницы")
    public void makeTransfer(String amount, String debitCardNumber, int creditCardNumber){
        var transferPage = dashBoardPage.selectCardToTransfer(creditCardNumber);
        dashBoardPage = transferPage.makeTransfer(amount,debitCardNumber);
    }
    @Тогда("баланс {int} карты из с писка на главной странице должен стать {int} рублей")
    public void verificationCardBalance(int creditCardNumber, int expectedCardBalance){
        var actualCreditBalance = dashBoardPage.getCardBalance(creditCardNumber);
        assertEquals(expectedCardBalance,actualCreditBalance);
    }

}
