package org.example.driver;

import org.example.config.ConfigReader;
import org.example.config.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    public static WebDriver create() {
        return new ChromeDriver();
    }

    public WebDriver createDriver(Environment env) {
        ConfigReader config = new ConfigReader(env);
        WebDriver driver = DriverFactory.create();
        driver.get(config.get("base.url"));
        return driver;
    }
}
