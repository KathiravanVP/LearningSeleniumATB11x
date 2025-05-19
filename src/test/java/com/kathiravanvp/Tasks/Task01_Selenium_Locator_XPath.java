package com.kathiravanvp.Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Task01_Selenium_Locator_XPath {
    @Test(priority = 1)
    public void Task_OrangeHRM() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        Thread.sleep(3000);
        WebElement username = driver.findElement(By.xpath("//input[@placeholder = 'Username']"));
        username.sendKeys("test@test.com");

        WebElement password = driver.findElement(By.xpath("//input[@placeholder = 'Password']"));
        password.sendKeys("abc123");

        WebElement login_button = driver.findElement(By.xpath("//button[contains(@class,'login-button')]"));
        login_button.click();

        Thread.sleep(3000);

        WebElement alert = driver.findElement(By.xpath("//p[contains(@class,'alert')]"));
        System.out.println("Error - "+alert.getText());

        driver.quit();

    }

    @Test(priority = 2)
    public void Task_App_VWO() throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://vwo.com/free-trial/");

        WebElement email = driver.findElement(By.xpath("//input[@id='page-v1-step1-email']"));
        email.sendKeys("abc@test");

        WebElement checkbox = driver.findElement(By.xpath("//input[contains(@id,'page-free-trial-step1')]"));
        checkbox.click();

        WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Trial')]"));
        button.click();

        Thread.sleep(3000);

        WebElement alert = driver.findElement(By.xpath("//div[contains(text(),'incorrect')]"));
        System.out.println("Error - "+alert.getText());

        driver.quit();
    }
}
