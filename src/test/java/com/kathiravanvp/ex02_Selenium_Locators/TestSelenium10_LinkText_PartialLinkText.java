package com.kathiravanvp.ex02_Selenium_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class TestSelenium10_LinkText_PartialLinkText {
    @Test
    public void selenium_locators2() throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com/#/login");

        WebElement full_trial = driver.findElement(By.linkText("Start a free trial"));
        full_trial.click();

        System.out.println("Link Text Title - "+driver.getTitle());

        driver.navigate().to("https://app.vwo.com/#/login");

        WebElement partial_trial = driver.findElement(By.partialLinkText("trial"));
        partial_trial.click();

        System.out.println("Partial Link Text Title - "+driver.getTitle());

        driver.quit();
    }
}
