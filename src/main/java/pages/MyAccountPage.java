package pages;

import org.openqa.selenium.WebDriver;

public class MyAccountPage extends ParentPage{
    public MyAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return null;
    }
}
