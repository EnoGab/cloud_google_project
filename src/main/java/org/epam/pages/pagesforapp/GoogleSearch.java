package org.epam.pages.pagesforapp;
import org.epam.pages.BasePage;
import org.epam.pages.pagesforapp.CalculatorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class GoogleSearch extends BasePage {

        public GoogleSearch(WebDriver driver) {
            super(driver);
        }

    @FindBy(xpath = "//a[@class='gs-title']")
        private WebElement calculatorLink;

        public CalculatorPage goTOPricingCalculator() {
            waitForVisibilityOf(calculatorLink).click();
            return new CalculatorPage(driver);
        }
    }

