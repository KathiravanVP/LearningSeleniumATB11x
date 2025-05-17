package com.kathiravanvp.ex01_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestSelenium04_Assertions {

    @Test
    public void test_Method() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        Assert.assertEquals(driver.getTitle(),"Google");

        assertThat(driver.getCurrentUrl()).isNotNull().isEqualTo("https://www.google.com/");
        driver.quit();
    }
}
