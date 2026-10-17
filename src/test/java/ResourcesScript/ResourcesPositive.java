package ResourcesScript;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClassUtility.BaseClass;
import PomClassesUtility.ResourcesPom;

public class ResourcesPositive extends BaseClass {
    
    @BeforeMethod(groups = {"smoke", "functionality"})
    public void loginBeforeTest() throws Exception
    {
        loginToApplication();
    }

    // TC-RESOURCES-01
    // Verify Resources page opens
    @Test(groups = {"smoke"})
    public void verifyResPage()
    {
        ResourcesPom resource = new ResourcesPom(driver);

        resource.getResourcesBtn();
        Assert.assertTrue(resource.viewRes(), "Resources page was not opened even after login");
        Reporter.log("Resources page was successfully opened after login");
    }

    // TC-RESOURCES-05
    // Upload a valid PDF file
    @Test(groups = {"functionality"})
    public void uploadFile()
    {
        ResourcesPom resource = new ResourcesPom(driver);

        resource.getResourcesBtn();

        Assert.assertTrue(resource.viewRes(), "Resources page was not opened even after login");
        Reporter.log("Resources page was successfully displayed after login");

        resource.getUploadBtn();
        resource.getChoose("C:\\shashank\\Capgemini_Training\\ninza-sprint\\src\\main\\resources\\DDT\\BatchExecution_TestNG_Report.html");
        resource.getUploadFile();
        Reporter.log("Upload submitted for file" );

        String fileName = "BatchExecution_TestNG_Report.html";
        resource.searchFileByName(fileName);

        Assert.assertTrue(resource.isFileDisplayed(fileName), "Uploaded file was not found: "+ fileName);
        Reporter.log("File uploaded and verified successfully: "+ fileName);
    }
    
}
