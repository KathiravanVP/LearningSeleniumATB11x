package com.kathiravanvp.ex04_Input_Select_Alerts_Radio_Checkbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestSelenium16_Input_Checkbox_Radio {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://awesomeqa.com/practice.html");

        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Kathiravan");

        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("VP");

        driver.findElement(By.xpath("//input[@id='sex-0']")).click();

        driver.findElement(By.xpath("//input[@id='exp-3']")).click();

        driver.findElement(By.xpath("//input[@id='profession-0']")).click();

        driver.findElement(By.xpath("//input[@id='profession-1']")).click();

        driver.quit();
    }
}
