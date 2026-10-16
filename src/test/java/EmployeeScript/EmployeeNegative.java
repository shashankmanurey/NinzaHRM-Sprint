package EmployeeScript;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClassUtility.BaseClass;
import GenericUtility.ExcelUtility;
import GenericUtility.TakingScreenShot;
import PomClassesUtility.EmployeePom;

public class EmployeeNegative extends BaseClass {

    @BeforeMethod(groups = {"negative"})
    public void loginBeforeTest() throws Exception
    {
        loginToApplication();
    }

    // TC-EMP-05
    // Attempt to add an employee who already exists
    @Test(groups ={"negative"})
    public void verifyEmpAlreadyExist() throws Exception
    {
        EmployeePom employee = new EmployeePom(driver);
        ExcelUtility ex = new ExcelUtility();

        employee.getEmployee();
        employee.getAddEmp();

        String name = ex.excelUtility("Sheet3", 1, 0);
        String email = ex.excelUtility("Sheet3", 1, 1);
        String phone = ex.excelUtility("Sheet3", 1, 2);
        String uname = ex.excelUtility("Sheet3", 1, 3);
        String des = ex.excelUtility("Sheet3", 1, 4);
        String exp = ex.excelUtility("Sheet3", 1, 5);
        String pro = ex.excelUtility("Sheet3", 1, 6);

        employee.getTypeAllFields(name, email, phone, uname, des, exp, pro);
        employee.getAddBtn();

        Assert.assertTrue(employee.isEmployeeNotAddedDisplayed(),"Expected duplicate employee rejection message was not displayed.");
        Reporter.log("Application rejected duplicate employee details.");

        TakingScreenShot ts = new TakingScreenShot();
        ts.getSC(driver, "EmployeeNegative1");
    }
}
