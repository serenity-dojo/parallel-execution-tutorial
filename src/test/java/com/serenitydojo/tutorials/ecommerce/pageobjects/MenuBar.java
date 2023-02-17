package com.serenitydojo.tutorials.ecommerce.pageobjects;

import org.openqa.selenium.By;

public class MenuBar {
    public static final By TOP_LEVEL_MENU_ITEMS = By.cssSelector(".category-item.level-top");
    public static final By SECOND_LEVEL_MENU_ITEMS = By.cssSelector(".level1.category-item");
    public static final By THIRD_LEVEL_MENU_ITEMS = By.cssSelector(".level2.category-item");
    public static final By SEARCH_BOX = By.id("search");

    public static By category(String categoryName) { return By.linkText(categoryName); }
    public static By subCategory(String categoryName) { return By.linkText(categoryName); }

}
