package org.example.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class FormFieldsPage extends BasePage {
    private By nameField = By.id("name-input");
    private By passwordField = By.cssSelector("input[type='password']"); // здесь можно было и через xpath,
    private String favouriteDrinkXpath = "//input[@type='checkbox' and @name='fav_drink' and @value = '%s']";
    private By milkCheckBoxDrink2 = By.id("drink2");
    private By coffeeCheckBoxDrink3 = By.id("drink3");
    private String favouriteColourXpath = "//input[@type='radio' and @name='fav_color' and @value = '%s']";
    private By yellowRadioColor3 = By.id("color3");
    private By automationSelect = By.id("automation");
    private By automationToolsXpath = By.xpath("//label[text()='Automation tools']/following-sibling::ul/li");
    private By emailField = By.id("email");
    private By mesageField = By.id("message");
    private By submitButton = By.id("submit-btn");

    public void setName(String name) {
        scroll(nameField);
        set(nameField, name);
    }

    public void setPassword(String password) {
        scroll(passwordField);
        set(passwordField, password);
    }

    public void clickFavouriteDrinksCheckBoxes(String... drinks){
        for(String drink : drinks){
            String xpath = String.format(favouriteDrinkXpath, drink);
            scroll(By.xpath(xpath));
            click(By.xpath(xpath));
        }
    }
    public void clickMilkCheckBox() {
        scroll(milkCheckBoxDrink2);
        click(milkCheckBoxDrink2);
    }

    public void clickCoffeeCheckBox() {
        scroll(coffeeCheckBoxDrink3);
        click(coffeeCheckBoxDrink3);
    }

    public void clickFavouriteColorsCheckBoxes(String... colors){
        for(String color : colors){
            String xpath = String.format(favouriteColourXpath, color);
            scroll(By.xpath(xpath));
            click(By.xpath(xpath));
        }
    }
    public void clickYellowRadio() {
        scroll(yellowRadioColor3);
        click(yellowRadioColor3);
    }

    public void selectAutomationRandomOption() {
        scroll(automationSelect);
        WebElement selectElement = find(automationSelect);
        Select select = new Select(selectElement);
        List<WebElement> options = select.getOptions();
        Random random = new Random();
        int randomOption = random.nextInt(0, options.size());
        select.selectByIndex(randomOption);
    }

    public void setEmail(String email) {
        scroll(emailField);
        set(emailField, email);
    }

    public String createMessageOfToolsSizeAndLargestTool(){
        List<WebElement> elements = driver.findElements(automationToolsXpath);
        String largestTool = "";
        for (var e : elements) {
            if (e.getText().length() > largestTool.length()) largestTool = e.getText();
        }
        return elements.size() + " " + largestTool;
    }
    public void setMessage(String message) {
        scroll(mesageField);
        set(mesageField, message);
    }

    public void setMessageWithToolSizeAndLargestTool(){
        String message = createMessageOfToolsSizeAndLargestTool();
        setMessage(message);
    }

    public void clickSubmitButton() {
        scroll(submitButton);
        click(submitButton);
    }

    public String waitForMessageReceivedAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();

        return alert.getText();
    }
}
