package com.serenitydojo.tutorials.ecommerce.pageobjects;

import net.serenitybdd.screenplay.targets.SearchableTarget;
import org.openqa.selenium.By;

public class SearchResults {
    public static final By PRODUCT_NAME = By.cssSelector(".product-item-name");
    public static final By RELATED_SEARCH_TERM = By.cssSelector(".results dd.item");

    public static By relatedSearchTerm(String term) {
        return By.linkText(term);
    }
}
