package com.kathiravanvp.ex03_Selenium_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSelenium14_Explicit_Wait {
    @Test
    public void ExplicitWait(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://app.vwo.com/#/login");

        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("test@test.com");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("abc123");

        WebElement signIn_button = driver.findElement(By.xpath("//button[@id='js-login-btn']"));
        signIn_button.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='js-notification-box-msg']"))));

        WebElement error_message = driver.findElement(By.xpath("//div[@id='js-notification-box-msg']"));

        Assert.assertEquals(error_message.getText(),"Your email, password, IP address or location did not match");
        driver.quit();

    }
}
