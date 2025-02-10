package com.inventsys.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ObjectImporterPage extends BasePage{

    public ObjectImporterPage(WebDriver driver) {
        super(driver);
    }

    public void uploadFile(String filePath, By inputElementLocator, By sendUploadFile) {
        try {
            WebElement fileInput = driver.findElement(inputElementLocator);
            fileInput.sendKeys(filePath);
            WebElement upload = driver.findElement(sendUploadFile);
            upload.click();
            System.out.println("Arquivo enviado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao enviar o arquivo: " + e.getMessage());
        }
    }
}

