package com.kathiravanvp.ex03_Selenium_Waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestSelenium13_Implicit_Wait {
    @Test
    public void Implicit_Wait(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");

        driver.quit();
    }
}
