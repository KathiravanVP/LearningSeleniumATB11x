package com.kathiravanvp.Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Task02_Selenium_Katalon_Site {
    @Test
    public void Katalon_full_flow(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement make_app = driver.findElement(By.xpath("//a[@id=\"btn-make-appointment\"]"));
        make_app.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),\"Login\")]")));

        List<WebElement> forms = driver.findElements(By.xpath("//input[@class=\"form-control\"]"));

        String demo_username = forms.get(0).getDomAttribute("value");
        String demo_password = forms.get(1).getDomAttribute("value");

        WebElement username = driver.findElement(By.xpath("//input[@id=\"txt-username\"]"));
        username.sendKeys(demo_username);

        WebElement password = driver.findElement(By.xpath("//input[@id=\"txt-password\"]"));
        password.sendKeys(demo_password);


        WebElement login_button = driver.findElement(By.xpath("//button[@id=\"btn-login\"]"));
        login_button.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),\"Make\")]")));

        WebElement facility = driver.findElement(By.xpath("//select[@id=\"combo_facility\"]"));

        Select select = new Select(facility);
        select.selectByIndex(1);

        WebElement apply_checkbox = driver.findElement(By.xpath("//input[@id=\"chk_hospotal_readmission\"]"));
        apply_checkbox.click();

        WebElement program = driver.findElement(By.xpath("//input[@id=\"radio_program_medicaid\"]"));
        program.click();

        WebElement date = driver.findElement(By.xpath("//input[@name=\"visit_date\"]"));
        date.sendKeys("23/05/2025");

        WebElement comments = driver.findElement(By.xpath("//textarea[@name=\"comment\"]"));
        comments.sendKeys("This is an e2e automated flow");

        WebElement book_app = driver.findElement(By.xpath("//button[contains(text(),\"Book\")]"));
        book_app.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),\"Appointment\")]")));
        System.out.println(driver.findElement(By.xpath("//h2[contains(text(),\"Appointment\")]")).getText());

        driver.quit();

    }
}
