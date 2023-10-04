package org.epam.pages.pagesforapp;


import org.epam.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YopMail extends BasePage {


    public YopMail(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[contains(text(),\"Estimated Monthly Cost:\")]")
    private WebElement estimatedCostText;
    private WebElement iFrame;
    private String ifMailFrame = "ifmail";


    public String checkTotalEstimatedMonthlyCost() {
        driver.navigate().refresh();
        iFrame = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(ifMailFrame)));
        driver.switchTo().frame(ifMailFrame);
        waitForVisibilityOf(estimatedCostText);
        return estimatedCostText.getText();
    }

}





