package com.ef.ctx;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AbstractTestClass {

    public static WebDriver driver;

    @BeforeClass
    public static void setUp() throws IOException {
        driver= new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

}
