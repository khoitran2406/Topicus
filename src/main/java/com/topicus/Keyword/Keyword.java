package com.topicus.Keyword;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.time.Duration;

public class Keyword {
    private final WebDriver _driver;
    private WebDriverWait wait;
    private int timeout = 10;

    private void SetTimeout(int timeout){
        wait = new WebDriverWait(_driver, Duration.ofSeconds(timeout));
    }

    public Keyword(WebDriver driver){
        _driver = driver;
        SetTimeout(timeout);
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

    public void SendActionKey(Keys key){
        var action = new Actions(_driver);
        action.sendKeys(key).perform();
        action.release().perform();
    }

    public void SelectDropdown(By by, String value){
        new Select(GetElement(by)).selectByVisibleText(value);
    }

    public void WaitForElementDisplayed(By by){
        wait.until(d -> GetElement(by).isDisplayed());
    }

    public void WaitForElementClickable(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void VerifyElementAppear(By by){
        try{
            WaitForElementDisplayed(by);
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
