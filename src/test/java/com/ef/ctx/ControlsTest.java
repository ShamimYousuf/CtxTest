package com.ef.ctx;

import com.ef.ctx.pages.HomePage;
import org.junit.*;
import java.io.IOException;

public class ControlsTest extends AbstractTestClass {

    HomePage homePage;

    @Before
    public void testSetUp() throws IOException {

        homePage = new HomePage(driver);
        homePage.navigateToHomePage();
    }

    @Test   //REQ: 3
    public void able_to_switch_on_landing_gear_test() throws InterruptedException {
        homePage.waitForPageLoad();
        Assert.assertEquals("Landing gear is OFF", "OFF", homePage.getLandingGearSwitchStatus());
        homePage.clickOnLandingGearSwitch();
        Assert.assertEquals("Landing gear is ON", "ON", homePage.getLandingGearSwitchStatus());
    }

    @Test   //REQ: 4
    public void able_to_adjust_the_flaps() throws InterruptedException {
        homePage.waitForPageLoad();
        String currentFlapPosition = homePage.getFlapsPosition();
        homePage.dragAndDropTheFlaps();
        Assert.assertNotSame("Flap is moved to a new position", currentFlapPosition, homePage.getFlapsPosition());
    }

    @Test   //REQ: 5
    public void verify_connected_status_and_closed_status_after_reconnect_on_dc_is_switched_off() throws InterruptedException {
        homePage.waitForPageLoad();
        homePage.assertStatusIsConnected();
        homePage.clickReconnectOnDC();
        homePage.waitForPageLoad(10000);
        homePage.assertStatusIsClosed();
    }

}
