package pages;


import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class ParentPage {
    Logger logger = Logger.getLogger(getClass());
    WebDriver webDriver;
    WebDriverWait webDriverWait5, webDriverWait10, webDriverWait15;
    public static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    protected String baseUrl = configProperties.base_url();

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverWait5 = new WebDriverWait(webDriver, configProperties.TIME_FOR_DFFAULT_WAIT());
        webDriverWait10 = new WebDriverWait(webDriver, configProperties.TIME_FOR_EXPLICIT_WAIT_LOW());
        webDriverWait15 = new WebDriverWait(webDriver, configProperties.TIME_FOR_EXPLICIT_WAIT_HIGHT());
    }

    abstract String getRelativeUrl();

    protected void checkUrl(){
        Assert.assertEquals("Invalid page", configProperties.base_url()+getRelativeUrl(),webDriver.getCurrentUrl());
    }

    protected boolean elementIsVisible(WebElement webElement) {
        try{
            if(webElement.isDisplayed()){
                logger.info("The element "+webElement.getText()+" is displayed");
                return true;
            }
            logger.info("The element is not displayed");
            return false;
        }catch (Exception e){
            logger.info("The element is not displayed");
            return false;
        }
    }

    protected void clickOnElement(WebElement webElement){
        try{
            webDriverWait5.until(ExpectedConditions.visibilityOf(webElement));
            webElement.click();
            logger.info("The element "+webElement.getText()+" has been clicked");
        }catch (Exception e){
            stopTest(e);
        }
    }

    private void stopTest(Exception e) {
        logger.info("Can not work with element");
        Assert.fail("Can not work with element" + e);
    }
}
