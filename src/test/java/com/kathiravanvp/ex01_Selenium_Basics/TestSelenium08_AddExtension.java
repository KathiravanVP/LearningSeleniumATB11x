package com.kathiravanvp.ex01_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class TestSelenium08_AddExtension {
    @Test
    public void test_AddExtension(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addExtensions(new File("src/test/java/com/kathiravanvp/ex01_Selenium_Basics/AdBlock.crx"));

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.youtube.com/watch?v=6LD30ChPsSs&list=RD6LD30ChPsSs&start_radio=1");
        driver.manage().deleteAllCookies();
        driver.quit();

    }
}
