package LoginScript;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import BaseClassUtility.BaseClass;
import GenericUtility.ExcelUtility;
import PomClassesUtility.DashboardPom;
import PomClassesUtility.LoginPom;

public class LoginPositive extends BaseClass {

    // TC-Login-01
    // Verify sign-in page loads with all controls
    @Test(groups = {"smoke"})
    public void verifyIsDisplayed()
    {
        LoginPom login = new LoginPom(driver);

        Assert.assertTrue(login.isUsernameDisplayed(), "Username field is not displayed.");
        Assert.assertTrue(login.isPasswordDisplayed(), "Password field is not displayed.");
        Assert.assertTrue(login.isLoginButtonDisplayed(), "Signin button is not displayed.");
        Assert.assertTrue(login.isgetDemoDisplayed(), "Get Demo is not displayed");

        Reporter.log("Username field is displayed");
        Reporter.log("Password field is displayed");
        Reporter.log("Signin button is displayed");
        Reporter.log("Get Demo is displayed");
        Reporter.log("All the fields i.e Username, Password, Signin Button, Get Demo in login page is successfully displayed");

    }

    // TC-LOGIN-02
    // Login with valid credentials lands on dashboard overview
    @Test(groups = {"integration"})
    public void validLoginTest() throws Exception {
        ExcelUtility ex = new ExcelUtility();
        LoginPom login = new LoginPom(driver);

        String username = ex.excelUtility("sheet1", 1, 0);
        String password = ex.excelUtility("sheet1", 1, 1);

        login.getUsername(username);
        login.getPassword(password);
        login.getLoginButton();

        Assert.assertTrue(login.isDashboardDisplayed(),"Dashboard Page was not displayed for user: " + username);

        Reporter.log("Valid Login Successful");
        Reporter.log("Username = " + username);
    }

    // TC-LOGIN-11
    // Verify logout ends the session
    @Test(groups = {"system"})
    public void logoutEndsSession() throws Exception
    {
        ExcelUtility ex = new ExcelUtility();
        LoginPom login = new LoginPom(driver);
        DashboardPom dash = new DashboardPom(driver);

        String username = ex.excelUtility("sheet1", 1, 0);
        String password = ex.excelUtility("sheet1", 1, 1);

        login.getUsername(username);
        login.getPassword(password);
        login.getLoginButton();

        Assert.assertTrue(login.isDashboardDisplayed(),"Dashboard Page was not displayed for user: " + username);

        Reporter.log("Valid Login Successful");
        Reporter.log("Username = " + username);

        dash.getLogout();

        Assert.assertTrue(login.isLoginButtonDisplayed(), "User is not loged out of the session even after clicking logout");
        Reporter.log("User successfully loged out of the session after clicking logout button");

    }
}
