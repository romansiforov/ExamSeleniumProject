package registrationTest;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

public class RegistrationPositiveTest extends BaseTest {

    @Test
    public void positiveRegistrationTest(){
        homePage
                .openHomePage()
                .checkIfRedirectedToHomePage()
                .checkIfAuthenticated();
        homePage
                .clickOnSignInButton()
                .checkIfAuthenticationTextDisplayed()
                .fillEmailIntoInputCreateForm(TestData.VALID_EMAIL)
                .clickOnCreateAccountButton()
                .checkIfRedirectedToRegistrationPage()
                .fillFirstNameIntoInput(TestData.VALID_FIRST_NAMECHARECTERS)
                .fillLastNameIntoInput(TestData.VALID_LAST_NAME_CHARACTERS)
                .fillEmailIntoInput(TestData.VALID_EMAIL)
                .fillPasswordIntoInput(TestData.VALID_REGISTER_PASSWORD)
                .checkNewsSignificationCheckBox()
                .checkSpecialOffersCheckBox()
                .clickRegisterButton()
                .checkIfRedirectedToMyAccountPage()
                .checkCreatedAccountSuccessMessage();
    }

}
