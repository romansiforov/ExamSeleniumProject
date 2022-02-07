package pages;

import org.openqa.selenium.WebDriver;

public class AuthenticationPage extends HeaderAndNavBarPage{
    public AuthenticationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/authentication?back=my-account";
    }
}
