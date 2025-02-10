package com.inventsys.tests;

import com.inventsys.factory.DriverFactory;
import com.inventsys.pages.ObjectImporterPage;
import com.inventsys.utils.ConfigReader;
import org.openqa.selenium.WebDriver;

public class Main {

    public static void main(String[] args) {
        WebDriver driver;

        driver = DriverFactory.getDriver();

        String configFilePath = "src/test/resources/config.properties";
        ConfigReader configReader = new ConfigReader(configFilePath);
        String filePath = configReader.getProperty("upload.file.path");
        driver.get(configReader.getProperty("website.url"));
        ObjectImporterPage importer = new ObjectImporterPage(driver);

        try {
            Thread.sleep(2000);
            importer.uploadFile(filePath);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Erro durante a execução: " + e.getMessage());
        } finally {
            DriverFactory.quitDriver();
        }
    }
}