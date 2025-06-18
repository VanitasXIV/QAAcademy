package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    public String getElementText(String xpath) {
        return driver.findElement(By.xpath(xpath)).getText();
    }

    public void waitSeconds(int seconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    public WebElement waitElementVisible(String xpath){
        try{
            WebElement element = driver.findElement(By.xpath(xpath));
            System.out.println("Element found: " + element.getText());
            return element;
        } catch (NoSuchElementException e){
            System.out.println("Element not found: " + xpath);
        }
        return null;
    }

    public boolean elementExists(String xpath){
        return driver.findElement(By.xpath(xpath)).isDisplayed();
    }
}
