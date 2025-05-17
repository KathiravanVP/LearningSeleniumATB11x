package com.kathiravanvp.ex01_Selenium_Basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class TestSelenium07_Option_Class {
    public static void main(String[] args) {
        EdgeOptions edgeOptions = new EdgeOptions();

        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.google.com/");

        driver.quit();
    }
}
