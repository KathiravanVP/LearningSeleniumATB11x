package com.kathiravanvp.ex03_Selenium_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class TestSelenium15_Fluent_Wait {
    @Test
    public void FluentWait() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://app.vwo.com/#/login");

        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("test@test.com");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("abc123");

        WebElement signIn_button = driver.findElement(By.xpath("//button[@id='js-login-btn']"));
        signIn_button.click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

        WebElement error_message = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(By.xpath("//div[@id='js-notification-box-msg']"));
            }
        });

        Assert.assertEquals(error_message.getText(),"Your email, password, IP address or location did not match");
        driver.quit();


    }
}
