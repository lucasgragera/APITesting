package com.solvd.carinaexample.web;

import com.solvd.carinaexample.web.components.ProductCard;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends AbstractPage {

    @FindBy(xpath = "//*[contains(@class, 's-card-container')]")

    private List<ProductCard> cards;
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public List<ProductCard> getCards() {
        return cards;
    }
}
