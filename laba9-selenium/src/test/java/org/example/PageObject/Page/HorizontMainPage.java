package org.example.PageObject.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// page_url = https://horizont.by/
public class HorizontMainPage {

    public HorizontMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    WebDriver driver;

     @FindBy(xpath ="//span[text()='RU']" )
     WebElement RULanguageButton;
     @FindBy(xpath ="//span[text()='EN']" )
    WebElement EngLanguageButton;
     @FindBy(xpath = "//*[contains(@class,'elementor-heading-title elementor-size-default')]")
     WebElement WelcomeMessage;

    public HorizontMainPage OpenPage()
    {
        driver.get("https://horizont.by/");
        return this;
    }

    public HorizontMainPage ChangeLanguage()
    {

        Actions builder = new Actions(driver);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(RULanguageButton));
        builder.moveToElement(RULanguageButton).perform();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(EngLanguageButton));
        EngLanguageButton.click();
        return this;
    }
    public String getMainPageWelcomeMessage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(WelcomeMessage));
        return WelcomeMessage.getText();
    }


}