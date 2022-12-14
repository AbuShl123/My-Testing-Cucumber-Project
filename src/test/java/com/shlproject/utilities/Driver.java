package com.shlproject.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Driver {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = ConfigurationReader.getProperty("browser");

            switch (browser) {
                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(); break;
                case "edge" :
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver(); break;
            }

            driver.manage().window().maximize();
        }

        return driver;
    }

    public static void closeDriver() {
        driver.close();
    }
}
