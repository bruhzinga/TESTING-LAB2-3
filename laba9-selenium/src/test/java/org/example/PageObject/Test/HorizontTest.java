package org.example.PageObject.Test;

import org.example.PageObject.Page.HorizontMainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HorizontTest {

    private  WebDriver driver;

    @BeforeEach
    public void setUp() throws Exception {
         driver = new ChromeDriver();
    }
    @Test
    public void ChangeSitesLanguageAndVerify()
    {
    var horizontMainPage = new HorizontMainPage(driver);
     String mainMessage= horizontMainPage.OpenPage()
            .ChangeLanguage()
            .getMainPageWelcomeMessage();
    Assertions.assertEquals("Rich and natural colors", mainMessage);
    }
    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }
}

