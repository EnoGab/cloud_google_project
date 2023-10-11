package org.epam.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.epam.pages.pagesforapp.CalculatorPage;
import org.epam.pages.pagesforapp.GoogleCloudPage;

import static org.epam.stepdefinitions.BaseSteps.PAGES_STORAGE;

public class CalculatorPageSteps {
    @When("User fill Number of instances field with value {string} on the {string}")
    public void userFillNumberOfInstancesField(String value, String pageName) {
        ((CalculatorPage) PAGES_STORAGE.get(pageName)).fillNumberOfInstances(value);
    }
    @And("User fill Series field with value {string} on the {string}")
    public void userFillSeriesField(String value, String pageName) {
        ((CalculatorPage) PAGES_STORAGE.get(pageName)).fillSeries(value);
    }
    @And("User fill Machine Type field with value {string} on the {string}")
    public void userFillMachineTypeField(String value, String pageName) {
        ((CalculatorPage) PAGES_STORAGE.get(pageName)).fillMachineType(value);
    }
    @And("User check GPUs checkbox on the {string}")
    public void userCheckGpusCheckbox( String pageName) {
        ((CalculatorPage) PAGES_STORAGE.get(pageName)).clickGpusCheckBox();
    }
    @And("User fill GPU Type field with value {string} on the {string}")
    public void userFillGpuTypeField(String value, String pageName) {
        ((CalculatorPage) PAGES_STORAGE.get(pageName)).fillGpuType(value);
    }
    @And("User fill Number of GPUs field with value {string} on the {string}")
    public void userFillNumberOfGpusField(String value, String pageName) {
        ((CalculatorPage) PAGES_STORAGE.get(pageName)).fillNumberOfGpusType(value);
    }
    @And("User fill Local SSD field with value {string} on the {string}")
    public void userFillLocalSsdField(String value, String pageName) {
        ((CalculatorPage) PAGES_STORAGE.get(pageName)).fillLocalSsd(value);
    }
    @And("User fill Datacenter Location field with value {string} on the {string}")
    public void userFillDatacenterLocationField(String value, String pageName) {
        ((CalculatorPage) PAGES_STORAGE.get(pageName)).fillDatacenterLocation(value);
    }
    @And("User fill Committed Usage Location field with value {string} on the {string}")
    public void userFillCommittedUsageField(String value, String pageName) {
        ((CalculatorPage) PAGES_STORAGE.get(pageName)).fillCommittedUsageLocation(value);
    }
    @And("User click on Add to Estimate button on the {string}")
    public void userClickOnAddToEstimateButton(String pageName) {
        PAGES_STORAGE.put("Estimate Module",((CalculatorPage) PAGES_STORAGE.get(pageName)).addToEstimate());
    }
}