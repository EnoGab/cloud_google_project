package org.epam.stepdefinitions;

import io.cucumber.java.en.Then;
import org.epam.pages.pagesforapp.GoogleSearch;

import static org.epam.stepdefinitions.BaseSteps.PAGES_STORAGE;

    public class GoogleSearchSteps {
        @Then("User is successfully navigated from {string} to the {string}")
        public void userSelectSearchTerm(String pageNameFirst, String pageName) {
            PAGES_STORAGE.put(pageName, ((GoogleSearch) PAGES_STORAGE.get(pageNameFirst)).goTOPricingCalculator());
        }
    }

