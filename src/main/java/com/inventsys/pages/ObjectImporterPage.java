package com.inventsys.pages;

import com.inventsys.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObjectImporterPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(ObjectImporterPage.class);

    // Properties File Paths
    String locatorsFilePath = "src/test/resources/locators.properties";

    // Locators
    ConfigReader locatorsReader = new ConfigReader(locatorsFilePath);
    String inputLocator = locatorsReader.getProperty("choose.input.locator");
    String uploadLocator = locatorsReader.getProperty("click.upload.locator");


    By inputElementLocator = By.id(inputLocator);
    By clickUploadLocator = By.id(uploadLocator);

    public ObjectImporterPage(WebDriver driver) {
        super(driver);
    }

    public void uploadFile(String filePath) {
        try {
            chooseFile(filePath);
            clickOnUpload();
            logger.info("Arquivo enviado com sucesso!");
            //System.out.println("Arquivo enviado com sucesso!");
        } catch (Exception e) {
            logger.error("Erro ao enviar o arquivo: {}", e.getMessage(), e);
            //System.out.println("Erro ao enviar o arquivo: " + e.getMessage());
        }
    }

    public void chooseFile(String filePath){
        WebElement fileInput = driver.findElement(inputElementLocator);
        fileInput.sendKeys(filePath);
    }

    public void clickOnUpload(){
        WebElement upload = driver.findElement(clickUploadLocator);
        upload.click();
    }
}