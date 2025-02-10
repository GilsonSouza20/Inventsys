package com.inventsys.tests;

import com.inventsys.pages.ObjectImporterPage;
import com.inventsys.utils.ConfigReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import com.inventsys.factory.DriverFactory;
import org.openqa.selenium.WebDriver;

public class ObjectImporterTest {
    private WebDriver driver;
    private ObjectImporterPage objectImporterPage;
    public ConfigReader properties;
    public ConfigReader locators;
    public String configFile = "src/test/resources/config.properties";
    public String locatorsFile = "src/test/resources/locators.properties";

    @BeforeEach
    public void setUp() {
        properties = new ConfigReader(configFile);
        locators = new ConfigReader(locatorsFile);
        driver = DriverFactory.getDriver();
        driver.get(properties.getProperty("website.url"));
        objectImporterPage = new ObjectImporterPage(driver);
    }

    @Test
    public void testUploadFile() {
        String filePath = properties.getProperty("upload.file.path");
        By inputElementLocator = By.id(locators.getProperty("choose.input.locator"));
        By clickUploadLocator = By.id(locators.getProperty("click.upload.locator"));
        objectImporterPage.uploadFile(filePath, inputElementLocator, clickUploadLocator);
    }

    @AfterEach
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}