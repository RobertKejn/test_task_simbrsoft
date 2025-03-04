package org.example.test.tests.fromfields;

import org.example.test.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormFieldsPageTest extends BaseTest {

    @Test
    public void testFillFormFields() throws InterruptedException {
        formFieldsPage.setName("Name");
        formFieldsPage.setPassword("Password");

//         выбрать напитки и цвета можно и по id, и по xpath. по xpath по идее расширять удобнее будет

//        xpath
        formFieldsPage.clickFavouriteDrinksCheckBoxes("Milk", "Coffee");
        formFieldsPage.clickFavouriteColorsCheckBoxes("Yellow");

//        id
//        formFieldsPage.clickMilkCheckBox();
//        formFieldsPage.clickCoffeeCheckBox();
//        formFieldsPage.clickYellowRadio();

        formFieldsPage.selectAutomationRandomOption();

        formFieldsPage.setEmail("name@example.com");

        formFieldsPage.setMessageWithToolSizeAndLargestTool();

//        Thread.sleep(5000); // задержка для просмотра содержимого (необязательная)

        formFieldsPage.clickSubmitButton();

        String alertText = formFieldsPage.waitForMessageReceivedAlert();
        String expectedAlertText = "Message received!";
        Assert.assertEquals(alertText, expectedAlertText);
    }
}
