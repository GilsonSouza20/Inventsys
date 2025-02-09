package com.inventsys.tests;

//public class ObjectImporterTest {
//}
import com.inventsys.pages.ObjectImporterPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ObjectImporterTest {
    private ObjectImporterPage objectImporterPage;

    @BeforeEach
    public void setUp() {
        String driverPath = "drivers/chromedriver.exe";
        String websiteUrl = "https://exemplo.com/upload";
        objectImporterPage = new ObjectImporterPage(driverPath, websiteUrl);
        objectImporterPage.startBrowser();
    }

    @Test
    public void testUploadFile() {
        String filePath = "src/test/resources/testdata/arquivo.txt"; // Caminho do arquivo
        By inputElementLocator = By.id("file-input"); // Localizador do input de arquivo
        objectImporterPage.uploadFile(filePath, inputElementLocator);
    }

    @AfterEach
    public void tearDown() {
        objectImporterPage.closeBrowser();
    }
}