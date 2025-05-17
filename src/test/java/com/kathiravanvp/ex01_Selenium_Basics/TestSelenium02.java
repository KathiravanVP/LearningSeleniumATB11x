package com.kathiravanvp.ex01_Selenium_Basics;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium02 {
    @Test
    public void test_selenium02(){
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com/");
        Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");
        driver.close();
    }
}
