package com.kathiravanvp.ex01_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium05_MiniProj_Selenium {
    @Test
    public void test_selenium01(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com");

        if(driver.getPageSource().contains("CURA Healthcare Service")){
            Assert.assertTrue(true);
            System.out.println("Test Passed");
        }
        else {
            Assert.fail("CURA Healthcare Service - test is not visible");
        }
        driver.quit();
    }
}
