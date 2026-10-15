package PomClassesUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPom {
    WebDriver driver;
    public LoginPom(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (id = "username")
    private WebElement username;

    @FindBy (xpath = "//div[text()='Username is required']")
    private WebElement usernameReq;

    @FindBy (xpath = "//div[text()='Password is required']")
    private WebElement passwordReq;

    @FindBy (id = "inputPassword")
    private WebElement password;

    @FindBy (xpath = "//button[@type='submit']")
    private WebElement loginBtn;

    @FindBy (xpath = "//a[text()='Dashboard']")
    private WebElement dash;

    @FindBy (id = "request-demo")
    private WebElement reqDemo;
    
    @FindBy (xpath = "//div[text()='Demo Request']")
    private WebElement reqPage;

    //Getters
    public void getUsername(String value)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement user = wait.until(ExpectedConditions.elementToBeClickable(username));
        user.clear();
        user.sendKeys(value);
    }
    public void getPassword(String value)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement pass = wait.until(ExpectedConditions.elementToBeClickable(password));
        pass.clear();
        pass.sendKeys(value);
    }
    public void getLoginButton()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        button.click();
    }
    public void getDemo()
    {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement demo = wait.until(ExpectedConditions.elementToBeClickable(reqDemo));
        demo.click();
    }


    public boolean isUsernameDisplayed()
    {
        return username.isDisplayed();
    }
    public boolean isPasswordDisplayed()
    {
        return password.isDisplayed();
    }
    public boolean isLoginButtonDisplayed()
    {
        return loginBtn.isDisplayed();
    }
    public boolean isDashboardDisplayed()
    {
        return dash.isDisplayed();
    }
    public boolean isgetDemoDisplayed()
    {
        return reqDemo.isDisplayed();
    }
    public boolean isDemoPageDisplayed()
    {
        return reqPage.isDisplayed();
    }
    public boolean isUserReqDisplayed()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement userwait = wait.until(ExpectedConditions.visibilityOf(usernameReq));
        return userwait.isDisplayed();
    }
    public boolean isPassReqDisplayed()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement passwait = wait.until(ExpectedConditions.visibilityOf(passwordReq));
        return passwait.isDisplayed();
    }
}
