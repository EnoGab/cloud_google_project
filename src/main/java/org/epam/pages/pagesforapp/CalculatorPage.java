package org.epam.pages.pagesforapp;


import org.epam.pages.BasePage;
import org.epam.pages.modules.Estimate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CalculatorPage extends BasePage {

    public CalculatorPage(WebDriver driver) { super(driver); }

    @FindBy(xpath = "//*[@id=\"tab-item-1\"]/div[1]")
    private WebElement computeEngine;
    private WebElement numberOfInstancesField;
    private String numberOfInstances = "//input[@id=\"input_98\"]";
    @FindBy(id = "select_value_label_93")
    private WebElement seriesField;
    private String seriesOptions = "//div[@id=\"select_container_124\"]//md-content[@class=\"_md\"]/md-option";
    @FindBy(xpath = "//md-select[@placeholder=\"Instance type\"]")
    private WebElement machineTypeField;
    private String machineTypeOptions = "//div[@id=\"select_container_126\"]//md-content[@class=\"_md\"]//md-optgroup[@label=\"standard\"]/md-option";
    @FindBy(xpath = "//md-checkbox[@aria-label=\"Add GPUs\"][1]")
    private WebElement addGpusCheckBox;
    @FindBy(xpath = "//md-select[@id=\"select_505\"]")
    private WebElement gpuTypeField;
    private String gpuTypeOptions = "//div[@id=\"select_container_506\"]//md-content[@class=\"_md\"]/md-option";
    @FindBy(xpath = "//md-select[@id=\"select_507\"]")
    private WebElement numberOfGpusField;
    private String numberOfGpusOptions = "//div[@id=\"select_container_508\"]//md-content[@class=\"_md\"]/md-option";
    @FindBy(xpath = "//*[@id=\"select_value_label_463\"]")
    private WebElement localSsdField;
    private String localSsdOptions = "//div[@id=\"select_container_465\"]//md-content[@class=\"_md\"]/md-option";
    @FindBy(xpath = "//*[@id=\"select_value_label_96\"]")
    private WebElement datacenterLocationField;
    private String datacenterLocationOptions = "//div[@id=\"select_container_132\"]//md-optgroup/md-option";
    @FindBy(xpath = "//*[@id=\"select_value_label_97\"]")
    private WebElement committedUsageField;
    private String committedUsageOptions = "//div[@id=\"select_container_139\"]//md-content[@class=\"_md\"]/md-option";
    @FindBy(xpath = "//button[contains(text(), 'Add to Estimate')][1]")
    private WebElement addToEstimateButton;
    private WebElement iFrame;
    private String myFrame = "myFrame";

    public CalculatorPage goToCalculatorFrame() {
        driver.switchTo().frame(0).switchTo().frame("myFrame");
        return this;
    }

    public CalculatorPage activateComputeEngine() {
        waitForVisibilityOf(computeEngine).click();
        return this;
    }
    public CalculatorPage fillNumberOfInstances(String quantity){
        driver.switchTo().frame(0);
        iFrame = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(myFrame)));
        driver.switchTo().frame(myFrame);
        numberOfInstancesField = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(numberOfInstances)));
        numberOfInstancesField.sendKeys(quantity);
        return this;
    }
    public CalculatorPage fillSeries(String name){
        seriesField.click();
        List<WebElement> seriesList = driver.findElements(By.xpath(seriesOptions));
        waitForVisibilityOf(seriesList
                .stream()
                .filter(p -> p.getAttribute("value").equals(name))
                .findFirst().get())
                .click();
        return this;
    }
    public CalculatorPage fillMachineType(String name){
        machineTypeField.click();
        List<WebElement> machineTypeList = driver.findElements(By.xpath(machineTypeOptions));
        waitForVisibilityOf(machineTypeList
                .stream()
                .filter(p -> p.getAttribute("value").equals(name))
                .findFirst().get())
                .click();
        return this;
    }
    public CalculatorPage clickGpusCheckBox(){
        addGpusCheckBox.click();
        return this;
    }
    public CalculatorPage fillGpuType(String name){
        gpuTypeField.click();
        List<WebElement> gpuTypeList = driver.findElements(By.xpath(gpuTypeOptions));
        waitForVisibilityOf(gpuTypeList
                .stream()
                .filter(p -> p.getAttribute("value").equals(name))
                .findFirst().get())
                .click();
        return this;
    }
    public CalculatorPage fillNumberOfGpusType(String name){
        numberOfGpusField.click();
        List<WebElement> numberOfGpusList = driver.findElements(By.xpath(numberOfGpusOptions));
        waitForVisibilityOf(numberOfGpusList
                .stream()
                .filter(p -> p.getAttribute("value").equals(name))
                .findFirst().get())
                .click();
        return this;
    }
    public CalculatorPage fillLocalSsd(String name){
        localSsdField.click();
        List<WebElement> localSsdList = driver.findElements(By.xpath(localSsdOptions));
        waitForVisibilityOf(localSsdList
                .stream()
                .filter(p -> p.getAttribute("value").equals(name))
                .findFirst().get())
                .click();
        return this;
    }
    public CalculatorPage fillDatacenterLocation(String searchTerm, String name){
        datacenterLocationField.click();
        List<WebElement> datacenterLocationList = driver.findElements(By.xpath(datacenterLocationOptions));
        waitForVisibilityOf(datacenterLocationList
                .stream()
                .filter(p -> p.getAttribute("value").equals(name))
                .findFirst().get())
                .click();
        return this;
    }
    public CalculatorPage fillCommittedUsageLocation(String name){
        committedUsageField.click();
        List<WebElement> committedUsageList = driver.findElements(By.xpath(committedUsageOptions));
        waitForVisibilityOf(committedUsageList
                .stream()
                .filter(p -> p.getAttribute("value").equals(name))
                .findFirst().orElse(null))
                .click();
        return this;
    }
    public Estimate addToEstimate() {
        addToEstimateButton.click();
        return new Estimate(driver);
    }
}



