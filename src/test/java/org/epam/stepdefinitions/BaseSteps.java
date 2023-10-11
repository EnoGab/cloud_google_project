package org.epam.stepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.epam.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

public class BaseSteps {
    public static final Map<String, BasePage> PAGES_STORAGE
            = new HashMap<>();
    public static WebDriver webDriver;

    @Before
    public void initWebDriver() {
        System.setProperty("webdriver.chrome.driver","/Users/nrktgabunia/IdeaProjects/cloud_google_project/src/test/resources/webdrivers/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @After
    public void afterScenario() {
        webDriver.quit();
        PAGES_STORAGE.clear();
    }
}