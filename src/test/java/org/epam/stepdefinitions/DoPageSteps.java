package org.epam.stepdefinitions;

import io.cucumber.java.en.And;
import org.epam.pages.pagesforapp.DoPage;
import static org.epam.stepdefinitions.BaseSteps.PAGES_STORAGE;
public class DoPageSteps {


    @And("User open {string}")
    public void userOpenGeneratorPage(String pageName) {
        ((DoPage) PAGES_STORAGE.get(pageName)).openGeneratorPage();
    }
    @And("User generate a random email on the {string}")
    public void userGenerateRandomEmail(String pageName) {
        ((DoPage) PAGES_STORAGE.get(pageName)).generateEmail();
    }
    @And("And User navigate to the {string} from the {string}")
    public void userNavigateToInBoxPage(String pageName, String pageNameExist) {
        PAGES_STORAGE.put(pageName, ((DoPage) PAGES_STORAGE.get(pageNameExist)).goToInBoxPage());
    }
}