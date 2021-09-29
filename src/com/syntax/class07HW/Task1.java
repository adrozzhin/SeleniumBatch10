package com.syntax.class07HW;

/*
Go to https://demoqa.com/browser-windows
click on New Tab and print the text from new tab in the console
click on New Window and print the text from new window in the console
click on New Window Message and print the text from new window in the console
Verify the title is displayed
Print out the title of the all pages
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Task1 {
    public static String url = "https://demoqa.com/browser-windows";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        String mainPageHandle = driver.getWindowHandle();
        System.out.println(mainPageHandle);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement newTabButton = driver.findElement(By.xpath("//button[text() = 'New Tab']"));
        WebElement newWindowButton = driver.findElement(By.xpath("//button[text() = 'New Window']"));
        //WebElement newWindowMessageButton = driver.findElement(By.xpath("//button[text() = 'New Window Message']"));
        newTabButton.click();
        newWindowButton.click();
        //newWindowMessageButton.click();

        Set<String> allWindowsHandles = driver.getWindowHandles();
        System.out.println(allWindowsHandles.size());

        Iterator<String> it = allWindowsHandles.iterator();
        mainPageHandle = it.next();
        String newTabHandle = it.next();
        String newWindowHandle = it.next();
        //String newWindowMessageHandle = it.next();
        System.out.println(newTabHandle);
        System.out.println(newWindowHandle);
        //System.out.println(newWindowMessageHandle);

        driver.switchTo().window(newTabHandle);
        WebElement newTabText = driver.findElement(By.id("sampleHeading"));
        System.out.println("New tab text: " + newTabText.getText());
        //driver.close();

        driver.switchTo().window(newWindowHandle);
        WebElement newWindowText = driver.findElement(By.id("sampleHeading"));
        System.out.println("New window text: " + newWindowText.getText());

//        driver.switchTo().window(newWindowMessageHandle);
//        WebElement newWindowMessageText = driver.findElement(By.xpath("//body[contains(text(),'Knowledge')]"));
//        System.out.println("New Window Message text: " + newWindowMessageText.getText());
//        driver.switchTo().window(mainPageHandle);
//        newWindowButton.click();
//        String newWindowHandle = it.next();
//        System.out.println(newWindowHandle);
//        driver.switchTo().window(newWindowHandle);
//        WebElement newWindowText = driver.findElement(By.linkText("This is a sample page"));
//        System.out.println("New window text: " +newWindowText.getText());
    }
}