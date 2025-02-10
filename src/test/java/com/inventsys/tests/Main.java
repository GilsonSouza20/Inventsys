package com.inventsys.tests;

import com.inventsys.factory.DriverFactory;
import com.inventsys.utils.ConfigReader;
import com.inventsys.pages.ObjectImporterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Main {

    public static void main(String[] args) {
        WebDriver driver;

        driver = DriverFactory.getDriver();

        String configFilePath = "src/test/resources/config.properties";
        String locatorsFilePath = "src/test/resources/locators.properties";

        ConfigReader configReader = new ConfigReader(configFilePath);

        String filePath = configReader.getProperty("upload.file.path");

        ConfigReader locatorsReader = new ConfigReader(locatorsFilePath);
        String inputLocator = locatorsReader.getProperty("choose.input.locator");
        String uploadLocator = locatorsReader.getProperty("click.upload.locator");

        By inputElementLocator = By.id(inputLocator);
        By clickUploadLocator = By.id(uploadLocator);

        driver.get(configReader.getProperty("website.url"));

        ObjectImporterPage importer = new ObjectImporterPage(driver);


        try {
            Thread.sleep(2000);
            importer.uploadFile(filePath, inputElementLocator, clickUploadLocator);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Erro durante a execução: " + e.getMessage());
        } finally {
            DriverFactory.quitDriver();
        }
    }
}