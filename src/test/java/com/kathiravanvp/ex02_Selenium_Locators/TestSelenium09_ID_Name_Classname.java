package com.kathiravanvp.ex02_Selenium_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium09_ID_Name_Classname {
    @Test
    public void selenium_locators1() throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com/#/login");

        WebElement email = driver.findElement(By.id("login-username"));
        email.sendKeys("test@test.com");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("abc123");

        WebElement signin_button = driver.findElement(By.id("js-login-btn"));
        signin_button.click();

        Thread.sleep(3000);

        WebElement error_message = driver.findElement(By.className("notification-box-description"));
        System.out.println("Error message - "+error_message.getText());

        Assert.assertEquals(error_message.getText(),"Your email, password, IP address or location did not match");
        driver.quit();
    }
}
