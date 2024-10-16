package com.topicus.Keyword;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Keyword {
    private final WebDriver _driver;

    public Keyword(WebDriver driver){
        _driver = driver;
    }

    private WebElement GetElement(By by){

        return _driver.findElement(by);
    }

    public void ClickOn(By by){
        GetElement(by).click();
    }

    public void SendKey(By by, String text){
        GetElement(by).sendKeys(text);
    }

    public void SelectDropdown(By by, String value){
        new Select(GetElement(by)).selectByVisibleText(value);
    }

    public void VerifyElementAppear(By by){
        try{
            Assert.assertTrue(GetElement(by).isDisplayed());
        } catch (Exception e){
            Assert.fail("Element is not displayed");
        }
    }

    public void VerifyElementHasText(By by, String text){
        try{
            Assert.assertEquals(GetElement(by).getText(), text);
        } catch (NotFoundException e){
            Assert.fail("Element is not displayed");
        }
    }
}
