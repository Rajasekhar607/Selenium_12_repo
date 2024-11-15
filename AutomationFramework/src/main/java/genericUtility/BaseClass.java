package genericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.WelcomePage;

public class BaseClass {
	public static ExtentReports extReport;
	public WebDriver driver;
	public static ExtentTest test;
	public static WebDriver sdriver;
	
	public javaUtility jUtil=new javaUtility();
	public webDriverUtility wUtil=new webDriverUtility();
	public FileUtility fUtil=new  FileUtility();
	public ExcelUtility eUtil=new ExcelUtility();
	
	public WelcomePage wp;
	public LoginPage lp;
	public HomePage hp;
	
@BeforeSuite

public void reportConfig() {
	ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports/ExtentReport_"+jUtil.getSystemTime());
			extReport=new ExtentReports();
	extReport.attachReporter(spark);
}
@Parameters("Browser")
@BeforeClass
public void launchBrowser(@Optional("chrome")String browserName) throws IOException {
	if(browserName.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	}
	else if(browserName.equalsIgnoreCase("Firefox")) {
		driver=new FirefoxDriver();
	}
	else if(browserName.equalsIgnoreCase("edge")){
		driver=new EdgeDriver();
	}
	wUtil.maximizeWindow(driver);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get(fUtil.getDatafromProperty("url"));
}
@BeforeMethod
 public void login() {
	 wp=new WelcomePage();
	 wp.getLoginLink().click();
}
 @AfterMethod
 public void logout() {
	 hp=new HomePage(driver);
	 hp.getLogoutLink().click();
 }
	 @AfterClass
	 public void closeBrowser() {
		 driver.quit();
		 
	 }
 
  @AfterSuite
  public void reportBackup() {
	  extReport.flush();
  }
//public void onTestFailure(ITestResult result) {
	// TODO Auto-generated method stub

	
}
	


