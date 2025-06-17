package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class TestFunctions {
    protected WebDriver driver;

    public void setUp() {
        // Seteás el path del driver antes de crear el ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void getUrl(String url) {
        driver.get(url);
    }

    public void clickElement(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
