package org.epam.stepdefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.epam.pages.modules.Estimate;
import org.testng.Assert;
import static org.epam.stepdefinitions.BaseSteps.PAGES_STORAGE;

public class EstimateSteps {
    @Then("{string} is present with info {string}")
    public void estimateCostIsPresent(String pageName, String expectedEstimatedCost) {
        String estimatedCost = ((Estimate) PAGES_STORAGE.get(pageName)).getTotalEstimatedCostText();
        Assert.assertEquals(expectedEstimatedCost, estimatedCost);
    }
    @When("User click on Email Estimate button on the {string}")
    public void userClickOnEmailEstimateButton(String pageName) {
        ((Estimate) PAGES_STORAGE.get(pageName)).sendToEmail();
    }
    @And("Open a new tab from the {string}")
    public void userOpenNewTab(String pageName) {
        PAGES_STORAGE.put("Generator Page", ((Estimate) PAGES_STORAGE.get(pageName)).openNewTab());
    }
}