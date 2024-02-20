package com.solvd.carinaexample.web.components;

import com.solvd.carinaexample.web.SearchPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchLineComponent extends AbstractUIObject {



    @FindBy(id = ".//*[@id='searchDropdownBox']")
    //@FindBy(xpath =".//*[@id = 'searchDropdownBox']")
    private ExtendedWebElement productTypeSelect;

    @FindBy(id = ".//*[@id='twotabsearchtextbox']")
    //@FindBy(xpath =".//*[@input = 'twotabsearchtextbox']")
    private ExtendedWebElement searchInput;

    @FindBy(id = ".//*[@id='nav-search-submit-button']")
    //@FindBy(xpath =".//*[@id = 'nav-search-submit-button']")
    private ExtendedWebElement searchButton;

    public SearchLineComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    public ExtendedWebElement getProductTypeSelect() {
        return productTypeSelect;
    }

    public ExtendedWebElement getSearchInput() {
        return searchInput;
    }

    public String getSearchInputPlaceholder(){
        return searchInput.getAttribute("placeholder");
    }

    public void typeSearchInputValue(String value){
        searchInput.type(value);
    }

    public ExtendedWebElement getSearchButton() {
        return searchButton;
    }

    public SearchPage clickSearchButton(){
        searchButton.click();
        return new SearchPage(getDriver());
    }
}
