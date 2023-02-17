package com.serenitydojo.tutorials.ecommerce.stepdefinitions;

import com.serenitydojo.tutorials.ecommerce.actions.NavigateActions;
import com.serenitydojo.tutorials.ecommerce.pageobjects.*;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CartStepDefinitions extends UIInteractionSteps {

    CartSummaryPanel cartSummaryPanel;

    ProductDetailsPanel productDetailsPanel;

    MenuBar menuBar;

    ProductItems productItems;

    //
    // Reusable business tasks
    //
    @Steps
    NavigateActions navigate;

    @When("she adds the {string} to her cart from the home page")
    @When("she has added the {string} to her cart from the home page")
    public void addItemFromHomepage(String item) {
        navigate.toTheHomePage();
        productItems.viewProductDetailsFor(item);
        productDetailsPanel.addToCart();
    }

    @When("she views the details of the {string} item")
    public void sheAddsTheToHerCart(String item) {
        productItems.viewProductDetailsFor(item);
    }

    @And("she views her cart summary")
    public void sheViewsHerCartSummary() {
        menuBar.viewCartSummary();
    }

    @DataTableType
    public CartItem cartItem(Map<String, String> cartItemFields) {
        return new CartItem(cartItemFields.get("Product Item Name"), cartItemFields.get("Price"));
    }
    @Then("the cart should contain:")
    public void theCartShouldContain(List<CartItem> cartItems) {
        assertThat(cartSummaryPanel.displayedCartItems()).containsAll(cartItems);
    }

    @And("she adds the item to her cart")
    public void sheAddsTheItemToHerCart() {
        productDetailsPanel.addToCart();
    }
}
