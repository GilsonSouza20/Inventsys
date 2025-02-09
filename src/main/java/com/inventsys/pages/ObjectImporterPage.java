package com.inventsys.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ObjectImporterPage {
    private WebDriver driver;
    private String driverPath;
    private String websiteUrl;

    public ObjectImporterPage(String driverPath, String websiteUrl) {
        this.driverPath = driverPath;
        this.websiteUrl = websiteUrl;
    }

    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(websiteUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void uploadFile(String filePath, By inputElementLocator) {
        try {
            WebElement fileInput = driver.findElement(inputElementLocator);
            fileInput.sendKeys(filePath);
            System.out.println("Arquivo " + filePath + " enviado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao enviar o arquivo: " + e.getMessage());
        }
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
            System.out.println("Navegador fechado.");
        }
    }
}

