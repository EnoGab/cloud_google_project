package org.epam.pages.modules;

import org.epam.pages.BasePage;
import org.epam.pages.pagesforapp.DoPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class Estimate extends BasePage {
    @FindBy(xpath = "//*[@id=\"resultBlock\"]/md-card/md-toolbar/div/h2[2]")
    private WebElement totalEstimatedCost;
    @FindBy(xpath = "//button[@id='Email Estimate']")
    private WebElement emailButton;

    public Estimate(WebDriver driver) {
        super(driver);
    }

    public Estimate sendToEmail() {
        emailButton.click();
        return this;
    }
    public String getTotalEstimatedCostText() {
        waitForVisibilityOf(totalEstimatedCost);
        return totalEstimatedCost.getText();
    }
    public DoPage openNewTab() {

        String originalWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        return new DoPage(driver);
    }
}