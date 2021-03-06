package NewsSubscriptionTest;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

public class SuccessNewsSubscriptionTest extends BaseTest {
    @Test
    public void newSubscriptionPositiveTest() {
        homePage.openHomePage()
                .fillEmailIntoNewsSubscriptionInput(TestData.VALID_EMAIL)
                .clickOnSubmitSubscriptionButton()
                .checkIfSuccessMessageVisible();
    }

    @Test
    public void newSubscriptionSuccessTextCorrectnessTest(){
        homePage.openHomePage()
                .fillEmailIntoNewsSubscriptionInput(TestData.VALID_EMAIL)
                .clickOnSubmitSubscriptionButton()
                .checkIfSuccessMessageCorrectness();
    }
}
