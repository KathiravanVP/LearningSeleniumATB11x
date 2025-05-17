package com.kathiravanvp.ex01_Selenium_Basics;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestSelenium01 {

    @Test
    public void open_VWO_LoginPage(){
        EdgeDriver edgeDriver = new EdgeDriver();
        edgeDriver.get("https://app.vwo.com/");
        System.out.println(edgeDriver.getTitle());
        edgeDriver.close();
    }
}
