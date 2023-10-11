package org.epam;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.epam.pages.modules.Estimate;
import org.epam.pages.pagesforapp.GoogleCloudPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void browserHi() {
        // use source path
        System.setProperty("webdriver.chrome.driver","/Users/nrktgabunia/IdeaProjects/cloud_google_project/src/test/resources/webdrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverManager.chromedriver().setup();
    }

    @AfterMethod
    public void BrowserBye() {
        driver.quit();
        driver = null;
    }
    @Test
    public void calculatorTest() {

        GoogleCloudPage googleCloudPage = new GoogleCloudPage(driver);
        String totalEstimatedCostText = googleCloudPage
                .open()
                .search("Google Cloud Platform Pricing Calculator")
                .goTOPricingCalculator()
                .fillNumberOfInstances("4")
                .fillSeries("n1")
                .fillMachineType("CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8")
                .clickGpusCheckBox()
                .fillGpuType("NVIDIA_TESLA_V100")
                .fillNumberOfGpusType("1")
                .fillLocalSsd("2")
                .fillDatacenterLocation( "europe-west3")
                .fillCommittedUsageLocation("1")
                .addToEstimate()
                .getTotalEstimatedCostText();

        Estimate estimateModule = new Estimate(driver);
        String totalEstimatedCostByEmailText = estimateModule
                .sendToEmail()
                .openNewTab()
                .openGeneratorPage().generateEmail()
                .goToInBoxPage()
                .checkTotalEstimatedMonthlyCost();
        String regex = "[^\\d{1,2}[\\,\\.]\\d{3}\\.\\d{1,2}]";
        String numberOfEstimated = totalEstimatedCostText.replaceAll(regex, "");
        String numberOfEstimatedByEmail = totalEstimatedCostByEmailText.replaceAll(regex, "");
        Assert.assertEquals(numberOfEstimated, numberOfEstimatedByEmail);
    }


}
