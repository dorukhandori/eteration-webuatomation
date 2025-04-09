package com.eteration.automation.stepdefinitions;

import com.eteration.automation.driver.DriverManager;
import com.eteration.automation.pages.HomePage;
import io.cucumber.java.tr.Diyelimki;
import io.cucumber.java.tr.Ozaman;
import io.cucumber.java.tr.Ve;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePageSteps {
    
    private final WebDriver driver;
    private final HomePage homePage;
    
    public HomePageSteps() {
        this.driver = DriverManager.getDriver();
        this.homePage = new HomePage(driver);
    }
    
    @Diyelimki("kullanıcı anasayfaya gider")
    public void userNavigatesToHomePage() {
        homePage.navigateToHomePage();
    }
    
    @Ozaman("sayfa başlığı {string} içermelidir")
    public void pageTitleShouldContain(String expectedTitle) {
        String actualTitle = homePage.getPageTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle), 
                "Sayfa başlığı '" + expectedTitle + "' içermiyor. Gerçek başlık: " + actualTitle);
    }
    
    @Ve("ana navigasyon menüsü görüntülenmelidir")
    public void mainNavigationMenuShouldBeDisplayed() {
        Assert.assertTrue(homePage.isMainNavigationMenuDisplayed(), 
                "Ana navigasyon menüsü görüntülenmiyor");
    }
} 