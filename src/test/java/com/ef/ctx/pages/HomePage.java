package com.ef.ctx.pages;

import com.ef.ctx.util.ReadProperties;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
         this.driver = driver;
    }

    public HomePage navigateToHomePage() throws IOException {
        ReadProperties readProperties = new ReadProperties();
        String url = readProperties.getTestUrl();
        driver.get(url);
        return new HomePage(driver);
    }

    public String getLandingGearSwitchStatus(){
        return driver.findElement(By.cssSelector("div#landingGear > div.slide-checkbox label")).getText();
    }

    public void waitForPageLoad() throws InterruptedException {
        Thread.sleep(4000);
    }

    public void waitForPageLoad(int timeInSeconds) throws InterruptedException {
        Thread.sleep(timeInSeconds);
    }

    public void clickOnLandingGearSwitch(){
        driver.findElement(By.cssSelector("div#landingGear > div.slide-checkbox label")).click();
    }

    public String getFlapsPosition(){
       return driver.findElement(By.cssSelector("div.ui-slider a")).getAttribute("style");
    }

    public void dragAndDropTheFlaps(){
        WebElement slider = driver.findElement(By.cssSelector("div.ui-slider a"));

        Actions moveSlider = new Actions(driver);
        Action action = (Action) moveSlider.dragAndDropBy(slider, 20, 0).build();
        action.perform();
    }

    public void assertStatusIsConnected(){
        (new WebDriverWait(driver, 50)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.led-green")));
        Assert.assertTrue("Green button is present", driver.findElement(By.cssSelector("div.led-green")).isDisplayed());
        Assert.assertTrue("Status is present", driver.findElement(By.cssSelector("div#connectionStatus > div:nth-of-type(3) > div:nth-of-type(2)")).isDisplayed());
        Assert.assertEquals("Status is Connected", "Connected", driver.findElement(By.cssSelector("div#connectionStatus > div:nth-of-type(3) > div:nth-of-type(2)")).getText());
    }

    public void assertStatusIsClosed(){
        (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.led-red")));
        Assert.assertTrue("Red button is present", driver.findElement(By.cssSelector("div.led-red")).isDisplayed());
        Assert.assertTrue("Status is present", driver.findElement(By.cssSelector("div#connectionStatus > div:nth-of-type(5) > div:nth-of-type(2)")).isDisplayed());
        Assert.assertEquals("Status is Closed", "Closed", driver.findElement(By.cssSelector("div#connectionStatus > div:nth-of-type(5) > div:nth-of-type(2)")).getText());
    }

    public void clickReconnectOnDC(){
        driver.findElement(By.cssSelector("div#QA-reconnect > div.slide-checkbox label")).click();
    }

    public String getMinSpeed(){
        return driver.findElement(By.cssSelector("#speed-history-summary > li.ng-binding:nth-of-type(1)")).getText();
    }

    public String getMaxSpeed(){
        return driver.findElement(By.cssSelector("#speed-history-summary > li.ng-binding:nth-of-type(2)")).getText();
    }

    public String getAvgSpeed(){
        return driver.findElement(By.cssSelector("#speed-history-summary > li.ng-binding:nth-of-type(3)")).getText();
    }

    public String getCurrentSpeed(){
        return driver.findElement(By.cssSelector("#speed-gauge-canvas")).getAttribute("gauge-value");
    }

    public String getMinAltitude(){
        return driver.findElement(By.cssSelector("#altitude-history-summary > li.ng-binding:nth-of-type(1)")).getText();
    }

    public String getMaxAltitude(){
        return driver.findElement(By.cssSelector("#altitude-history-summary > li.ng-binding:nth-of-type(2)")).getText();
    }

    public String getAvgAltitude(){
        return driver.findElement(By.cssSelector("#altitude-history-summary > li.ng-binding:nth-of-type(3)")).getText();
    }

    public String getCurrentAltitude(){
        return driver.findElement(By.cssSelector("#altitude-gauge-canvas")).getAttribute("gauge-value");
    }

    public void assertMinSpeedIsDisplayed(){
        Pattern pattern = Pattern.compile("Min: \\d+");
        Matcher matcher = pattern.matcher(getMinSpeed());
        Assert.assertTrue("Minimum speed is displayed", matcher.matches());
    }

    public void assertMaxSpeedIsDisplayed(){
        Pattern pattern = Pattern.compile("Max: \\d+");
        Matcher matcher = pattern.matcher(getMaxSpeed());
        Assert.assertTrue("Maximum speed is displayed", matcher.matches());
    }

    public void assertAvgSpeedIsDisplayed(){
        Pattern pattern = Pattern.compile("Avg: \\d+");
        Matcher matcher = pattern.matcher(getAvgSpeed());
        Assert.assertTrue("Average speed is displayed", matcher.matches());;
    }

    public void assertCurrentSpeedIsDisplayed(){
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(getCurrentSpeed());
        Assert.assertTrue("Current speed is displayed", matcher.matches());
    }

    public void assertMinAltitudeIsDisplayed(){
        Pattern pattern = Pattern.compile("Min: \\d+");
        Matcher matcher = pattern.matcher(getMinAltitude());
        Assert.assertTrue("Minimum altitude is displayed", matcher.matches());
    }

    public void assertMaxAltitudeIsDisplayed(){
        Pattern pattern = Pattern.compile("Max: \\d+");
        Matcher matcher = pattern.matcher(getMaxAltitude());
        Assert.assertTrue("Maximum altitude is displayed", matcher.matches());
    }

    public void assertAvgAltitudeIsDisplayed(){
        Pattern pattern = Pattern.compile("Avg: \\d+");
        Matcher matcher = pattern.matcher(getAvgAltitude());
        Assert.assertTrue("Average altitude is displayed", matcher.matches());
    }

    public void assertCurrentAltitudeIsDisplayed(){
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(getCurrentAltitude());
        Assert.assertTrue("Current altitude is displayed", matcher.matches());
    }
}
