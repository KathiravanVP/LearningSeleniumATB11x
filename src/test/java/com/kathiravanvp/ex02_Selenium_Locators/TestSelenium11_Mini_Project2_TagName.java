package com.kathiravanvp.ex02_Selenium_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium11_Mini_Project2_TagName {
    @Test
    public void selenium_locators2() throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com/#/login");

        WebElement partial_trial = driver.findElement(By.partialLinkText("trial"));
        partial_trial.click();

        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("free-trial"));

        WebElement email = driver.findElement(By.id("page-v1-step1-email"));
        email.sendKeys("abc123");

        WebElement checkbox = driver.findElement(By.id("page-free-trial-step1-cu-gdpr-consent-checkbox"));
        checkbox.click();

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();

        Thread.sleep(3000);

        WebElement error_message = driver.findElement(By.className("invalid-reason"));
        System.out.println("Error message - "+error_message.getText());

        Assert.assertEquals(error_message.getText(),"The email address you entered is incorrect.");
        driver.quit();
    }
}
