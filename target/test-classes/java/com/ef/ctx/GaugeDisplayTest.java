package com.ef.ctx;

import com.ef.ctx.pages.HomePage;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

public class GaugeDisplayTest extends AbstractTestClass {

    HomePage homePage;

    @Before
    public void testSetUp() throws IOException, InterruptedException {

        homePage = new HomePage(driver);
        homePage.navigateToHomePage();
        homePage.waitForPageLoad();
    }

    @Test   //REQ: 1
    public void verify_min_max_avg_and_current_speed_is_displayed_on_guage() {
        homePage.assertMinSpeedIsDisplayed();
        homePage.assertMaxSpeedIsDisplayed();
        homePage.assertAvgSpeedIsDisplayed();
        homePage.assertCurrentSpeedIsDisplayed();
    }

    @Test   //REQ: 2
    public void verify_min_max_avg_and_current_altitude_is_displayed_on_guage() {
        homePage.assertMinAltitudeIsDisplayed();
        homePage.assertMaxAltitudeIsDisplayed();
        homePage.assertAvgAltitudeIsDisplayed();
        homePage.assertCurrentAltitudeIsDisplayed();
    }

}
