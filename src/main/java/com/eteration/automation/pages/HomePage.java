package com.eteration.automation.pages;

import com.eteration.automation.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePageObject {
    
    @FindBy(css = "nav.main-navigation")
    private WebElement mainNavigationMenu;
    
    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    public void navigateToHomePage() {
        String baseUrl = ConfigReader.getProperty("base.url");
        driver.get(baseUrl);
        log.info("Navigated to homepage: {}", baseUrl);
        waitForPageLoad();
    }
    
    public String getPageTitle() {
        String title = driver.getTitle();
        log.info("Page title is: {}", title);
        return title;
    }
    
    public boolean isMainNavigationMenuDisplayed() {
        boolean isDisplayed = isDisplayed(mainNavigationMenu);
        log.info("Main navigation menu is displayed: {}", isDisplayed);
        return isDisplayed;
    }
} 