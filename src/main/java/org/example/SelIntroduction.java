package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction {
    public static void main(String[] args) {
        // Invoking Browser
        // Chrome - Chrome Driver (gọi thực thi trình duyệt chrome do thực hiện)
        // chromedriver - selinium đc chrom cung cấp cho file exe để chạy trình duyệt
        // selenim khoong trực tiếp nói chuyện tương tác browser mà thông file exe
        // step to invoke chrome driver
        // Selenimum manage

//        System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver"); Ko nên hãy để Selenium tự động chạy
        WebDriver driver = new ChromeDriver(); // Hàm này tự động chạy
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");
        driver.findElement(By.className("submit")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        // Firefox
//        FirefoxDriver firefoxDriver = new FirefoxDriver();
    }
}
