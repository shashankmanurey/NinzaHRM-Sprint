package EmployeeScript;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClassUtility.BaseClass;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import PomClassesUtility.EmployeePom;

public class EmployeePositive extends BaseClass {
    @BeforeMethod(groups = {"smoke", "functionality"})
    public void loginBeforeTest() throws Exception
    {
        loginToApplication();
    }
    // TC-EMP-01
    // Verify Employees page opens
    @Test(groups = {"smoke"})
    public void verifyEmpPage()
    {
        EmployeePom employee = new EmployeePom(driver);

        employee.getEmployee();

        Assert.assertTrue(employee.isMngEmpDisplayed(), "Manage Employee page is not displayed after clicking on Employees");
        Reporter.log("Manage Employees is displayed after clicking on Employees");

        Assert.assertTrue(employee.isEmpTableDisplayed(), "Employee table is not displayed after clicking on Employees");
        Reporter.log("Employees table is displayed after clicking on Employees");
    }
    
    // TC-EMP-03
    // Verify Add New Employee form opens
    @Test(groups = {"functionality"})
    public void verifyAddEmpPage()
    {
        EmployeePom employee = new EmployeePom(driver);

        employee.getEmployee();
        employee.getAddEmp();

        Assert.assertTrue(employee.isAddEmpDisp(), "Add New Employee form does not open after clicking Add New Employee");
        Reporter.log("Add New Employee form opens after clicking Add New Employee");

    }

    // TC-EMP-04
    // Add employee with valid details
    @Test(groups = {"functionality"})
    public void addNewEmp() throws Exception
    {
        EmployeePom employee = new EmployeePom(driver);
        ExcelUtility ex = new ExcelUtility();
        JavaUtility ju = new JavaUtility();

        employee.getEmployee();
        employee.getAddEmp();

        String name = ex.excelUtility("Sheet3", 1, 0);
        String email = ex.excelUtility("Sheet3", 1, 1);
        String phone = ex.excelUtility("Sheet3", 1, 2);
        String uname = ex.excelUtility("Sheet3", 1, 3) + ju.generateRandomNum();
        String des = ex.excelUtility("Sheet3", 1, 4);
        String exp = ex.excelUtility("Sheet3", 1, 5);
        String pro = ex.excelUtility("Sheet3", 1, 6);

        ex.writeDataInExcel("Sheet3", 1, 3, uname);

        employee.getTypeAllFields(name, email, phone, uname, des, exp, pro);
        employee.getAddBtn();

        Thread.sleep(3000);
        driver.navigate().refresh();
        employee.searchEmployee(name);

        Assert.assertTrue(employee.isEmployeeDisplayed(name), "Employee was not found after saving: " + name);
        Reporter.log("Added new valid employee with all details of employee:" + name);
    } 
}
