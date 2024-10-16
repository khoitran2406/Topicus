package com.topicus.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() { return driver; }

    public static WebDriver initDriver(BrowserType browserType) throws Exception {
        switch (browserType) {
            case CHROME:
                driver = InitChromeDriver();
                driver.manage().window().maximize();
                return driver;
            case EDGE:
                driver = InitEdgeDriver();
                driver.manage().window().maximize();
                return driver;
            case FIREFOX:
                driver = InitFirefoxDriver();
                driver.manage().window().maximize();
                return driver;
            default:
                throw new Exception("Browser type is not supported");
        }
    }

    private static WebDriver InitChromeDriver(){
        return new ChromeDriver();
    }

    private static WebDriver InitEdgeDriver(){
        return new EdgeDriver();
    }

    private static WebDriver InitFirefoxDriver(){
        return new FirefoxDriver();
    }
}
