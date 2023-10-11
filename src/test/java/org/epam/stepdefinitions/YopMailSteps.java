package org.epam.stepdefinitions;

import io.cucumber.java.en.Then;
import org.epam.pages.modules.Estimate;
import org.epam.pages.pagesforapp.YopMail;
import org.testng.Assert;

import static org.epam.stepdefinitions.BaseSteps.PAGES_STORAGE;
public class YopMailSteps {
        @Then("Received email is present with info {string} on the {string}")
        public void estimatedCostIsPresentInReceivedEmail(String expectedEstimateCostEmail, String pageName) {
            String estimateCostEmail = ((YopMail) PAGES_STORAGE.get(pageName)).checkTotalEstimatedMonthlyCost();
            Assert.assertEquals(expectedEstimateCostEmail, estimateCostEmail);
        }
        @Then("Cost present in {string} equals to the cost present on {string}")
        public void checkCostInEstimateModuleEqualsCostInEmail(String pageNameEstimateModule, String pageNameInBox) {
            String estimateCost = ((Estimate) PAGES_STORAGE.get(pageNameEstimateModule)).getTotalEstimatedCostText();
            String estimateCostEmail = ((YopMail) PAGES_STORAGE.get(pageNameInBox)).checkTotalEstimatedMonthlyCost();
            String regex = "[^\\d{1,2}[\\,\\.]\\d{3}\\.\\d{1,2}]";
            String numberOfEstimated = estimateCost.replaceAll(regex, "");
            String numberOfEstimatedByEmail = estimateCostEmail.replaceAll(regex, "");
            Assert.assertEquals(numberOfEstimated, numberOfEstimatedByEmail);
        }

}
