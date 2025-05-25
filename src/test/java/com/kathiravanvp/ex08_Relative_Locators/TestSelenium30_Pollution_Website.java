package com.kathiravanvp.ex08_Relative_Locators;

import com.kathiravanvp.CommonToAll.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class TestSelenium30_Pollution_Website extends CommonToAll {
    @Test
    public void most_polluted_Indian_city(){
        driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");

        WebElement searchbox = driver.findElement(By.xpath("//input[@placeholder=\"Search\"]"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Search\"]")));

        Actions actions = new Actions(driver);
        actions.moveToElement(searchbox).click().sendKeys("India").build().perform();

        waitForJVM(5000);

        List<WebElement> locations = driver.findElements(By.xpath("//div[contains(@class,\"location-name\")]/p"));

        for (WebElement location: locations){

            String rank = driver.findElement(with(By.tagName("p")).toLeftOf(location)).getText();
            String aqi = driver.findElement(with(By.tagName("span")).toRightOf(location)).getText();

            System.out.println("| +" + rank + " | " + location.getText() + " | " + aqi + " | ");

        }
    }
}
