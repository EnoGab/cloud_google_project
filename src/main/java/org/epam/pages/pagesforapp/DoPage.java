package org.epam.pages.pagesforapp;
import org.epam.pages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DoPage extends BasePage {

    public DoPage(WebDriver driver) {
        super(driver);
    }

        @FindBy(xpath = "//div/h3[contains(text(), 'Random Email generator')]")
        private WebElement randomEmailGeneratorButton;
        private WebElement generatedText;
        private WebElement iFrame;
        private String myFrame = "myFrame";
        String generatedEmail;
        @FindBy(xpath = "//*[@id=\"input_615\"]")
        private WebElement emailField;
        @FindBy(xpath = "//button[contains(text(), 'Send Email')]")
        private WebElement sendEmailButton;
        @FindBy(xpath = "//div[@class=\"nw\"]/button[2]")
        private WebElement checkInboxButton;


        public DoPage openGeneratorPage() {
            driver.switchTo().newWindow(WindowType.TAB);
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");
            driver.get("https://yopmail.com/en/");
           return this;
        }
        public DoPage changeTab() {
            String originalWindowHandle = driver.getWindowHandle();
            for (String windowHandle : driver.getWindowHandles()) {
                if (!windowHandle.equals(originalWindowHandle)) {
                   driver.switchTo().window(windowHandle);
                    break;
                }
            }
            return this;
        }
        public DoPage generateEmail() {
            randomEmailGeneratorButton.click();
            driver.navigate().back();
            randomEmailGeneratorButton.click();
            copyGeneratedEmail();
            changeTab();
           driver.switchTo().frame(0);
            iFrame = new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id(myFrame)));
            driver.switchTo().frame(myFrame);
            emailField.click();
            emailField.sendKeys(generatedEmail);
            sendEmailButton.click();
            changeTab();
            return new DoPage(driver);
        }
        public String copyGeneratedEmail(){
            generatedText = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='geny']")));
            generatedEmail = generatedText.getText();
            return generatedEmail;
        }
        public YopMail goToInBoxPage() {
            driver.switchTo().defaultContent();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 200);");
            WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
            checkInboxButton.click();
            return new YopMail(driver);
        }
    }

