package com.kathiravanvp.ex09_DataDriven_Testing;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestSelenium31_DDT {
    @Test(dataProvider = "getData")
    public void getData(String email,String password){
        System.out.println(email+" || "+password);
    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                new Object[]{"admin@gmail.com", "pass123"},
                new Object[]{"admin123@gmail.com", "pass123"},
                new Object[]{"admin125@gmail.com", "pass125"},
                new Object[]{"admin126@gmail.com", "pass126"},
                new Object[]{"admin127@gmail.com", "pass127"},
                new Object[]{"admin129@gmail.com", "pass129"},
                new Object[]{"admin130@gmail.com", "pass130"},
                new Object[]{"admin132@gmail.com", "pass132"},
                new Object[]{"admin135@gmail.com", "pass135"}
        };
    }
}
