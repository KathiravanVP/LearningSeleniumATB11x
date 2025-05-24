package com.kathiravanvp.Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task04_Ebay_Automation {
    @Test
    public void Ebay_Automation(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.ebay.com/b/PC-Desktops-All-In-One-Computers/179/bn_661752");

        driver.findElement(By.xpath("//input[@id=\"gh-ac\"]")).sendKeys("macmini");
        driver.findElement(By.xpath("//span[text()=\"Search\"]")).click();


        String first_part = "//ul[@class=\"srp-results srp-list clearfix\"]/li";
        String title = ".//span[@role=\"heading\"]";
        String price = ".//span[@class=\"s-item__price\"]";

        List<WebElement> search_result = driver.findElements(By.xpath(first_part));

        //List of product and their prices
        for (WebElement e : search_result){
            if (!e.getDomAttribute("class").contains("BASIC_PAGINATION")) {
                String product_title = e.findElement(By.xpath(title)).getText();
                String product_price = e.findElement(By.xpath(price)).getText();
                System.out.println(product_title + " ----> " + product_price);
            }
        }
        List<Double> all_prices =  new ArrayList();

        //Min Price in first page
        for (WebElement e : search_result){
            if (!e.getDomAttribute("class").contains("BASIC_PAGINATION")) {
                String product_price = e.findElement(By.xpath(price)).getText();
                String num = product_price.replace("$","");
                String arr[] = num.split(" ");
                double amt = Double.parseDouble(arr[0]);
                all_prices.add(amt);
            }
        }
        double min_price = Collections.min(all_prices);
        System.out.println("\nMinimum price in first page = $"+min_price);

        driver.quit();


    }
}
