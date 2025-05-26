package com.kathiravanvp.ex09_DataDriven_Testing;

import com.kathiravanvp.CommonToAll.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSelenium32_DDT_VWO extends CommonToAll {
    @Test(dataProvider = "getData")
    public void getData(String email,String password){

        driver.navigate().to("https://app.vwo.com");
        System.out.println(driver.getTitle());

        Assert.assertEquals(driver.getTitle(), "Login - VWO");

        driver.findElement(By.id("login-username")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);

        driver.findElement(By.id("js-login-btn")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("notification-box-description")));

        WebElement error_message = driver.findElement(By.className("notification-box-description"));
        Assert.assertEquals(error_message.getText(), "Your email, password, IP address or location did not match");
    }
    @DataProvider
    public Object[][] getData(){
        return UtilExcel.getTestDataFromExcel("Sheet1");
    }
}
