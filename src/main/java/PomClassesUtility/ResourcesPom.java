package PomClassesUtility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

    @FindBy (xpath = "//h2[text()='View']")
    private WebElement viewResources;

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

    @FindBy (xpath = "//div[@class='Toastify__toast Toastify__toast--error']")
    private WebElement error;

    public void getResourcesBtn()
    {
        resourcesBtm.click();
    }
    public boolean viewRes()
    {
        return viewResources.isDisplayed();
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
    public void getChoose(String value)
    {
        chooseFile.sendKeys(value);
    }
    public void getCancelUpload()
    {
        cancelUpload.click();
    }
    public void getUploadFile()
    {
        wait.until(ExpectedConditions.elementToBeClickable(uploadFile)).click();
    }
    public void getDeleteBtn()
    {
        deleteBtn.click();
    }
    public void getDownloadBtn()
    {
        downloadBtn.click();
    }
    public void searchFileByName(String fileName)
    {
        wait.until(ExpectedConditions.visibilityOf(search));

        Select dropdown = new Select(search);
        dropdown.selectByVisibleText("Search by File Name");

        WebElement name = wait.until(ExpectedConditions.visibilityOf(typeFileName));

        name.clear();
        name.sendKeys(fileName);
    }
    public void searchFileByDate(String date)
    {
        wait.until(ExpectedConditions.visibilityOf(search));

        Select dropdown = new Select(search);
        dropdown.selectByVisibleText("Search by Upload Date");

        WebElement dateField = wait.until(ExpectedConditions.visibilityOf(typeFileDate));

        dateField.clear();
        dateField.sendKeys(date);
    }
    public boolean isFileDisplayedByDate(String fileName)
    {
        By fileRow = By.xpath("//div[@class='table-wrapper']//tr[.//*[normalize-space(.)='"+ fileName + "']]");
        try
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(fileRow));
            return true;
        }
        catch (TimeoutException e)
        {
            return false;
        }
    }
    public boolean isFileDisplayed(String fileName)
    {
        By fileRow = By.xpath("//div[@class='table-wrapper']//tr[.//*[normalize-space(.)='"+ fileName + "']]");
        try
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(fileRow));
            return true;
        }
        catch (TimeoutException e)
        {
            return false;
        }
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
    public String getError()
    {
        return error.getText();
    }
    public boolean alreadyExist()
    {
        return error.isDisplayed();
    }

}
