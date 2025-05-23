package com.kathiravanvp.Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task03_Selenium_AppliTools {
    @Test
    public void Applitools_test(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.applitools.com/");

        driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("Password@123");

        driver.findElement(By.xpath("//a[@id=\"log-in\"]")).click();

        String first_part = "//table[@class=\"table table-padded\"]/tbody/tr[";
        String second_part = "]/td[";
        String third_part = "]";

        int row = driver.findElements(By.xpath("//table[@class=\"table table-padded\"]/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//table[@class=\"table table-padded\"]/tbody/tr[3]/td")).size();

        double expense = 0.0;

        for (int i=1;i<=row;i++){
            int j = 5;
            String dynamic_path = first_part+i+second_part+j+third_part;

            String value = driver.findElement(By.xpath(dynamic_path)).getText();
            String value1 = value.replace(",","");

            if (value1.contains("+")){
                String arr[] = value1.split(" ");
                double num = Double.parseDouble(arr[1]);
                expense = expense + num;
            } else if (value1.contains("-")){
                String arr[] = value.split(" ");
                double num = Double.parseDouble(arr[1]);
                expense = expense - num;
            }

        }
        Assert.assertEquals(expense,1996.22);
        System.out.println("Test Passed!");
        driver.quit();
    }
}
