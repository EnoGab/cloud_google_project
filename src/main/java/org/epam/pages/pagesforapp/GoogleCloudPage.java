package org.epam.pages.pagesforapp;

import org.epam.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudPage extends BasePage {

    public GoogleCloudPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(name = "q")
    private WebElement searchField;


    public GoogleCloudPage open() {
        driver.get("https://cloud.google.com/");
        return this;
    }
    public GoogleSearch search(String searchData){
        this.searchField.sendKeys(searchData);
        searchField.sendKeys(Keys.ENTER);

        return new GoogleSearch(driver);
    }

}
