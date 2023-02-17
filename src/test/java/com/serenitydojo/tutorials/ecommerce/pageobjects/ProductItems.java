package com.serenitydojo.tutorials.ecommerce.pageobjects;

import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.screenplay.targets.SearchableTarget;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.PageElement;

public class ProductItems extends PageComponent {
    public static SearchableTarget productBoxFor(String productItemName) {
        return PageElement.locatedBy(".product-item").containingText(productItemName);
    }

    public static SearchableTarget addCartButtonFor(String productItemName) {
        return Button.containingText("Add to Cart").inside(productBoxFor(productItemName));
    }

    public void viewProductDetailsFor(String productItemName) {
        $(ProductItems.productBoxFor(productItemName)).click();
    }

}
