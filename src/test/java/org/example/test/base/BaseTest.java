package org.example.test.base;

import org.example.pages.BasePage;
import org.example.pages.FormFieldsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;
    protected FormFieldsPage formFieldsPage;
    private String url = "https://practice-automation.com/form-fields/";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        basePage = new BasePage();
        basePage.setDriver(driver);
        formFieldsPage = new FormFieldsPage();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
