package contactUsTest;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Test;

public class ContactUsTest extends BaseTest {
    @Test
    public void sendMessageToSupportPositiveTest(){
        homePage.openHomePage()
                .clickOnContactUsButton()
                .checkIfRedirectedToContactUsPage()
                .fillEmailIntoInput(TestData.VALID_EMAIL)
                .fillMessageTextArea(TestData.VALID_FIRST_NAMECHARECTERS + TestData.VALID_LAST_NAME)
                .selectItemFromTheSubjectHeading("Вебмастер")
                .clickOnSendMessageButton()
                .checkIfSuccessTextVisible();
    }
}
