package com.serenitydojo.tutorials.ecommerce.pageobjects;

import net.serenitybdd.core.pages.PageComponent;
import org.openqa.selenium.By;

import java.util.List;

public class MenuBar extends PageComponent {

    public static final By HOME_ICON = By.cssSelector(".logo");
    public static final By TOP_LEVEL_MENU_ITEMS = By.cssSelector(".category-item.level-top");
    public static final By SECOND_LEVEL_MENU_ITEMS = By.cssSelector(".level1.category-item");
    public static final By THIRD_LEVEL_MENU_ITEMS = By.cssSelector(".level2.category-item");
    public static final By SEARCH_BOX = By.id("search");
    public static final By MENU_DROPDOWN_CARETS = By.cssSelector(".navigation .ui-menu-icon");

    public static final By CART_ICON = By.cssSelector(".minicart-wrapper > a");

    public static By category(String categoryName) { return By.linkText(categoryName); }
    public static By subCategory(String categoryName) { return By.linkText(categoryName); }

    public void viewCartSummary() {
        $(MenuBar.CART_ICON).click();
    }

    public List<String> categories() {
        return findAll(MenuBar.TOP_LEVEL_MENU_ITEMS).texts();
    }

    public List<String> subCategories() {
        return findAll(MenuBar.SECOND_LEVEL_MENU_ITEMS).texts();
    }

    public List<String> subSubCategories() {
        return findAll(MenuBar.THIRD_LEVEL_MENU_ITEMS).texts();
    }

    public void searchFor(String keyword) {
        $(MenuBar.SEARCH_BOX).typeAndEnter(keyword);
    }
}
