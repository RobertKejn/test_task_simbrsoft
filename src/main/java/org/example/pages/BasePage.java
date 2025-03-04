package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    public static WebDriver driver;

    public void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    protected void set(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void scroll(By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", find(locator));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(driver ->
        {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Boolean isFullyVisible = (Boolean) js.executeScript(
                    "var rect = arguments[0].getBoundingClientRect();" +
                            "return (rect.top >= 50 && rect.bottom <= window.innerHeight - 50);",
                    find(locator));
            return isFullyVisible;
        });
    }

    protected void click(By locator) {
        find(locator).click();
    }

}
