package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class TestFunctions {
    protected WebDriver driver;

    public void setUp() {
        // Seteás el path del driver antes de crear el ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IvanGomez\\Documents\\QAAcademy\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return driver;
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getElementText(String xpath) {
        return driver.findElement(By.xpath(xpath)).getText();
    }

    public List<String> getItemsFromElement(String xpath) {
        List<WebElement> elements = driver.findElements(By.xpath(xpath));
        List<String> texts = new ArrayList<>();

        for (WebElement element : elements) {
            texts.add(element.getText());
        }
        return texts;
    }

    public void waitSeconds(int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    public WebElement waitElementVisible(String xpath) {
        try {
            if (driver.findElement(By.xpath(xpath)) != null) {
                WebElement element = driver.findElement(By.xpath(xpath));
                System.out.println("Element found: " + element.getText());
                return element;
            }
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + xpath);
        }
        return null;
    }

    public boolean elementExists(String xpath) {
        return driver.findElement(By.xpath(xpath)).isDisplayed();
    }

    public int countNumberedElements(String xpathPartOne, String xpathPartTwo) {
        int count = 0;
        while (true) {
            String xpath = xpathPartOne + (count + 2) + xpathPartTwo;
            try {
                if (driver != null || driver.findElement(By.xpath(xpath)) != null) {
                    System.out.println(driver.findElement(By.xpath(xpath)));
                    count++;
                }
            } catch (NoSuchElementException e) {
                break;
            }
        }
        return count;
    }

    public int countUnorderedListItems(String xpath) {
        List<WebElement> items = driver.findElements(By.xpath(xpath + "/li"));
        return items.size();
    }
}
