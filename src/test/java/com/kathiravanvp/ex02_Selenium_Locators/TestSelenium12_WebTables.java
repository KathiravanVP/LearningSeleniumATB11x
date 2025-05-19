package com.kathiravanvp.ex02_Selenium_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class TestSelenium12_WebTables {
    @Test
    public void WebTables01(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://awesomeqa.com/webtable.html");

        String first_part = "//table[@id='customers']/tbody/tr[";
        String second_part = "]/td[";
        String third_part = "]";

        int row = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td")).size();

        for (int i=2;i<=row;i++){
            for (int j=1;j<=col;j++){
                String dynamic_path = first_part+i+second_part+j+third_part;
                String data = driver.findElement(By.xpath(dynamic_path)).getText();
                System.out.print(data);
                System.out.print(" ");
            }
            System.out.println();
        }
        driver.quit();
    }
}
