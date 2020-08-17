package org.example;

import org.junit.Test;

public class ForgotPasswordPageTest extends SeleniumBaseTest {

    private ForgotPasswordPage forgotPasswordPage;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        webDriver.get("http://the-internet.herokuapp.com/forgot_password");
        forgotPasswordPage = new ForgotPasswordPage(webDriver);
    }

    @Test
    public void givenEmailIsValidThenEmailSentPageIsShownAndEmailIsSent() {
        forgotPasswordPage
                .inputEmail("test@gmail.com").clickRetrievePasswordButton()
                .assertThatEmailSentPageIsShown().assertThatEmailHasBeenSent();
    }

    @Test
    public void givenEmailIsEmptyThenInternalServerErrorIsShown() {
        forgotPasswordPage.clickRetrievePasswordButton();
        forgotPasswordPage.assertThatInternalServerErrorIsShown();
    }

}
