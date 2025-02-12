package com.inventsys.tests;

import com.inventsys.pages.ObjectImporterPage;
import com.inventsys.utils.ConfigReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.inventsys.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ObjectImporterTest {

    private static final Logger logger = LoggerFactory.getLogger(ObjectImporterTest.class);

    private ObjectImporterPage objectImporterPage;
    public ConfigReader properties;

    @BeforeEach
    public void setUp() {
        properties = new ConfigReader("config.properties");
        WebDriver driver = DriverFactory.getDriver();
        driver.get(properties.getProperty("website.url"));
        objectImporterPage = new ObjectImporterPage(driver);
    }

    @Test
    public void testUploadFileSuccess() {
        String filePath = properties.getProperty("upload.file.path");
        objectImporterPage.uploadFile(filePath);

        assertNotNull(objectImporterPage.
                getMessageFromUpload(), "The success message was not displayed on the page!");

        assertTrue(objectImporterPage.
                getMessageFromUpload()
                .contains("File Uploaded!"),
                "The success message is incorrect. Current message: "
                        + objectImporterPage.getMessageFromUpload());

        logger.info(objectImporterPage.getMessageFromUpload());
    }

    @AfterEach
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}