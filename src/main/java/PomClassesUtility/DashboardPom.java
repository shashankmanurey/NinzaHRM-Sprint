package PomClassesUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPom {
    WebDriver driver; 
    WebDriverWait wait;
    public DashboardPom(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//a[text()='Dashboard']")
    private WebElement dashboardBtn;

    @FindBy (css = "div.chart-card-left")
    private WebElement employeesChart;

    @FindBy(css = "div.chart-card-right")
    private WebElement projectsChart;

    public boolean isEmployeeschartDisplayed()
    {
        return wait.until(ExpectedConditions.visibilityOf(employeesChart)).isDisplayed();
    }
    public boolean isProjectschertDisplayed()
    {
        return wait.until(ExpectedConditions.visibilityOf(projectsChart)).isDisplayed();
    }
}
