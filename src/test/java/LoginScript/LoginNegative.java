package LoginScript;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import org.testng.annotations.Test;

import BaseClassUtility.BaseClass;
import GenericUtility.ExcelUtility;
import GenericUtility.TakingScreenShot;
import PomClassesUtility.LoginPom;

public class LoginNegative extends BaseClass {
    
    // TC-LOGIN-03
    // Submit login with both fields empty
    @Test(groups = {"negative"})
    public void emptyFields() throws Exception {

        ExcelUtility ex = new ExcelUtility();
        LoginPom login = new LoginPom(driver);

        String username = ex.excelUtility("Sheet2", 1, 0);
        String password = ex.excelUtility("Sheet2", 1, 1);

        login.getUsername(username);
        login.getPassword(password);
        login.getLoginButton();

        Assert.assertTrue(login.isUserReqDisplayed(), "Dashboard should not be displayed for empty credentials " + username);

        TakingScreenShot ts = new TakingScreenShot();
        ts.getSC(driver, "LoginNegative1");

        Reporter.log("Invalid credentials");
        Reporter.log("Username = " + username + " Password = " + password);
        Reporter.log("Invalid credentials");
        Reporter.log("Login did not occur due to blank credentials");
    }

    // TC-LOGIN-04
    // Login with an invalid username
    @Test(groups = {"negative"})
    public void invalidUsername() throws Exception {
        ExcelUtility ex = new ExcelUtility();
        LoginPom login = new LoginPom(driver);

        String username = ex.excelUtility("sheet2", 2, 0);
        String password = ex.excelUtility("sheet2", 2, 1);

        login.getUsername(username);
        login.getPassword(password);
        login.getLoginButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String message = alert.getText();

        Assert.assertEquals(message, "Invalid Credentials", "Expected invalid credentials alert was not displayed");
        alert.accept();

        TakingScreenShot ts = new TakingScreenShot();
        ts.getSC(driver, "LoginNegative2");

        Reporter.log("Invalid credentials");
        Reporter.log("Username = " + username + " Password = " + password);
        Reporter.log("Invalid credential");
        Reporter.log("Login did not occur due to invalid username");
    }

    // TC-LOGIN-05
    // Login with an invalid password
    @Test(groups = {"negative"})
    public void invalidPassword() throws Exception {

        ExcelUtility ex = new ExcelUtility();
        LoginPom login = new LoginPom(driver);
        
        String username = ex.excelUtility("sheet2", 3, 0);
        String password = ex.excelUtility("sheet2", 3, 1);

        login.getUsername(username);
        login.getPassword(password);
        login.getLoginButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String message = alert.getText();

        Assert.assertEquals(message, "Invalid Credentials", "Expected invalid credentials alert was not displayed");
        alert.accept();

        TakingScreenShot ts = new TakingScreenShot();
        ts.getSC(driver, "LoginNegative2");

        Reporter.log("Invalid credentials");
        Reporter.log("Username = " + username + " Password = " + password);
        Reporter.log("Invalid credential");
        Reporter.log("Login did not occur due to invalid username");
    }

    // TC-LOGIN-06
    // Login with username only (password blank)
    @Test(groups = {"negative"})
    public void blankPassword() throws Exception {

        ExcelUtility ex = new ExcelUtility();
        LoginPom login = new LoginPom(driver);
        
        String username = ex.excelUtility("sheet2", 4, 0);
        String password = ex.excelUtility("sheet2", 4, 1);

        login.getUsername(username);
        login.getPassword(password);
        login.getLoginButton();

        Assert.assertTrue(login.isPassReqDisplayed(), "Dashboard should not be displayed for empty credentials " + username);

        TakingScreenShot ts = new TakingScreenShot();
        ts.getSC(driver, "LoginNegative3");

        Reporter.log("Invalid credentials");
        Reporter.log("Username = " + username + " Password = " + password);
        Reporter.log("Invalid credential");
        Reporter.log("Login did not occur due to blank");
    }

    // TC-LOGIN-07
    // Login with passowrd only (username blank)
    @Test(groups = {"negative"})
    public void blankUsername() throws Exception {

        ExcelUtility ex = new ExcelUtility();
        LoginPom login = new LoginPom(driver);
        
        String username = ex.excelUtility("sheet2", 5, 0);
        String password = ex.excelUtility("sheet2", 5, 1);

        login.getUsername(username);
        login.getPassword(password);
        login.getLoginButton();

        Assert.assertTrue(login.isUserReqDisplayed(), "Dashboard should not be displayed for empty credentials " + username);

        TakingScreenShot ts = new TakingScreenShot();
        ts.getSC(driver, "LoginNegative3");

        Reporter.log("Invalid credentials");
        Reporter.log("Username = " + username + " Password = " + password);
        Reporter.log("Invalid credential");
        Reporter.log("Login did not occur due to blank");
    }
}
