package com.inventsys.pages;

import com.inventsys.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ObjectImporterPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(ObjectImporterPage.class);

    // Locators Reader
    ConfigReader locatorsReader = new ConfigReader("locators.properties");

    // Locators
    String inputLocator = locatorsReader.getProperty("choose.input.locator");
    String uploadLocator = locatorsReader.getProperty("click.upload.locator");
    String getFeedbackMessage = locatorsReader.getProperty("get.upload.feedback.message");

    By inputElementLocator = By.id(inputLocator);
    By clickUploadLocator = By.id(uploadLocator);
    By getMessage = By.tagName(getFeedbackMessage);

    public ObjectImporterPage(WebDriver driver) {
        super(driver);
    }

    public void uploadFile(String filePath) {
        try {
            chooseFile(filePath);
            clickOnUpload();
            logger.info("File sent successfully");
        } catch (Exception e) {
            logger.error("Error uploading the file: {}", e.getMessage(), e);
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

    public String getMessageFromUpload(){
        WebElement h3Element = driver.findElement(getMessage);
        return h3Element.getText();
    }
}