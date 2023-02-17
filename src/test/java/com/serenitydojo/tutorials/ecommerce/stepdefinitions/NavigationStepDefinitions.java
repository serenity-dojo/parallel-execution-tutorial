package com.serenitydojo.tutorials.ecommerce.stepdefinitions;

import com.serenitydojo.tutorials.ecommerce.pageobjects.MenuBar;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class NavigationStepDefinitions extends UIInteractionSteps {

    @Given("Olivia is shopping on the Luma site")
    public void olivia_is_shopping_on_the_Luma_site() {
        openUrl("https://magento.softwaretestingboard.com/");
    }

    List<String> menuBarItems;

    @When("she views the main menu bar")
    public void she_views_the_main_menu_bar() {
        menuBarItems = findAll(MenuBar.TOP_LEVEL_MENU_ITEMS).texts();
    }

    @Then("she should see the following items:")
    public void she_should_see_the_following_items(List<String> expectedCategories) {
        assertThat(menuBarItems).containsAll(expectedCategories);
    }


    @When("she views the subcategories of the {string} category")
    public void sheViewsTheSubcategoriesOfTheCategory(String category) {
        waitForVisibilityOf(MenuBar.category(category));
        moveTo(MenuBar.category(category));
    }

    private void waitForVisibilityOf(By elementLocator) {
        waitForCondition().withTimeoutOf(5).seconds().until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    @Then("she should be presented with the following subcategories: {commaSeparatedList}")
    public void sheShouldBePresentedWithTheFollowingSubcategoriesSubcategories(List<String> expectedSubcategories) {
        List<String> visibleSubcategories = findAll(MenuBar.SECOND_LEVEL_MENU_ITEMS).texts();

        assertThat(visibleSubcategories).containsAll(expectedSubcategories);
    }

    @When("she views the subcategories of the {string} subcategory in the {string} category")
    public void sheViewsTheSubcategoriesOfTheSubcategoryInTheCategory(String subcategory, String category) {
        waitForVisibilityOf(MenuBar.category(category));
        moveTo(MenuBar.category(category));
        moveTo(MenuBar.category(subcategory));
    }


    @Then("she should be presented with the following 2nd level subcategories: {commaSeparatedList}")
    public void sheShouldBePresentedWithTheFollowingNdLevelSubcategoriesSubSubCategories(List<String> expectedSubcategories) {
        List<String> visibleSubcategories = findAll(MenuBar.THIRD_LEVEL_MENU_ITEMS).texts();

        assertThat(visibleSubcategories).containsAll(expectedSubcategories);
    }
}
