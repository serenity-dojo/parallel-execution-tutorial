package com.serenitydojo.tutorials.ecommerce.pageobjects;

import com.serenitydojo.tutorials.ecommerce.stepdefinitions.CartItem;
import net.serenitybdd.core.pages.PageComponent;

import java.util.List;

public class CartSummaryPanel extends PageComponent {

    private static final String MINICART_PRODUCT_ITEM_DETAILS = ".block-minicart .product-item-details";
    private static final String PRODUCT_ITEM_NAME = ".product-item-name a";
    private static final String PRODUCT_ITEM_PRICE = ".price-excluding-tax .price";

    public List<CartItem> displayedCartItems() {
        return findAll(MINICART_PRODUCT_ITEM_DETAILS).map(
                item -> new CartItem(
                        item.findBy(PRODUCT_ITEM_NAME).getTextContent(),
                        item.findBy(PRODUCT_ITEM_PRICE).getTextContent()
                )
        );
    }
}
