package PomClassesUtility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeePom 
{
    WebDriver driver;
    WebDriverWait wait;
    public EmployeePom(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//a[text()='Employees']")
    private WebElement employeeBtm;

    @FindBy (xpath = "//h2[text()='Manage ']")
    private WebElement manageEmp;

    @FindBy (xpath = "//div[@class='table-wrapper']")
    private WebElement empTable;

    @FindBy (xpath = "//select[@class='form-control']")
    private WebElement search; 

    @FindBy (xpath = "//option[text()='Search by Name']")
    private WebElement searchName;

    @FindBy (xpath = "//option[text()='Search by Email']")
    private WebElement searchEmail;

    @FindBy (xpath = "//option[text()='Search by Phone']")
    private WebElement searchPhone;

    @FindBy (xpath = "//input[@type='text' and @placeholder='Search by Employee Name']")
    private WebElement typeName;

    @FindBy (xpath = "//input[@type='text' and @placeholder='Search by Email']")
    private WebElement typeEmail;

    @FindBy (xpath = "//input[@type='text' and @placeholder='Search by Phone']")
    private WebElement typePhone;

    @FindBy(xpath = "//input[starts-with(@id,'checkbox_')]")
    private List<WebElement> employeeCheckboxes;

    @FindBy (xpath = "//a[@href='#deleteEmployeeModal']")
    private WebElement deleteBtn;

    @FindBy (xpath = "//input[@value='Delete']")
    private WebElement confirmDeleteBtn;

    @FindBy (xpath = "//span[text()='Add New Employee']")
    private WebElement addempBtn;

    @FindBy (xpath = "//h4[text()='Add Employee']")
    private WebElement addEmpDisp;

    @FindBy (xpath = "//label[normalize-space()='Name*']/following::input[1]")
    private WebElement nameField;

    @FindBy (xpath = "//label[normalize-space()='Email*']/following::input[1]")
    private WebElement emailField;

    @FindBy (xpath = "//label[normalize-space()='Phone*']/following::input[1]")
    private WebElement phoneField;

    @FindBy (xpath = "//label[normalize-space()='Username*']/following::input[1]")
    private WebElement usernameField;

    @FindBy (xpath = "//label[normalize-space()='Designation*']/following::input[1]")
    private WebElement desigField;

    @FindBy (xpath = "//label[normalize-space()='Experience*']/following::input[1]")
    private WebElement expField;
    
    @FindBy (xpath = "//label[normalize-space()='Project*']/following::select[1]")
    private WebElement projectBtn;

    @FindBy (xpath = "(//input[@type='button' and @class='btn btn-default' and @value='Cancel'])[3]")
    private WebElement cancelBtn;

    @FindBy (xpath = "//input[@value='Add']")
    private WebElement addBtn;

    @FindBy (xpath = "//button[@class='close']")
    private WebElement closeBtn;

    @FindBy (xpath = "//input[@value='Delete']")
    private WebElement confirmDelete;

    @FindBy (xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-right']")
    private WebElement deletePopUp;

    @FindBy (xpath = "(//input[@type='text'])[2]")
    private WebElement editName;

    @FindBy (xpath = "//input[@type='email']")
    private WebElement editEmail;

    @FindBy (xpath = "//input[@type='number']")
    private WebElement editExp;

    @FindBy (xpath = "(//input[@type='text'])[3]")
    private WebElement editPhone;

    @FindBy (xpath = "//input[@value='Save']")
    private WebElement saveEdits;

    public void getEmployee()
    {
        wait.until(ExpectedConditions.elementToBeClickable(employeeBtm)).click();
    }
    public boolean isMngEmpDisplayed()
    {
        return manageEmp.isDisplayed();
    }
    public boolean isEmpTableDisplayed()
    {
        return empTable.isDisplayed();
    }
    public void getSearch()
    {
        search.click();
    }
    public void getByName()
    {
        searchName.click();
    }
    public void getByEmail()
    {
        searchEmail.click();
    }
    public void getByPhone()
    {
        searchPhone.click();
    }
    public void getAddEmp()
    {
        addempBtn.click();
    }
    public boolean isAddEmpDisp()
    {
        return addEmpDisp.isDisplayed();
    }
    public void getDelete()
    {
        deleteBtn.click();
    }
    public void getConfirmDelete()
    {
        confirmDeleteBtn.click();
    }
    public void getprojectBtn()
    {
        projectBtn.click();
    }
    public void getAddBtn()
    {
        addBtn.click();
    }
    public void getCancelBtn()
    {
        cancelBtn.click();
    }
    public void getCloseBtn()
    {
        closeBtn.click();
    }
    public void getConfirmDeleteSingle()
    {
        wait.until(ExpectedConditions.elementToBeClickable(confirmDelete)).click();
    }
    public boolean getConfirmDeletePopup()
    {
        return wait.until(ExpectedConditions.visibilityOf(deletePopUp)).isDisplayed();
    }

    public boolean isSearchVisible() {
    try {
        return wait.until(ExpectedConditions.visibilityOf(search)).isDisplayed();
        } catch (org.openqa.selenium.TimeoutException e) {
        return false;
    }
    }
    public void getTypeName(String value)
    {
        WebElement name = wait.until(ExpectedConditions.visibilityOf(typeName));
        name.clear();
        name.sendKeys(value);
    }
    public void getTypeEmail(String value)
    {
        WebElement email = wait.until(ExpectedConditions.visibilityOf(typeEmail));
        email.clear();
        email.sendKeys(value);
    }
    public void getTypePhone(String value)
    {
        WebElement phone = wait.until(ExpectedConditions.visibilityOf(typePhone));
        phone.clear();
        phone.sendKeys(value);
    }
    public void getTypeAllFields (String name, String email, String phone, String uname, String desg, String exp, String pro)
    {
        wait.until(ExpectedConditions.visibilityOf(nameField)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(phoneField)).sendKeys(phone);
        wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(uname);
        wait.until(ExpectedConditions.visibilityOf(desigField)).sendKeys(desg);
        wait.until(ExpectedConditions.visibilityOf(expField)).sendKeys(exp);
        wait.until(ExpectedConditions.visibilityOf(projectBtn)).sendKeys(pro);
    }
    
    public void searchEmployee(String name) {wait.until(ExpectedConditions.visibilityOf(search));

        new Select(search).selectByVisibleText("Search by Name");
        WebElement searchField =wait.until(ExpectedConditions.visibilityOf(typeName));

        searchField.clear();
        searchField.sendKeys(name);
    }
    public void searchEmployeeEmail(String email) {wait.until(ExpectedConditions.visibilityOf(search));

        new Select(search).selectByVisibleText("Search by Email");
        WebElement searchField =wait.until(ExpectedConditions.visibilityOf(typeEmail));

        searchField.clear();
        searchField.sendKeys(email);
    }
    public void searchEmployeePhone(String phone) {wait.until(ExpectedConditions.visibilityOf(search));

        new Select(search).selectByVisibleText("Search by Phone");
        WebElement searchField =wait.until(ExpectedConditions.visibilityOf(typePhone));

        searchField.clear();
        searchField.sendKeys(phone);
    }

    public boolean isEmployeeDisplayed(String name) {By employeeRow = By.xpath("//div[@class='table-wrapper']//tr[.//*[normalize-space(.)='"+ name + "']]");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(employeeRow));
            return true;
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }
    public boolean isEmployeeEmailDisplayed(String email) {By employeeRow = By.xpath("//div[@class='table-wrapper']//tr[.//*[normalize-space(.)='"+ email + "']]");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(employeeRow));
            return true;
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }
    public boolean isEmployeePhoneDisplayed(String phone) {By employeeRow = By.xpath("//div[@class='table-wrapper']//tr[.//*[normalize-space(.)='"+ phone + "']]");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(employeeRow));
            return true;
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }
    public boolean isEmployeeNotAddedDisplayed() {
        By errorToast = By.cssSelector(".Toastify__toast--error");
        try {
            new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(errorToast));
            return true;
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }
    public void selectProject(String projectName) 
    {
        wait.until(ExpectedConditions.visibilityOf(projectBtn));
        new Select(projectBtn).selectByVisibleText(projectName);
    }
    public void selectEmployeeByUsername(String username) {
        driver.findElement(By.xpath("//*[normalize-space()='" + username + "']/ancestor::tr//input[@type='checkbox']")).click();
    }
    public void clickEditByValue(String value)
    {
        By editIcon = By.xpath("//tr[.//td[normalize-space()='" + value+ "']]//a[contains(@class,'edit')]");
        wait.until(ExpectedConditions.elementToBeClickable(editIcon)).click();
    }
    public void clickDeleteByValue(String value)
    {
        By deleteIcon = By.xpath("//tr[.//td[normalize-space()='" + value+ "']]//a[contains(@class,'delete')]");
        wait.until(ExpectedConditions.elementToBeClickable(deleteIcon)).click();
    }
    public void editEmpDetails(String name, String email, String exp, String phone) throws InterruptedException
    {
        editName.clear();
        editEmail.clear();
        editExp.clear();
        editPhone.clear();
        Thread.sleep(3000);
        editName.sendKeys(name);
        editEmail.sendKeys(email);
        editExp.sendKeys(exp);
        editPhone.sendKeys(phone);
    }
    public void getEditEmps()
    {
        saveEdits.click();
    }
}
