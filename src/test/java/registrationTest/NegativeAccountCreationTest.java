package registrationTest;

import baseTest.BaseTest;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.AuthenticationPage;

@RunWith(JUnitParamsRunner.class)
public class NegativeAccountCreationTest extends BaseTest {
    @Test
    @Parameters({
            "@@@@@@,Invalid email address.",
            "awdawdawd,Invalid email address.",
            "test@test@test.com,Invalid email address.",
            "@test.com,Invalid email address."
    })
    @TestCaseName("failedRegistration : email = {0}")
    public void failedRegistration(String email, String expectedError){
        homePage.openHomePage()
                .clickOnSignInButton()
                .fillEmailIntoInputCreateForm(email)
                .clickOnCreateAccountButtonNegativeTransition()
                .checkErrorMessage();
    }
}
