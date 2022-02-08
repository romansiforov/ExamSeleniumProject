package registrationTest;

import baseTest.BaseTest;
import org.junit.Test;

public class RegistrationPositiveTest extends BaseTest {

    @Test
    public void positiveRegistrationTest(){
        homePage.
                openLoginPage()
                .checkIfRedirectedToHomePage();
    }

}
