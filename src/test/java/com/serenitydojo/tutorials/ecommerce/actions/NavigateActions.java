package com.serenitydojo.tutorials.ecommerce.actions;

import com.serenitydojo.tutorials.ecommerce.pageobjects.MenuBar;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.serenitydojo.tutorials.ecommerce.pageobjects.MenuBar.MENU_DROPDOWN_CARETS;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class NavigateActions extends UIInteractionSteps {

    @Step("Open the Luma application")
    public void toTheLumaApplication() {
        openUrl("https://magento.softwaretestingboard.com/");
        waitForCondition().until(visibilityOfElementLocated(MENU_DROPDOWN_CARETS));
    }

    @Step("Navigate to the Luma home page")
    public void toTheHomePage() {
        $(MenuBar.HOME_ICON).click();
    }
}
