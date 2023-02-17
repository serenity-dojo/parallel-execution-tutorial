package com.serenitydojo.tutorials.ecommerce.pageobjects;

import net.serenitybdd.core.pages.PageComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailsPanel extends PageComponent {
    public static By ADD_TO_CART_BUTTON = By.cssSelector(".product-info-main button[title='Add to Cart']");

    public void addToCart() {
        $(ProductDetailsPanel.ADD_TO_CART_BUTTON).click();
        waitForCondition().until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-mask")));
    }
}
