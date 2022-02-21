package NewsSubscriptionTest;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

public class FailedNewsSubscriptionTest extends BaseTest {
    @Test
    public void newSubscriptionNegativeTest() {
        homePage.openHomePage()
                .fillEmailIntoNewsSubscriptionInput(TestData.VALID_EMAIL)
                .clickOnSubmitSubscriptionButton()
                .checkIfFailureMessageVisible();
    }

    @Test
    public void newSubscriptionFailureTextCorrectnessTest(){
        homePage.openHomePage()
                .fillEmailIntoNewsSubscriptionInput(TestData.VALID_EMAIL)
                .clickOnSubmitSubscriptionButton()
                .checkIfFailureMessageCorrectness();
    }
}
