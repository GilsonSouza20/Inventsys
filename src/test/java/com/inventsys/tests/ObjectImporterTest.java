package com.inventsys.tests;

import com.inventsys.pages.ObjectImporterPage;
import com.inventsys.utils.ConfigReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.inventsys.factory.DriverFactory;
import org.openqa.selenium.WebDriver;


public class ObjectImporterTest {
    private ObjectImporterPage objectImporterPage;
    public ConfigReader properties;
    public String configFile = "src/test/resources/config.properties";

    @BeforeEach
    public void setUp() {
        properties = new ConfigReader(configFile);
        WebDriver driver = DriverFactory.getDriver();
        driver.get(properties.getProperty("website.url"));
        objectImporterPage = new ObjectImporterPage(driver);
    }

    @Test
    public void testUploadFile() {
        String filePath = properties.getProperty("upload.file.path");
        objectImporterPage.uploadFile(filePath);
    }

    @AfterEach
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}