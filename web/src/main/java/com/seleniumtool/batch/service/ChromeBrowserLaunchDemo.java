package com.seleniumtool.batch.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class ChromeBrowserLaunchDemo {


    public static void main(String[] args) throws InterruptedException {

        //Creating a driver object referencing WebDriver interface
        WebDriver driver;

        //Setting the webdriver.chrome.driver property to its executable's location
        System.setProperty("webdriver.edge.driver", "D:/custom-code/selenium/web/src/main/resources/msedgedriver.exe");

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new EdgeDriver(options);

        //Using get() method to open a webpage
        driver.get("http://192.168.99.66:8080/oneadmin/login");

        WebElement userName = driver.findElement(By.id("userid"));
        userName.sendKeys("olsadmin");
        Thread.sleep(1500);
        WebElement passWord = driver.findElement(By.name("pwd"));
        passWord.sendKeys("Oev@12345");
        Thread.sleep(1500);
        WebElement webElement = driver.findElement(By.className("btn-block"));
        webElement.click();
        Thread.sleep(2000);
        //Closing the browser
        driver.quit();

    }
}