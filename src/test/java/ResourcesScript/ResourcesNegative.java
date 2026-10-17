package ResourcesScript;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClassUtility.BaseClass;
import GenericUtility.TakingScreenShot;
import PomClassesUtility.ResourcesPom;

public class ResourcesNegative extends BaseClass {
    
    @BeforeMethod(groups = {"negative"})
    public void loginBeforeTest() throws Exception
    {
        loginToApplication();
    }
    
    // TC-RESOURCES-09
    // Search using a nonexistent file name
    @Test(groups = {"negative"})
    public void nonExistFile() throws Exception
    {
        ResourcesPom resource = new ResourcesPom(driver);

        resource.getResourcesBtn();

        Assert.assertTrue(resource.viewRes(), "Resources page was not opened even after login");
        Reporter.log("Resources page was successfully displayed after login");

        String filename = "missing-file-123.pdf";

        resource.searchFileByName(filename);

        TakingScreenShot ts = new TakingScreenShot();
        ts.getSC(driver, "ResourcesNegative1");

        Assert.assertFalse(resource.isFileDisplayed(filename), "Non existent file name is displayed");
        Reporter.log("Non existent file name is not displayed");
    }

    // TC-RESOURCES-15
    // Duplicate file denied
    @Test(groups = {"negative"})
    public void fileExist() throws Exception
    {
        ResourcesPom resource = new ResourcesPom(driver);

        resource.getResourcesBtn();

        Assert.assertTrue(resource.viewRes(), "Resources page was not opened even after login");
        Reporter.log("Resources page was successfully displayed after login");

        resource.getUploadBtn();
        resource.getChoose("C:\\shashank\\Capgemini_Training\\ninza-sprint\\src\\main\\resources\\DDT\\BatchExecution_TestNG_Report.html");
        resource.getUploadFile();

        Assert.assertTrue(resource.alreadyExist(), "File does not already exist");
        Reporter.log("Already existing file cannot be uploaded");

        String errorText = resource.getError();
        Reporter.log("Error message displayed: " + errorText);

        TakingScreenShot ts = new TakingScreenShot();
        ts.getSC(driver, "ResourcesNegative2");

    }
}
