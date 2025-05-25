package com.kathiravanvp.Tasks;

import com.kathiravanvp.CommonToAll.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.CommandLineArgs;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Task04_ExpoCRM_Automation {
    @Test
    public void Lead_Creation() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.us.espocrm.com/?l=en_US#");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text() = 'Login']")));

        driver.findElement(By.xpath("//button[text() = \"Login\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@data-name=\"Lead\"]")));

        WebElement leads = driver.findElement(By.xpath("//li[@data-name=\"Lead\"]"));
        leads.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=\"Create Lead\"]")));

        driver.findElement(By.xpath("//span[text()=\"Create Lead\"]")).click();

        WebElement salutation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"col-sm-3 col-xs-3\"]")));
        salutation.click();

        driver.findElement(By.xpath("//div[text()=\"Mr.\"]")).click();

        driver.findElement(By.xpath("//input[@data-name=\"firstName\"]")).sendKeys("Jojo");
        driver.findElement(By.xpath("//input[@data-name=\"lastName\"]")).sendKeys("Geon");
        driver.findElement(By.xpath("//button[text()=\"Save\"]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[text()='Leads']")).click();

        driver.findElement(By.xpath("//input[@data-name=\"textFilter\"]")).sendKeys("Jojo");
        driver.findElement(By.xpath("//span[@class=\"fas fa-search\"]")).click();

        String first_part = "//table[@class='table ']/tbody/tr[";
        String second_part = "]/td[";
        String third_part = "]";

        int row = driver.findElements(By.xpath("//table[@class='table ']/tbody/tr")).size();

        for(int i=1;i<=row;i++){
            int j=2;
            String dynamic_path = first_part+i+second_part+j+third_part;
            String name = driver.findElement(By.xpath(dynamic_path)).getText();
            if (name.contains("Jojo Geon")){
                System.out.println("Test Case Passed!!!");
            }
        }
        Thread.sleep(2000);
        driver.quit();
    }
}
