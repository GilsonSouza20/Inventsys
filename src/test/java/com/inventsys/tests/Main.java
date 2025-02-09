package com.inventsys.tests;

import com.inventsys.pages.ObjectImporterPage;
import com.inventsys.utils.ConfigReader;

import org.openqa.selenium.By;

public class Main {
    public static void main(String[] args) {
        String configFilePath = "src/test/resources/config.properties";
        String locatorsFilePath = "src/test/resources/locators.properties";

        ConfigReader configReader = new ConfigReader(configFilePath);
        String driverPath = configReader.getProperty("chrome.driver.path");
        String websiteUrl = configReader.getProperty("website.url");
        String filePath = configReader.getProperty("upload.file.path");

        ConfigReader locatorsReader = new ConfigReader(locatorsFilePath);
        String inputLocator = locatorsReader.getProperty("upload.input.locator");

        By inputElementLocator = By.id(inputLocator);

        ObjectImporterPage importer = new ObjectImporterPage(driverPath, websiteUrl);

        try {
            importer.startBrowser();
            importer.uploadFile(filePath, inputElementLocator);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Erro durante a execução: " + e.getMessage());
        } finally {
            importer.closeBrowser();
        }
    }
}