package com.serenitydojo.tutorials.ecommerce.stepdefinitions;

import com.serenitydojo.tutorials.ecommerce.pageobjects.MenuBar;
import com.serenitydojo.tutorials.ecommerce.pageobjects.SearchResults;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchStepDefinitions extends UIInteractionSteps {

    MenuBar menuBar;
    SearchResults searchResults;

    @When("she searches for products related to {string}")
    public void sheSearchesForProductsRelatedTo(String keyword) {
        menuBar.searchFor(keyword);
    }

    @Then("she should be presented with the following products:")
    public void sheShouldBePresentedWithTheFollowingProducts(List<String> expectedProducts) {
        assertThat(searchResults.displayedProductNames()).containsAll(expectedProducts);
    }

    @Then("she should be presented with the following related search terms:")
    public void sheShouldBePresentedWithTheFollowingRelatedSearchTerms(List<String> expectedTerms) {
        assertThat(searchResults.relatedSearchTerms()).containsAll(expectedTerms);
    }

    @And("she selects the related search term {string}")
    public void sheSelectsTheRelatedSearchTerm(String relatedSearch) {
        searchResults.searchByRelatedTerm(relatedSearch);
    }
}
