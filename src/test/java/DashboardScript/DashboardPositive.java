package DashboardScript;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClassUtility.BaseClass;
import PomClassesUtility.DashboardPom;
import PomClassesUtility.LoginPom;

public class DashboardPositive extends BaseClass {
    
    @BeforeMethod(groups = {"functionality", "system"})
    public void loginBeforeTest() throws Exception
    {
        loginToApplication();
    }

    // TC-DASH-02
    // Verify all are visible in dashboard
    @Test(groups = {"functionality"})
    public void verifyDashboard()
    {
        DashboardPom dash = new DashboardPom(driver);

        Assert.assertTrue(dash.isEmployeeschartDisplayed(), "Employees chart is not displayed even after login");
        Reporter.log("Employees chart is successfully displayed");

        Assert.assertTrue(dash.isProjectschertDisplayed(), "Projects chart is not displayed even after login");
        Reporter.log("Projects chart is successfully displayed");
    }

    // TC-DASH-13
    // Logout workflow
    @Test(groups = {"system"})
    public void verifyDashLogout()
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
    }
}
