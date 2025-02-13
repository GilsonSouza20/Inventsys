package com.inventsys.tests;

import com.inventsys.pages.ObjectImporterPage;
import com.inventsys.utils.ConfigReader;
import com.inventsys.utils.GenerateAbsolutePath;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.inventsys.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ObjectImporterTest {

    private static final Logger logger = LoggerFactory.getLogger(ObjectImporterTest.class);

    private ObjectImporterPage objectImporterPage;
    public ConfigReader properties;
    public GenerateAbsolutePath getAbsolutePath;

    @BeforeEach
    public void setUp() {
        properties = new ConfigReader("config.properties");
        getAbsolutePath = new GenerateAbsolutePath();
        WebDriver driver = DriverFactory.getDriver();
        driver.get(properties.getProperty("website.url"));
        objectImporterPage = new ObjectImporterPage(driver);
    }

    @Test
    public void testUploadFileSuccess() {
        String relativePath = properties.getProperty("upload.file.path");

        String absolutePath = getAbsolutePath.generateAbsolutePath(relativePath);

        objectImporterPage.uploadFile(absolutePath);

        assertNotNull(objectImporterPage.getMessageFromUpload(),
                "A mensagem de sucesso não foi exibida na página!");

        assertTrue(objectImporterPage.getMessageFromUpload().contains("File Uploaded!"),
                "A mensagem de sucesso está incorreta. Mensagem atual: "
                        + objectImporterPage.getMessageFromUpload());

        logger.info(objectImporterPage.getMessageFromUpload());
    }

    @AfterEach
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}