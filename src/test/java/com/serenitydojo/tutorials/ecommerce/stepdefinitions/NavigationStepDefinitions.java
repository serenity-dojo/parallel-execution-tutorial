package com.serenitydojo.tutorials.ecommerce.stepdefinitions;

import com.serenitydojo.tutorials.ecommerce.actions.NavigateActions;
import com.serenitydojo.tutorials.ecommerce.pageobjects.MenuBar;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Steps;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NavigationStepDefinitions extends UIInteractionSteps {

    @Steps
    NavigateActions navigate;

    MenuBar menuBar;

    @Given("Olivia is shopping on the Luma site")
    public void olivia_is_shopping_on_the_Luma_site() {
        navigate.toTheLumaApplication();
    }

    List<String> menuBarItems;

    @When("she views the main menu bar")
    public void she_views_the_main_menu_bar() {
        menuBarItems = menuBar.categories();
    }

    @Then("she should see the following items:")
    public void she_should_see_the_following_items(List<String> expectedCategories) {
        assertThat(menuBarItems).containsAll(expectedCategories);
    }


    @When("she views the subcategories of the {string} category")
    public void sheViewsTheSubcategoriesOfTheCategory(String category) {
        moveTo(MenuBar.category(category));
    }

    @Then("she should be presented with the following subcategories: {commaSeparatedList}")
    public void sheShouldBePresentedWithTheFollowingSubcategoriesSubcategories(List<String> expectedSubcategories) {
        assertThat(menuBar.subCategories()).containsAll(expectedSubcategories);
    }

    @When("she views the subcategories of the {string} subcategory in the {string} category")
    public void sheViewsTheSubcategoriesOfTheSubcategoryInTheCategory(String subcategory, String category) {
        moveTo(MenuBar.category(category));
        moveTo(MenuBar.category(subcategory));
    }


    @Then("she should be presented with the following 2nd level subcategories: {commaSeparatedList}")
    public void sheShouldBePresentedWithTheFollowingNdLevelSubcategoriesSubSubCategories(List<String> expectedSubcategories) {
        assertThat(menuBar.subSubCategories()).containsAll(expectedSubcategories);
    }
}
