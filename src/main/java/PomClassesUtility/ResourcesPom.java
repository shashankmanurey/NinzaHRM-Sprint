package PomClassesUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResourcesPom {
    WebDriver driver;
    WebDriverWait wait;
    public ResourcesPom(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }
    @FindBy (xpath = "//a[text()='Resources']")
    private WebElement resourcesBtm;

    @FindBy (xpath = "//select[@class='form-control']")
    private WebElement search;

    @FindBy (xpath = "//option[text()='Search by File Name']")
    private WebElement searchFileName;

    @FindBy (xpath = "//option[text()='Search by Upload Date']")
    private WebElement searchFileDate;

    @FindBy (xpath = "//input[@type='text' and @placeholder='Search by File Name']")
    private WebElement typeFileName;

    @FindBy (xpath = "//input[@type='text' and @placeholder='Search by Upload Date']")
    private WebElement typeFileDate;

    @FindBy (xpath = "//button[@class='btn btn-info']")
    private WebElement uploadBtn;

    @FindBy(id = "upload-file")
    private WebElement chooseFile;

    @FindBy (xpath = "//button[text()='Cancel']")
    private WebElement cancelUpload;

    @FindBy (xpath = "//button[text()='Upload File']")
    private WebElement uploadFile;

    @FindBy (xpath ="//i[@title='Download']")
    private WebElement downloadBtn;

    @FindBy (xpath = "//i[@title='Delete']")
    private WebElement deleteBtn;

    public void getResourcesBtn()
    {
        resourcesBtm.click();
    }
    public void getSearch()
    {
        search.click();
    }
    public void getSearchFileName()
    {
        searchFileName.click();
    }
    public void getSearchFileDate()
    {
        searchFileDate.click();
    }
    public void getUploadBtn()
    {
        uploadBtn.click();
    }
    public void getChoose()
    {
        chooseFile.click();
    }
    public void getCancelUpload()
    {
        cancelUpload.click();
    }
    public void getUploadFile()
    {
        uploadFile.click();
    }
    public void getDeleteBtn()
    {
        deleteBtn.click();
    }
    public void getDownloadBtn()
    {
        downloadBtn.click();
    }
    public void typeFileName(String value)
    {
        WebElement name = wait.until(ExpectedConditions.visibilityOf(typeFileName));
        name.clear();
        name.sendKeys(value);
    }
    public void typeFileDate(String value)
    {
        WebElement date = wait.until(ExpectedConditions.visibilityOf(typeFileDate));
        date.clear();
        date.sendKeys(value);
    }

}
