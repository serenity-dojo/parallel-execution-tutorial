package com.serenitydojo.tutorials.ecommerce.pageobjects;

import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.screenplay.targets.SearchableTarget;
import org.openqa.selenium.By;

import java.util.List;

public class SearchResults extends PageComponent {
    public static final By PRODUCT_NAME = By.cssSelector(".product-item-name");
    public static final By RELATED_SEARCH_TERM = By.cssSelector(".results dd.item");

    public static By relatedSearchTerm(String term) {
        return By.linkText(term);
    }

    public List<String> relatedSearchTerms() {
        return $$(SearchResults.RELATED_SEARCH_TERM).texts();
    }

    public List<String> displayedProductNames() {
        return $$(SearchResults.PRODUCT_NAME).texts();
    }

    public void searchByRelatedTerm(String relatedSearch) {
        $(SearchResults.relatedSearchTerm(relatedSearch)).click();
    }
}
