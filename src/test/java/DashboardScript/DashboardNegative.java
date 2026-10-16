package DashboardScript;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClassUtility.BaseClass;
import GenericUtility.TakingScreenShot;
import PomClassesUtility.DashboardPom;
import PomClassesUtility.LoginPom;

public class DashboardNegative extends BaseClass {
    
    @BeforeMethod(groups = {"negative"})
    public void loginBeforeTest() throws Exception 
    {
        loginToApplication();
    }

    // TC-DASH-10
    // Attempt to open the dashboard after logout and verify access is denied
    @Test(groups = {"negative"})
    public void verifyReopenDash() throws Exception
    {
        DashboardPom dash = new DashboardPom(driver);
        LoginPom login = new LoginPom(driver);

        Assert.assertTrue(dash.isEmployeeschartDisplayed(), "Employees chart is not displayed even after login");
        Reporter.log("Employees chart is successfully displayed");

        Assert.assertTrue(dash.isProjectschertDisplayed(), "Projects chart is not displayed even after login");
        Reporter.log("Projects chart is successfully displayed");

        dash.getLogout();

        Assert.assertTrue(login.isLoginButtonDisplayed(), "Logout did not occur after clicking on logout button");
        Reporter.log("Logout successfully occured from dashboard page");

        driver.get("http://49.249.29.4:8091/dashboard/overview");

        TakingScreenShot ts = new TakingScreenShot();
        ts.getSC(driver, "DashboardNegative1");

        Assert.assertTrue(login.isLoginButtonDisplayed(), "Unauthenticated user was able to access the dashboard");
        Reporter.log("User cannot access Dashboard page after logout successfully occured from dashboard page, Dashboard access denied after logout");
    }

}
